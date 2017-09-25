package com.siemens.ct.exi.grammars.persistency;

import com.siemens.ct.exi.EXIFactory;
import com.siemens.ct.exi.FidelityOptions;
import com.siemens.ct.exi._2017.schemaforgrammars.ExiGrammars;
import com.siemens.ct.exi.api.sax.EXIResult;
import com.siemens.ct.exi.api.sax.EXISource;
import com.siemens.ct.exi.exceptions.EXIException;
import com.siemens.ct.exi.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;
import com.siemens.ct.exi.helpers.DefaultEXIFactory;
import junit.framework.TestCase;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

public class Grammars2XTest extends TestCase {
	
	XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

	public Grammars2XTest() throws EXIException {
		super();
	}
	
	protected void _test(String xsd, String xml) throws Exception {
		grammarBuilder.loadGrammars(xsd);
		SchemaInformedGrammars grammarsIn = grammarBuilder.toGrammars();
		
		Grammars2X g2X = new Grammars2X();
		ExiGrammars exiGrammarIn = g2X.toGrammarsX(grammarsIn);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Grammars2X.marshall(exiGrammarIn, baos);
		// System.out.println(new String(baos.toByteArray()));
		ExiGrammars exiGrammarOut = Grammars2X.unmarshall(new ByteArrayInputStream(baos.toByteArray()));
		
		// further validation	
		SchemaInformedGrammars grammarsOut = Grammars2X.toGrammars(exiGrammarOut);
		
		// try to encode with original Grammars and to decode with transformed Grammars
		EXIFactory exiFactory = DefaultEXIFactory.newInstance();
        exiFactory.setFidelityOptions(FidelityOptions.createAll());
		// 1. Encode
		exiFactory.setGrammars(grammarsIn);
		
		ByteArrayOutputStream osEXI = new ByteArrayOutputStream();
		EXIResult exiResult = new EXIResult(exiFactory);
		exiResult.setOutputStream(osEXI);
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		xmlReader.setContentHandler( exiResult.getHandler() );
        InputSource isXML = new InputSource(xml);
		xmlReader.parse(isXML); // parse XML input
		osEXI.close();
		
		// 2. Decode
		exiFactory.setGrammars(grammarsOut);
		ByteArrayOutputStream osXML = new ByteArrayOutputStream();
		Result result = new StreamResult(osXML);
		SAXSource exiSource = new EXISource(exiFactory);
		exiSource.setInputSource(new InputSource(new ByteArrayInputStream(osEXI.toByteArray())));
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(exiSource, result);
        String xmlOut = osXML.toString();
        InputSource isXMLOut = new InputSource(new StringReader(xmlOut));
        XMLAssert.assertXMLEqual(isXML, isXMLOut);
    }

	@Test
	public void testNotebook() throws Exception {
		String xsd = "data/W3C/PrimerNotebook/notebook.xsd";
		String xml = "data/W3C/PrimerNotebook/notebook.xml";
		_test(xsd, xml);
	}
	
	@Test
	public void testEXIForJSON_02() throws Exception {
		String xsd = "data/W3C/EXIforJSON/exi4json.xsd";
		String xml = "data/W3C/EXIforJSON/02.json.xml";
		_test(xsd, xml);
	}
	
	@Test
	public void testEXIForJSON_Fstab1() throws Exception {
		String xsd = "data/W3C/EXIforJSON/exi4json.xsd";
		String xml = "data/W3C/EXIforJSON/fstab1.json.xml";
		_test(xsd, xml);
	}
	
	@Test
	public void testDatatypes() throws Exception {
		String xsd = "data/general/datatypes.xsd";
		String xml = "data/general/datatypes.xml";
		_test(xsd, xml);
	}

    protected void testRoundTripExiGrammarsXml(String xsd) throws Exception {
		grammarBuilder.loadGrammars(xsd);
		SchemaInformedGrammars grammarsIn = grammarBuilder.toGrammars();

        Grammars2X grammars2X = new Grammars2X();
        ExiGrammars exiGrammars = grammars2X.toGrammarsX(grammarsIn);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Grammars2X.marshall(exiGrammars, baos);
        String exiGrammarsXml = baos.toString();

        ExiGrammars exiGrammarOut = Grammars2X.unmarshall(new ByteArrayInputStream(baos.toByteArray()));
        SchemaInformedGrammars grammarsOut = Grammars2X.toGrammars(exiGrammarOut);

        grammars2X.clear();
        ExiGrammars exiGrammarsRoundTrip = grammars2X.toGrammarsX(grammarsOut);
        ByteArrayOutputStream baosRoundTrip = new ByteArrayOutputStream();
        Grammars2X.marshall(exiGrammarsRoundTrip, baosRoundTrip);
        String exiGrammarsXmlRoundTrip = baosRoundTrip.toString();

        XMLAssert.assertXMLEqual(exiGrammarsXml, exiGrammarsXmlRoundTrip);
	}

    @Test
    public void testRoundTripExiGrammarsXmlNotebook() throws Exception {
        testRoundTripExiGrammarsXml("data/W3C/PrimerNotebook/notebook.xsd");
    }
}
