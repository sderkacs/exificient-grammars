package com.siemens.ct.exi.grammars;

import java.io.OutputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Changes xsd:annotation element to grammar enumeration string and its content
 * (no affect on XML schema processor)
 * 
 * @author daniel.peintner.ext@siemens.com
 * 
 */
public class GrammarAnnotationFilter implements ContentHandler {

	static final private TransformerFactory tf = TransformerFactory
			.newInstance();
	private ContentHandler ch;
	private boolean rootElement;
//	private final String typeName;
	private final AttributesImpl typeNameAtts;

	public GrammarAnnotationFilter(OutputStream os, String typeName) throws SAXException {
//		this.typeName = typeName;
		
		typeNameAtts = new AttributesImpl();
		typeNameAtts.addAttribute("", "name", "name", "CDATA", typeName);
		
		try {
			final Transformer t = tf.newTransformer();

			t.transform(new SAXSource(new XMLReader() {
				public ContentHandler getContentHandler() {
					return ch;
				}

				public DTDHandler getDTDHandler() {
					return null;
				}

				public EntityResolver getEntityResolver() {
					return null;
				}

				public ErrorHandler getErrorHandler() {
					return null;
				}

				public boolean getFeature(String name) {
					return false;
				}

				public Object getProperty(String name) {
					return null;
				}

				public void parse(InputSource input) {
				}

				public void parse(String systemId) {
				}

				public void setContentHandler(ContentHandler handler) {
					ch = handler;
				}

				public void setDTDHandler(DTDHandler handler) {
				}

				public void setEntityResolver(EntityResolver resolver) {
				}

				public void setErrorHandler(ErrorHandler handler) {
				}

				public void setFeature(String name, boolean value) {
				}

				public void setProperty(String name, Object value) {
				}
			}, new InputSource()), new StreamResult(os));
		} catch (TransformerException e) {
			throw new SAXException(e);
		}

		if (ch == null)
			throw new SAXException("Transformer didn't set ContentHandler");
	}

	public void setDocumentLocator(Locator locator) {
		ch.setDocumentLocator(locator);
	}

	public void startDocument() throws SAXException {
		ch.startDocument();
		rootElement = true;
	}

	public void endDocument() throws SAXException {
		ch.endDocument();
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		ch.startPrefixMapping(prefix, uri);
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		ch.endPrefixMapping(prefix);
	}
	
	private String fixQName(String qname, String ename) {
		int index = qname.indexOf(':');
		if(index== -1) {
			// no prefix
			return ename;
		} else {
			return qname.substring(0, index+1) + ename;
		}
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {

		if (this.rootElement && XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(uri)
				&& "annotation".equals(localName)) {
			// yes, it is an annotation --> check for attribute
			int indexAt;
			if (atts != null
					&& (indexAt = atts.getIndex(
							com.siemens.ct.exi.Constants.W3C_EXI_NS_URI,
							"prepopulateValues")) != -1 && "true".equals(atts.getValue(indexAt))) {
				// ok, right annotation --> change to
				ch.startElement(uri, "schema", fixQName(qName, "schema"), null);
			} else {
				throw new SAXException(
						"No prepopulateValues attribute in annotation element");
			}
		} else if(this.rootElement) {
			throw new SAXException("No annotation element as root element");
		} else {
			if(XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(uri)
					&& "appinfo".equals(localName)) {
				ch.startElement(uri, "simpleType", fixQName(qName, "simpleType"), typeNameAtts);
			} else {
				ch.startElement(uri, localName, qName, atts);
			}
		}

		this.rootElement = false;
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(uri)
				&& "annotation".equals(localName)) {
			ch.endElement(uri, "schema", fixQName(qName, "schema"));
		} else if(XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(uri)
				&& "appinfo".equals(localName)) {
			ch.endElement(uri, "simpleType", fixQName(qName, "simpleType"));
		} else {
			ch.endElement(uri, localName, qName);
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		this.ch.characters(ch, start, length);
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		this.ch.ignorableWhitespace(ch, start, length);
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
		ch.processingInstruction(target, data);
	}

	public void skippedEntity(String name) throws SAXException {
		ch.skippedEntity(name);
	}

}
