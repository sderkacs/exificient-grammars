package com.siemens.ct.exi.grammars.persistency;

import javax.xml.namespace.QName;

import com.siemens.ct.exi.context.GrammarContext;
import com.siemens.ct.exi.context.GrammarUriContext;
import com.siemens.ct.exi.context.QNameContext;
import com.siemens.ct.exi.exceptions.UnsupportedOption;
import com.siemens.ct.exi.grammars.Grammars;
import com.siemens.ct.exi.grammars.event.EndDocument;
import com.siemens.ct.exi.grammars.event.Event;
import com.siemens.ct.exi.grammars.event.StartDocument;
import com.siemens.ct.exi.grammars.event.StartElement;
import com.siemens.ct.exi.grammars.grammar.DocEnd;
import com.siemens.ct.exi.grammars.grammar.Document;
import com.siemens.ct.exi.grammars.grammar.Fragment;
import com.siemens.ct.exi.grammars.grammar.Grammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTagGrammar;

@SuppressWarnings("unused")
public class Grammars2JavaSourceCodeTemplate implements Grammars {

	/* BEGIN GrammarContext ----- */
	final String ns0 = "";
	final QNameContext qnc0 = new QNameContext(0, 0, new QName(ns0, "Note"));
	final QNameContext qnc1 = new QNameContext(0, 1, new QName(ns0, "body"));
	final QNameContext qnc2 = new QNameContext(0, 2, new QName(ns0, "category"));
	final QNameContext qnc3 = new QNameContext(0, 3, new QName(ns0, "date"));
	final QNameContext qnc4 = new QNameContext(0, 4, new QName(ns0, "note"));
	final QNameContext qnc5 = new QNameContext(0, 5, new QName(ns0, "notebook"));
	final QNameContext qnc6 = new QNameContext(0, 6, new QName(ns0, "subject"));
	final QNameContext[] grammarQNames0 = {qnc0, qnc1, qnc2, qnc3, qnc4, qnc5, qnc6};
	final String[] grammarPrefixes0 = {""};
	final GrammarUriContext guc0 = new GrammarUriContext(0, ns0, grammarQNames0, grammarPrefixes0);
	
	final String ns1 = "http://www.w3.org/XML/1998/namespace";
	final QNameContext qnc7 = new QNameContext(1, 0, new QName(ns1, "base"));
	final QNameContext qnc8 = new QNameContext(1, 1, new QName(ns1, "id"));
	final QNameContext qnc9 = new QNameContext(1, 2, new QName(ns1, "lang"));
	final QNameContext qnc10 = new QNameContext(1, 3, new QName(ns1, "space"));
	final QNameContext[] grammarQNames1 = {qnc7, qnc8, qnc9, qnc10};
	final String[] grammarPrefixes1 = {"xml"};
	final GrammarUriContext guc1 = new GrammarUriContext(1, ns1, grammarQNames1, grammarPrefixes1);
	
	final String ns2 = "http://www.w3.org/2001/XMLSchema-instance";
	final QNameContext qnc11 = new QNameContext(2, 0, new QName(ns2, "nil"));
	final QNameContext qnc12 = new QNameContext(2, 1, new QName(ns2, "type"));
	final QNameContext[] grammarQNames2 = {qnc11, qnc12};
	final String[] grammarPrefixes2 = {"xsi"};
	final GrammarUriContext guc2 = new GrammarUriContext(2, ns2, grammarQNames2, grammarPrefixes2);
	
	final String ns3 = "http://www.w3.org/2001/XMLSchema";
	final QNameContext qnc13 = new QNameContext(3, 0, new QName(ns3, "ENTITIES"));
	final QNameContext qnc14 = new QNameContext(3, 1, new QName(ns3, "ENTITY"));
	final QNameContext qnc15 = new QNameContext(3, 2, new QName(ns3, "ID"));
	final QNameContext qnc16 = new QNameContext(3, 3, new QName(ns3, "IDREF"));
	final QNameContext qnc17 = new QNameContext(3, 4, new QName(ns3, "IDREFS"));
	final QNameContext qnc18 = new QNameContext(3, 5, new QName(ns3, "NCName"));
	final QNameContext qnc19 = new QNameContext(3, 6, new QName(ns3, "NMTOKEN"));
	final QNameContext qnc20 = new QNameContext(3, 7, new QName(ns3, "NMTOKENS"));
	final QNameContext qnc21 = new QNameContext(3, 8, new QName(ns3, "NOTATION"));
	final QNameContext qnc22 = new QNameContext(3, 9, new QName(ns3, "Name"));
	final QNameContext qnc23 = new QNameContext(3, 10, new QName(ns3, "QName"));
	final QNameContext qnc24 = new QNameContext(3, 11, new QName(ns3, "anySimpleType"));
	final QNameContext qnc25 = new QNameContext(3, 12, new QName(ns3, "anyType"));
	final QNameContext qnc26 = new QNameContext(3, 13, new QName(ns3, "anyURI"));
	final QNameContext qnc27 = new QNameContext(3, 14, new QName(ns3, "base64Binary"));
	final QNameContext qnc28 = new QNameContext(3, 15, new QName(ns3, "boolean"));
	final QNameContext qnc29 = new QNameContext(3, 16, new QName(ns3, "byte"));
	final QNameContext qnc30 = new QNameContext(3, 17, new QName(ns3, "date"));
	final QNameContext qnc31 = new QNameContext(3, 18, new QName(ns3, "dateTime"));
	final QNameContext qnc32 = new QNameContext(3, 19, new QName(ns3, "decimal"));
	final QNameContext qnc33 = new QNameContext(3, 20, new QName(ns3, "double"));
	final QNameContext qnc34 = new QNameContext(3, 21, new QName(ns3, "duration"));
	final QNameContext qnc35 = new QNameContext(3, 22, new QName(ns3, "float"));
	final QNameContext qnc36 = new QNameContext(3, 23, new QName(ns3, "gDay"));
	final QNameContext qnc37 = new QNameContext(3, 24, new QName(ns3, "gMonth"));
	final QNameContext qnc38 = new QNameContext(3, 25, new QName(ns3, "gMonthDay"));
	final QNameContext qnc39 = new QNameContext(3, 26, new QName(ns3, "gYear"));
	final QNameContext qnc40 = new QNameContext(3, 27, new QName(ns3, "gYearMonth"));
	final QNameContext qnc41 = new QNameContext(3, 28, new QName(ns3, "hexBinary"));
	final QNameContext qnc42 = new QNameContext(3, 29, new QName(ns3, "int"));
	final QNameContext qnc43 = new QNameContext(3, 30, new QName(ns3, "integer"));
	final QNameContext qnc44 = new QNameContext(3, 31, new QName(ns3, "language"));
	final QNameContext qnc45 = new QNameContext(3, 32, new QName(ns3, "long"));
	final QNameContext qnc46 = new QNameContext(3, 33, new QName(ns3, "negativeInteger"));
	final QNameContext qnc47 = new QNameContext(3, 34, new QName(ns3, "nonNegativeInteger"));
	final QNameContext qnc48 = new QNameContext(3, 35, new QName(ns3, "nonPositiveInteger"));
	final QNameContext qnc49 = new QNameContext(3, 36, new QName(ns3, "normalizedString"));
	final QNameContext qnc50 = new QNameContext(3, 37, new QName(ns3, "positiveInteger"));
	final QNameContext qnc51 = new QNameContext(3, 38, new QName(ns3, "short"));
	final QNameContext qnc52 = new QNameContext(3, 39, new QName(ns3, "string"));
	final QNameContext qnc53 = new QNameContext(3, 40, new QName(ns3, "time"));
	final QNameContext qnc54 = new QNameContext(3, 41, new QName(ns3, "token"));
	final QNameContext qnc55 = new QNameContext(3, 42, new QName(ns3, "unsignedByte"));
	final QNameContext qnc56 = new QNameContext(3, 43, new QName(ns3, "unsignedInt"));
	final QNameContext qnc57 = new QNameContext(3, 44, new QName(ns3, "unsignedLong"));
	final QNameContext qnc58 = new QNameContext(3, 45, new QName(ns3, "unsignedShort"));
	final QNameContext[] grammarQNames3 = {qnc13, qnc14, qnc15, qnc16, qnc17, qnc18, qnc19, qnc20, qnc21, qnc22, qnc23, qnc24, qnc25, qnc26, qnc27, qnc28, qnc29, qnc30, qnc31, qnc32, qnc33, qnc34, qnc35, qnc36, qnc37, qnc38, qnc39, qnc40, qnc41, qnc42, qnc43, qnc44, qnc45, qnc46, qnc47, qnc48, qnc49, qnc50, qnc51, qnc52, qnc53, qnc54, qnc55, qnc56, qnc57, qnc58};
	final String[] grammarPrefixes3 = {};
	final GrammarUriContext guc3 = new GrammarUriContext(3, ns3, grammarQNames3, grammarPrefixes3);
	
	final GrammarUriContext[] grammarUriContexts = {guc0, guc1, guc2, guc3};
	final GrammarContext gc = new GrammarContext(grammarUriContexts, 59);
	/* END GrammarContext ----- */
	
	/* BEGIN Grammars ----- */
	com.siemens.ct.exi.grammars.grammar.Document g0 = new com.siemens.ct.exi.grammars.grammar.Document();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent g1 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g2 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag g3 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g4 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag g5 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag g6 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g7 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g8 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g9 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g10 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g11 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g12 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g13 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g14 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.DocEnd g15 = new com.siemens.ct.exi.grammars.grammar.DocEnd();
	com.siemens.ct.exi.grammars.grammar.Fragment g16 = new com.siemens.ct.exi.grammars.grammar.Fragment();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFragmentContent g17 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFragmentContent();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g18 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g19 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g20 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g21 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g22 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g23 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g24 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g25 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g26 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g27 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g28 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g29 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g30 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g31 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g32 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g33 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g34 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g35 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g36 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g37 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g38 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g39 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g40 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g41 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g42 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g43 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g44 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g45 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g46 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g47 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g48 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g49 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g50 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g51 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g52 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g53 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g54 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag g55 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag();
	com.siemens.ct.exi.grammars.grammar.SchemaInformedElement g56 = new com.siemens.ct.exi.grammars.grammar.SchemaInformedElement();
	/* END Grammars ----- */
	
	/* BEGIN Globals ----- */
	com.siemens.ct.exi.grammars.event.Attribute globalAT3 = new com.siemens.ct.exi.grammars.event.Attribute(qnc3, new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.date, qnc30));
	com.siemens.ct.exi.grammars.event.StartElement globalSE5 = new com.siemens.ct.exi.grammars.event.StartElement(qnc5, g2);
	/* END Globals ----- */

	protected String schemaId; 
	
	
	void initGlobalElements() {
		/* BEGIN GlobalElements ----- */
		qnc5.setGlobalStartElement(globalSE5);
		/* END GlobalElements ----- */	
	}
	
	void initGlobalAttributes() {
		/* BEGIN GlobalAttributes ----- */
		qnc3.setGlobalAttribute(globalAT3);
		/* END GlobalAttributes ----- */
	}
	
	void initTypeGrammars() {
		/* BEGIN TypeGrammar ----- */
		qnc0.setTypeGrammar(g4);
		qnc13.setTypeGrammar(g18);
		qnc14.setTypeGrammar(g20);
		qnc15.setTypeGrammar(g20);
		qnc16.setTypeGrammar(g20);
		qnc17.setTypeGrammar(g18);
		qnc18.setTypeGrammar(g20);
		qnc19.setTypeGrammar(g20);
		qnc20.setTypeGrammar(g18);
		qnc21.setTypeGrammar(g20);
		qnc22.setTypeGrammar(g20);
		qnc23.setTypeGrammar(g20);
		qnc24.setTypeGrammar(g20);
		qnc25.setTypeGrammar(g21);
		qnc26.setTypeGrammar(g20);
		qnc27.setTypeGrammar(g23);
		qnc28.setTypeGrammar(g25);
		qnc29.setTypeGrammar(g27);
		qnc30.setTypeGrammar(g29);
		qnc31.setTypeGrammar(g31);
		qnc32.setTypeGrammar(g33);
		qnc33.setTypeGrammar(g35);
		qnc34.setTypeGrammar(g20);
		qnc35.setTypeGrammar(g35);
		qnc36.setTypeGrammar(g37);
		qnc37.setTypeGrammar(g39);
		qnc38.setTypeGrammar(g41);
		qnc39.setTypeGrammar(g43);
		qnc40.setTypeGrammar(g45);
		qnc41.setTypeGrammar(g47);
		qnc42.setTypeGrammar(g49);
		qnc43.setTypeGrammar(g49);
		qnc44.setTypeGrammar(g20);
		qnc45.setTypeGrammar(g49);
		qnc46.setTypeGrammar(g49);
		qnc47.setTypeGrammar(g51);
		qnc48.setTypeGrammar(g49);
		qnc49.setTypeGrammar(g20);
		qnc50.setTypeGrammar(g51);
		qnc51.setTypeGrammar(g49);
		qnc52.setTypeGrammar(g20);
		qnc53.setTypeGrammar(g53);
		qnc54.setTypeGrammar(g20);
		qnc55.setTypeGrammar(g55);
		qnc56.setTypeGrammar(g51);
		qnc57.setTypeGrammar(g51);
		qnc58.setTypeGrammar(g51);
		/* END TypeGrammar ----- */	
	}
	
	
	void initGrammarEvents() {
		/* BEGIN Grammar Events ----- */
		g0.addProduction(new com.siemens.ct.exi.grammars.event.StartDocument(), g1);
		g1.addProduction(globalSE5, g15);
		g1.addProduction(new com.siemens.ct.exi.grammars.event.StartElementGeneric(), g15);
		g2.addProduction(globalAT3, g3);
		g2.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc4, g4), g13);
		g3.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc4, g4), g13);
		g4.addProduction(new com.siemens.ct.exi.grammars.event.Attribute(qnc2, new com.siemens.ct.exi.datatype.StringDatatype(qnc52)), g5);
		g4.addProduction(globalAT3, g6);
		g5.addProduction(globalAT3, g6);
		g6.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc6, g7), g11);
		g7.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.StringDatatype(qnc52)), g8);
		g8.addProduction(new com.siemens.ct.exi.grammars.event.EndElement(), g9);
		g10.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.StringDatatype(qnc52)), g8);
		g11.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc1, g7), g8);
		g12.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc6, g7), g11);
		g13.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc4, g4), g13);
		g13.addProduction(new com.siemens.ct.exi.grammars.event.EndElement(), g9);
		g14.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc4, g4), g13);
		g15.addProduction(new com.siemens.ct.exi.grammars.event.EndDocument(), g9);
		g16.addProduction(new com.siemens.ct.exi.grammars.event.StartDocument(), g17);
		g17.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc1, g7), g17);
		g17.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc4, g4), g17);
		g17.addProduction(globalSE5, g17);
		g17.addProduction(new com.siemens.ct.exi.grammars.event.StartElement(qnc6, g7), g17);
		g17.addProduction(new com.siemens.ct.exi.grammars.event.StartElementGeneric(), g17);
		g17.addProduction(new com.siemens.ct.exi.grammars.event.EndDocument(), g9);
		g18.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.ListDatatype(new com.siemens.ct.exi.datatype.StringDatatype(qnc14), qnc13)), g8);
		g19.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.ListDatatype(new com.siemens.ct.exi.datatype.StringDatatype(qnc14), qnc13)), g8);
		g20.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.StringDatatype(qnc14)), g8);
		g21.addProduction(new com.siemens.ct.exi.grammars.event.AttributeGeneric(), g21);
		g21.addProduction(new com.siemens.ct.exi.grammars.event.StartElementGeneric(), g22);
		g21.addProduction(new com.siemens.ct.exi.grammars.event.EndElement(), g9);
		g21.addProduction(new com.siemens.ct.exi.grammars.event.CharactersGeneric(), g22);
		g22.addProduction(new com.siemens.ct.exi.grammars.event.StartElementGeneric(), g22);
		g22.addProduction(new com.siemens.ct.exi.grammars.event.EndElement(), g9);
		g22.addProduction(new com.siemens.ct.exi.grammars.event.CharactersGeneric(), g22);
		g23.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BinaryBase64Datatype(qnc27)), g8);
		g24.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BinaryBase64Datatype(qnc27)), g8);
		g25.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BooleanDatatype(qnc28)), g8);
		g26.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BooleanDatatype(qnc28)), g8);
		g27.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype(com.siemens.ct.exi.values.IntegerValue.valueOf(-128), com.siemens.ct.exi.values.IntegerValue.valueOf(127), qnc29)), g8);
		g28.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype(com.siemens.ct.exi.values.IntegerValue.valueOf(-128), com.siemens.ct.exi.values.IntegerValue.valueOf(127), qnc29)), g8);
		g29.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.date, qnc30)), g8);
		g30.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.date, qnc30)), g8);
		g31.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.dateTime, qnc31)), g8);
		g32.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.dateTime, qnc31)), g8);
		g33.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DecimalDatatype(qnc32)), g8);
		g34.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DecimalDatatype(qnc32)), g8);
		g35.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.FloatDatatype(qnc33)), g8);
		g36.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.FloatDatatype(qnc33)), g8);
		g37.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gDay, qnc36)), g8);
		g38.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gDay, qnc36)), g8);
		g39.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gMonth, qnc37)), g8);
		g40.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gMonth, qnc37)), g8);
		g41.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gMonthDay, qnc38)), g8);
		g42.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gMonthDay, qnc38)), g8);
		g43.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gYear, qnc39)), g8);
		g44.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gYear, qnc39)), g8);
		g45.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gYearMonth, qnc40)), g8);
		g46.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.gYearMonth, qnc40)), g8);
		g47.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BinaryHexDatatype(qnc41)), g8);
		g48.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.BinaryHexDatatype(qnc41)), g8);
		g49.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.IntegerDatatype(qnc42)), g8);
		g50.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.IntegerDatatype(qnc42)), g8);
		g51.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.UnsignedIntegerDatatype(qnc47)), g8);
		g52.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.UnsignedIntegerDatatype(qnc47)), g8);
		g53.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.time, qnc53)), g8);
		g54.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.DatetimeDatatype(com.siemens.ct.exi.types.DateTimeType.time, qnc53)), g8);
		g55.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype(com.siemens.ct.exi.values.IntegerValue.valueOf(0), com.siemens.ct.exi.values.IntegerValue.valueOf(255), qnc55)), g8);
		g56.addProduction(new com.siemens.ct.exi.grammars.event.Characters(new com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype(com.siemens.ct.exi.values.IntegerValue.valueOf(0), com.siemens.ct.exi.values.IntegerValue.valueOf(255), qnc55)), g8);
		/* END Grammar Events ----- */
	}
	
	void initFirstStartGrammars() {
		/* BEGIN FirstStartGrammar ----- */
		g2.setElementContentGrammar(g14);
		g2.setTypeCastable(false);
		g2.setNillable(false);
		g4.setElementContentGrammar(g12);
		g4.setTypeCastable(false);
		g4.setNillable(false);
		g7.setElementContentGrammar(g10);
		g7.setTypeCastable(true);
		g7.setNillable(false);
		g18.setElementContentGrammar(g19);
		g18.setTypeCastable(false);
		g18.setNillable(false);
		g20.setElementContentGrammar(g10);
		g20.setTypeCastable(false);
		g20.setNillable(false);
		g21.setElementContentGrammar(g22);
		g21.setTypeCastable(false);
		g21.setNillable(false);
		g23.setElementContentGrammar(g24);
		g23.setTypeCastable(false);
		g23.setNillable(false);
		g25.setElementContentGrammar(g26);
		g25.setTypeCastable(false);
		g25.setNillable(false);
		g27.setElementContentGrammar(g28);
		g27.setTypeCastable(false);
		g27.setNillable(false);
		g29.setElementContentGrammar(g30);
		g29.setTypeCastable(false);
		g29.setNillable(false);
		g31.setElementContentGrammar(g32);
		g31.setTypeCastable(false);
		g31.setNillable(false);
		g33.setElementContentGrammar(g34);
		g33.setTypeCastable(false);
		g33.setNillable(false);
		g35.setElementContentGrammar(g36);
		g35.setTypeCastable(false);
		g35.setNillable(false);
		g37.setElementContentGrammar(g38);
		g37.setTypeCastable(false);
		g37.setNillable(false);
		g39.setElementContentGrammar(g40);
		g39.setTypeCastable(false);
		g39.setNillable(false);
		g41.setElementContentGrammar(g42);
		g41.setTypeCastable(false);
		g41.setNillable(false);
		g43.setElementContentGrammar(g44);
		g43.setTypeCastable(false);
		g43.setNillable(false);
		g45.setElementContentGrammar(g46);
		g45.setTypeCastable(false);
		g45.setNillable(false);
		g47.setElementContentGrammar(g48);
		g47.setTypeCastable(false);
		g47.setNillable(false);
		g49.setElementContentGrammar(g50);
		g49.setTypeCastable(false);
		g49.setNillable(false);
		g51.setElementContentGrammar(g52);
		g51.setTypeCastable(false);
		g51.setNillable(false);
		g53.setElementContentGrammar(g54);
		g53.setTypeCastable(false);
		g53.setNillable(false);
		g55.setElementContentGrammar(g56);
		g55.setTypeCastable(false);
		g55.setNillable(false);
		/* END FirstStartGrammar ----- */
	}
	
	public Grammars2JavaSourceCodeTemplate() {
		initGlobalElements();
		initGlobalAttributes();
		initTypeGrammars();
		initGrammarEvents();
		initFirstStartGrammars();
	}
	

	public boolean isSchemaInformed() {
		return true;
	}

	public String getSchemaId() {
		return schemaId;
	}

	public void setSchemaId(String schemaId) throws UnsupportedOption {
		this.schemaId = schemaId;
	}

	public boolean isBuiltInXMLSchemaTypesOnly() {
		return false;
	}

	public Grammar getDocumentGrammar() {
		/* BEGIN Document Grammar ----- */
		return g0;
		/* END Document Grammar ----- */
	}

	public Grammar getFragmentGrammar() {
		/* BEGIN Fragment Grammar ----- */
		return g16; // update according fragment grammar
		/* END Fragment Grammar ----- */
	}
	

	
	public GrammarContext getGrammarContext() {
		return gc;
	}

}
