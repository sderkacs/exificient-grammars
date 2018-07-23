package com.siemens.ct.exi.grammars.persistency;

/*
 * Copyright (c) 2007-2018 Siemens AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.siemens.ct.exi.core.context.GrammarContext;
import com.siemens.ct.exi.core.context.GrammarUriContext;
import com.siemens.ct.exi.core.context.QNameContext;
import com.siemens.ct.exi.core.datatype.Datatype;
import com.siemens.ct.exi.core.datatype.DatetimeDatatype;
import com.siemens.ct.exi.core.datatype.EnumerationDatatype;
import com.siemens.ct.exi.core.datatype.ListDatatype;
import com.siemens.ct.exi.core.datatype.NBitUnsignedIntegerDatatype;
import com.siemens.ct.exi.core.datatype.RestrictedCharacterSetDatatype;
import com.siemens.ct.exi.core.datatype.charset.RestrictedCharacterSet;
import com.siemens.ct.exi.core.exceptions.EXIException;
import com.siemens.ct.exi.core.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.core.grammars.event.Attribute;
import com.siemens.ct.exi.core.grammars.event.AttributeNS;
import com.siemens.ct.exi.core.grammars.event.Characters;
import com.siemens.ct.exi.core.grammars.event.DatatypeEvent;
import com.siemens.ct.exi.core.grammars.event.Event;
import com.siemens.ct.exi.core.grammars.event.EventType;
import com.siemens.ct.exi.core.grammars.event.StartElement;
import com.siemens.ct.exi.core.grammars.event.StartElementNS;
import com.siemens.ct.exi.core.grammars.grammar.DocEnd;
import com.siemens.ct.exi.core.grammars.grammar.Document;
import com.siemens.ct.exi.core.grammars.grammar.Fragment;
import com.siemens.ct.exi.core.grammars.grammar.Grammar;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedDocContent;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedElement;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedFirstStartTagGrammar;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedFragmentContent;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedGrammar;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedStartTagGrammar;
import com.siemens.ct.exi.core.grammars.production.Production;
import com.siemens.ct.exi.core.types.BuiltIn;
import com.siemens.ct.exi.core.types.BuiltInType;
import com.siemens.ct.exi.core.values.IntegerValue;
import com.siemens.ct.exi.core.values.Value;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;
import com.siemens.ct.exi.grammars.util.PrintfUtils;

public class Grammars2JSON {

	public static final boolean STATS_ON = true;

	protected int statsCountTransitions = 0;
	protected int statsCountStates = 0;

	GrammarsPreperation gpreps = new GrammarsPreperation();

	public Grammars2JSON() {
		super();
	}

	protected void clear() {
		gpreps.clear();
	}

	public void toGrammarsJSON(SchemaInformedGrammars grammars, OutputStream os)
			throws IOException, EXIException {

		// clear
		clear();

		// prepare grammar rules
		gpreps.prepareGrammars(grammars);

		GrammarContext grammarContext = grammars.getGrammarContext();

		Writer w = new OutputStreamWriter(os);

		List<Datatype> listOfDatatypes = new ArrayList<Datatype>();

		for (int i = 0; i < gpreps.getNumberOfGrammars(); i++) {
			Grammar r = gpreps.getGrammar(i);
			for (int k = 0; k < r.getNumberOfEvents(); k++) {
				Production p = r.getProduction(k);
				Event e = p.getEvent();
				if (e instanceof DatatypeEvent) {
					DatatypeEvent de = (DatatypeEvent) e;
					// System.out.println(de.getDatatype());
					if (!listOfDatatypes.contains(de.getDatatype())
							&& de.getDatatype() != BuiltIn.getDefaultDatatype()) {
						listOfDatatypes.add(de.getDatatype());
					}
					// any simple Type !??!
					Datatype base = de.getDatatype().getBaseDatatype();
					if (base != null && !listOfDatatypes.contains(base)) {
						listOfDatatypes.add(base);
					}
				}
			}
		}

		int ind = 0;
		PrintfUtils.printfIndLn(w, ind, "{");

		{
			/*
			 * QNames, NameTables
			 */

			ind++;
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : { ",
					GrammarsConstants.QNAMES);

			ind++;
			// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d, ",
			// GrammarsConstants.NUMBER_OF_URIS,
			// grammarContext.getNumberOfGrammarUriContexts());
			// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d, ",
			// GrammarsConstants.NUMBER_OF_QNAMES,
			// grammarContext.getNumberOfGrammarQNameContexts());

			PrintfUtils.printfIndLn(w, ind, "\"%s\" : [",
					GrammarsConstants.NAMESPACE_CONTEXT,
					grammarContext.getNumberOfGrammarQNameContexts());
			ind++;

			for (int i = 0; i < grammarContext.getNumberOfGrammarUriContexts(); i++) {

				PrintfUtils.printfIndLn(w, ind, "{"); // namespaceContext array
														// entry
				ind++;

				GrammarUriContext guc = grammarContext.getGrammarUriContext(i);

				// namespaceUri
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
						GrammarsConstants.URI_ID, guc.getNamespaceUriID()); // UriID
																			// not
																			// necessary
																			// but
																			// useful
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\", ",
						GrammarsConstants.URI, guc.getNamespaceUri());

				// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %s, ",
				// GrammarsConstants.NUMBER_OF_LOCAL_NAMES,
				// guc.getNumberOfQNames());

				PrintfUtils.printfIndLn(w, ind, "\"%s\" : [",
						GrammarsConstants.QNAME_CONTEXT);
				ind++;

				// qnames
				for (int k = 0; k < guc.getNumberOfQNames(); k++) {
					QNameContext qnc = guc.getQNameContext(k);

					{
						PrintfUtils.printfIndLn(w, ind, "{");
						ind++;

						PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
								GrammarsConstants.URI_ID,
								qnc.getNamespaceUriID());

						// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
						// GrammarsConstants.QNAME_ID, qnc.getQNameID()); //
						// QNameID not necessary but useful
						PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
								GrammarsConstants.LOCAL_NAME_ID,
								qnc.getLocalNameID()); // LocalNameID not
														// necessary but useful

						// local-names
						PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\"",
								GrammarsConstants.LOCAL_NAME,
								qnc.getLocalName());

						// global type
						if (qnc.getTypeGrammar() != null) {
							PrintfUtils.printfIndLn(w, ind, ",");
							PrintfUtils.printfIndLn(w, ind, "\"%s\" : %s ",
									GrammarsConstants.GLOBAL_TYPE_GRAMMAR_ID,
									gpreps.getGrammarID(qnc.getTypeGrammar()));
						}

						// global element
						if (qnc.getGlobalStartElement() != null) {
							StartElement se = qnc.getGlobalStartElement();
							PrintfUtils.printfIndLn(w, ind, ",");
							PrintfUtils
									.printfIndLn(
											w,
											ind,
											"\"%s\" : %s ",
											GrammarsConstants.GLOBAL_ELEMENT_GRAMMAR_ID,
											gpreps.getGrammarID(se.getGrammar()));
						}

						// global attribute
						if (qnc.getGlobalAttribute() != null) {
							Attribute at = qnc.getGlobalAttribute();

							// globalAttributeDatatypeID
							PrintfUtils.printfIndLn(w, ind, ",");
							PrintfUtils
									.printfIndLn(
											w,
											ind,
											"\"%s\" : %s ",
											GrammarsConstants.GLOBAL_ATTRIBUTE_DATATYPE_ID,
											listOfDatatypes.indexOf(at
													.getDatatype()));
						}

						ind--;
						PrintfUtils.printfIndLn(w, ind, "}");
						if (k < (guc.getNumberOfQNames() - 1)) {
							PrintfUtils.printfIndLn(w, ind, ", ");
						}

					}

				}

				ind--;
				PrintfUtils.printfIndLn(w, ind, "]"); // qnameContext

				ind--;
				PrintfUtils.printfIndLn(w, ind, "}"); // namespaceContext array
														// entry

				if (i < (grammarContext.getNumberOfGrammarUriContexts() - 1)) {
					PrintfUtils.printfIndLn(w, ind, ", ");
				}

			}

			ind--;
			PrintfUtils.printfIndLn(w, ind, "]"); // namespaceContext

			ind--;
			PrintfUtils.printfIndLn(w, ind, "}"); // qnames

			/*
			 * Datatypes
			 */
			PrintfUtils.printfIndLn(w, ind, ",");
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : [ ",
					GrammarsConstants.SIMPLE_DATATYPES);
			ind++;

			for (int i = 0; i < listOfDatatypes.size(); i++) {
				Datatype dt = listOfDatatypes.get(i);
				// simpleDatatype
				PrintfUtils.printfIndLn(w, ind, "{");

				{
					// datatype
					ind++;
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d,",
							GrammarsConstants.SIMPLE_DATATYPE_ID, i);
					this.printBuiltInDatatype(w, ind, dt); // , grammarContext);
					// TODO schema type
					{
						dt.getSchemaType();
					}
					ind--;
				}
				PrintfUtils.printfIndLn(w, ind, "}");

				if (i < (listOfDatatypes.size() - 1)) {
					PrintfUtils.printfIndLn(w, ind, ", ");
				}

			}

			ind--;
			PrintfUtils.printfIndLn(w, ind, "]"); // simpleDatatypes

			PrintfUtils.printfIndLn(w, ind, ", ");

			/*
			 * Grammar Rules
			 */
			PrintfUtils.printfIndLn(w, ind, "\"grs\" : {");
			ind++;

			PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
					GrammarsConstants.DOCUMENT_GRAMMAR_ID,
					gpreps.getGrammarID(grammars.getDocumentGrammar()));
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
					GrammarsConstants.FRAGMENT_GRAMMAR_ID,
					gpreps.getGrammarID(grammars.getFragmentGrammar()));

			PrintfUtils.printfIndLn(w, ind, "\"%s\" : [",
					GrammarsConstants.GRAMMAR,
					gpreps.getGrammarID(grammars.getDocumentGrammar()));
			ind++;

			for (int i = 0; i < gpreps.getNumberOfGrammars(); i++) {
				Grammar r = gpreps.getGrammar(i);
				this.printGrammar(w, ind, (SchemaInformedGrammar) r,
						listOfDatatypes);

				if (i < (gpreps.getNumberOfGrammars() - 1)) {
					PrintfUtils.printfIndLn(w, ind, ", ");
				}
			}

			ind--;
			PrintfUtils.printfIndLn(w, ind, "]");

			ind--;
			PrintfUtils.printfIndLn(w, ind, "}"); // grs

		}

		PrintfUtils.printfIndLn(w, 0, "}");

		w.flush();
	}

	protected void printGrammar(Writer w, int ind, SchemaInformedGrammar sir,
			List<Datatype> listOfDatatypes) throws IOException {

		PrintfUtils.printfIndLn(w, ind, "{");
		ind++;

		PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%d\" ,",
				GrammarsConstants.GRAMMAR_ID, gpreps.getGrammarID(sir)); // GrammarID
																			// not
																			// necessary
																			// but
																			// useful

		if (sir instanceof SchemaInformedFirstStartTagGrammar) {
			SchemaInformedFirstStartTagGrammar fst = (SchemaInformedFirstStartTagGrammar) sir;

			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE,
					GrammarsConstants.FIRST_START_TAG_CONTENT);

			PrintfUtils.printfIndLn(w, ind, "\"%s\" : %s ,",
					GrammarsConstants.IS_TYPE_CASTABLE, fst.isTypeCastable());
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : %s ,",
					GrammarsConstants.IS_NILLABLE, fst.isNillable());

		} else if (sir instanceof SchemaInformedStartTagGrammar) {
			PrintfUtils
					.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
							GrammarsConstants.TYPE,
							GrammarsConstants.START_TAG_CONTENT);
		} else if (sir instanceof SchemaInformedElement) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.ELEMENT_CONTENT);
		} else if (sir instanceof Document) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.DOCUMENT);
		} else if (sir instanceof SchemaInformedDocContent) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.DOC_CONTENT);
		} else if (sir instanceof DocEnd) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.DOC_END);
		} else if (sir instanceof Fragment) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.FRAGMENT);
		} else if (sir instanceof SchemaInformedFragmentContent) {
			PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
					GrammarsConstants.TYPE, GrammarsConstants.FRAGMENT_CONTENT);
		} else {
			// System.err.println("Unkown Rule type: " + sir);
			throw new RuntimeException("Unkown Rule type: " + sir);
		}
		if (STATS_ON) {
			statsCountStates++;
		}

		PrintfUtils.printfIndLn(w, ind, "\"%s\" : [ ",
				GrammarsConstants.PRODUCTION);
		ind++;
		printGrammarProduction(w, ind, sir, listOfDatatypes); // , ruleStateID);
		ind--;
		PrintfUtils.printfIndLn(w, ind, "]");

		ind--;
		PrintfUtils.printfIndLn(w, ind, "}");
	}

	protected void printGrammarProduction(Writer w, int ind,
			SchemaInformedGrammar sir, List<Datatype> listOfDatatypes)
			throws IOException {

		for (int i = 0; i < sir.getNumberOfEvents(); i++) {
			if (STATS_ON) {
				statsCountTransitions++;
			}

			PrintfUtils.printfIndLn(w, ind, "{");
			ind++;

			Production ei = sir.getProduction(i);
			Event event = ei.getEvent();
			EventType eventType = event.getEventType();
			switch (eventType) {
			case START_DOCUMENT:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.START_DOCUMENT);
				break;
			case END_DOCUMENT:
				PrintfUtils
						.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
								GrammarsConstants.EVENT,
								GrammarsConstants.END_DOCUMENT);
				break;
			case START_ELEMENT:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.START_ELEMENT);
				{
					StartElement se = (StartElement) event;
					QNameContext eqname = se.getQNameContext();

					// qname
					// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
					// GrammarsConstants.START_ELEMENT_QNAME_ID,
					// eqname.getQNameID());
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.START_ELEMENT_NAMESPACE_ID,
							eqname.getNamespaceUriID());
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.START_ELEMENT_LOCALNAME_ID,
							eqname.getLocalNameID());

					// grammar
					Grammar seRule = se.getGrammar();
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.START_ELEMENT_GRAMMAR_ID,
							gpreps.getGrammarID(seRule));
				}
				break;
			case START_ELEMENT_NS:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.START_ELEMENT_NS);
				{
					StartElementNS seNS = (StartElementNS) event;
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.START_ELEMENT_NAMESPACE_ID,
							seNS.getNamespaceUriID());
				}
				break;
			case END_ELEMENT:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT, GrammarsConstants.END_ELEMENT);
				break;
			case ATTRIBUTE:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT, GrammarsConstants.ATTRIBUTE);
				{
					Attribute at = (Attribute) event;
					QNameContext eqname = at.getQNameContext();

					// qname
					// PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
					// GrammarsConstants.ATTRIBUTE_QNAME_ID,
					// eqname.getQNameID());
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.ATTRIBUTE_NAMESPACE_ID,
							eqname.getNamespaceUriID());
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.ATTRIBUTE_LOCALNAME_ID,
							eqname.getLocalNameID());

					// datatype
					Datatype dt = at.getDatatype();
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.ATTRIBUTE_DATATYPE_ID,
							listOfDatatypes.indexOf(dt));
				}
				break;
			case ATTRIBUTE_NS:
				PrintfUtils
						.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
								GrammarsConstants.EVENT,
								GrammarsConstants.ATTRIBUTE_NS);
				{
					AttributeNS atNS = (AttributeNS) event;
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.ATTRIBUTE_NAMESPACE_ID,
							atNS.getNamespaceUriID());
				}
				break;
			case CHARACTERS:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT, GrammarsConstants.CHARACTERS);
				{
					Characters ch = (Characters) event;
					Datatype dt = ch.getDatatype();

					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d ,",
							GrammarsConstants.CHARACTERS_DATATYPE_ID,
							listOfDatatypes.indexOf(dt));
				}
				break;
			case START_ELEMENT_GENERIC:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.START_ELEMENT_GENERIC);
				break;
			case ATTRIBUTE_GENERIC:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.ATTRIBUTE_GENERIC);
				break;
			case CHARACTERS_GENERIC:
				PrintfUtils.printfIndLn(w, ind, "\"%s\" : \"%s\" ,",
						GrammarsConstants.EVENT,
						GrammarsConstants.CHARACTERS_GENERIC);
				break;
			default:
				System.err.println("Unknown Event " + ei.getEvent());
			}

			// next state ID
			{
				Grammar nextRule = ei.getNextGrammar();
				if (nextRule.getNumberOfEvents() > 0) {
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d",
							GrammarsConstants.NEXT_GRAMMAR_ID,
							gpreps.getGrammarID(nextRule));
				} else {
					// No events anymore, eg. EE, ED
					PrintfUtils.printfIndLn(w, ind, "\"%s\" : %d",
							GrammarsConstants.NEXT_GRAMMAR_ID, -1);
				}

			}

			ind--;
			PrintfUtils.printfIndLn(w, ind, "}");

			if (i < (sir.getNumberOfEvents() - 1)) {
				PrintfUtils.printfIndLn(w, ind, ", ");
			}

		}
	}

	protected void printBuiltInDatatype(Writer w, int ind, Datatype dt)
			throws IOException {
		printBuiltInDatatype(w, ind, dt, "type");
	}

	protected void printBuiltInDatatype(Writer w, int ind, Datatype dt,
			String typeID) throws IOException {

		BuiltInType bit = dt.getBuiltInType();

		PrintfUtils.printfInd(w, ind, "\"%s\": \"%s\"", typeID, bit);

		switch (bit) {
		case NBIT_UNSIGNED_INTEGER:
			PrintfUtils.printfLn(w, ",", bit);
			NBitUnsignedIntegerDatatype nbdt = (NBitUnsignedIntegerDatatype) dt;
			IntegerValue ivLower = nbdt.getLowerBound();
			PrintfUtils.printfIndLn(w, ind, "\"%s\": %s,",
					GrammarsConstants.LOWER_BOUND, ivLower.toString());
			IntegerValue ivUpper = nbdt.getUpperBound();
			PrintfUtils.printfIndLn(w, ind, "\"%s\": %s",
					GrammarsConstants.UPPER_BOUND, ivUpper.toString());
			break;
		case LIST:
			PrintfUtils.printfLn(w, ",", bit);
			ListDatatype ldt = (ListDatatype) dt;

			this.printBuiltInDatatype(w, ind, ldt.getListDatatype(), "listType"); // ,grammarContext);

			break;
		case ENUMERATION:
			PrintfUtils.printfLn(w, ",", bit);
			EnumerationDatatype edt = (EnumerationDatatype) dt;

			PrintfUtils.printfInd(w, ind, "\"%s\": [", "enumValues");

			for (int i = 0; i < edt.getEnumerationSize(); i++) {

				Value enumVal = edt.getEnumValue(i);

				PrintfUtils.printf(w, "\"%s\"", enumVal.toString());
				if ((i + 1) < edt.getEnumerationSize()) {
					PrintfUtils.printf(w, ", ");
				}
			}
			PrintfUtils.printfLn(w, "]");

			break;
		case DATETIME:
			PrintfUtils.printfLn(w, ",", bit);
			DatetimeDatatype ddt = (DatetimeDatatype) dt;
			PrintfUtils.printfIndLn(w, ind, "\"%s\": \"%s\"", "datetimeType",
					ddt.getDatetimeType().toString());
			break;
		case RCS_STRING:
			PrintfUtils.printfLn(w, ",", bit);
			RestrictedCharacterSetDatatype rcsdt = (RestrictedCharacterSetDatatype) dt;

			RestrictedCharacterSet rcs = rcsdt.getRestrictedCharacterSet();
			PrintfUtils.printfInd(w, ind, "\"%s\": [", "codePoints");
			for (int i = 0; i < rcs.size(); i++) {
				PrintfUtils.printf(w, "%d", rcs.getCodePoint(i));
				if ((i + 1) < rcs.size()) {
					PrintfUtils.printf(w, ", ");
				}
			}
			PrintfUtils.printfLn(w, "]");
			break;
		// case BOOLEAN:
		case BOOLEAN_FACET:
			PrintfUtils.printfLn(w, ",", bit);
			PrintfUtils.printfIndLn(w, ind, "\"%s\": \"%s\"",
					GrammarsConstants.DATATYPE_BOOLEAN_FACET, "true");
			break;
		default:
			PrintfUtils.printfLn(w, "", bit);
			// default builInTypes without any additional information
		}

	}

	public static void main(String[] args) throws Exception {
		String xsd = null;
		String grsOut = null;

		// schema-for-json.xsd, see
		// https://www.w3.org/TR/exi-for-json/schema-for-json.xsd
		// xsd = "../exificient.js/grammars/schema-for-json.xsd";
		// xsd = "../exificient.js/grammars/exi4json.xsd";
		// notebook
		// xsd = "../exificient.js/grammars/notebook.xsd";
		// xsd = "../exificient.js/test/data/xml/any0.xsd";
		xsd = "../exificient.js/test/data/xml/basic_rdf_query_v02.xsd";
		// xsd =
		// "D:\\Projects\\EXI\\EXIficient\\exificient.js\\test\\data\\xml\\unsignedInteger.xsd";
		// xsd =
		// "D:\\Projects\\EXI\\EXIficient\\exificient.js\\test\\data\\xml\\test1.xsd";

		grsOut = xsd + ".grs";

		XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

		grammarBuilder.loadGrammars(xsd);

		SchemaInformedGrammars grammarIn = grammarBuilder.toGrammars();

		Grammars2JSON g2j = new Grammars2JSON();

		/*
		 * Encode
		 */
		FileOutputStream fos = new FileOutputStream(grsOut);
		g2j.toGrammarsJSON(grammarIn, fos);
		fos.close();

		/*
		 * STATS
		 */
		if (STATS_ON) {
			System.out.println("Transitions: " + g2j.statsCountTransitions);
			System.out.println("States: " + g2j.statsCountStates);
		}

	}

}
