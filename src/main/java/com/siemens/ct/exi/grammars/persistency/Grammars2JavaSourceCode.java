package com.siemens.ct.exi.grammars.persistency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;

import com.siemens.ct.exi.context.GrammarContext;
import com.siemens.ct.exi.context.GrammarUriContext;
import com.siemens.ct.exi.context.QNameContext;
import com.siemens.ct.exi.datatype.Datatype;
import com.siemens.ct.exi.datatype.DatetimeDatatype;
import com.siemens.ct.exi.datatype.EnumerationDatatype;
import com.siemens.ct.exi.datatype.ListDatatype;
import com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype;
import com.siemens.ct.exi.exceptions.EXIException;
import com.siemens.ct.exi.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;
import com.siemens.ct.exi.grammars.event.Attribute;
import com.siemens.ct.exi.grammars.event.AttributeGeneric;
import com.siemens.ct.exi.grammars.event.Characters;
import com.siemens.ct.exi.grammars.event.CharactersGeneric;
import com.siemens.ct.exi.grammars.event.EndDocument;
import com.siemens.ct.exi.grammars.event.EndElement;
import com.siemens.ct.exi.grammars.event.StartDocument;
import com.siemens.ct.exi.grammars.event.StartElement;
import com.siemens.ct.exi.grammars.event.StartElementGeneric;
import com.siemens.ct.exi.grammars.grammar.DocEnd;
import com.siemens.ct.exi.grammars.grammar.Document;
import com.siemens.ct.exi.grammars.grammar.Fragment;
import com.siemens.ct.exi.grammars.grammar.Grammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedElement;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTagGrammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFragmentContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag;
import com.siemens.ct.exi.grammars.production.Production;
import com.siemens.ct.exi.types.BuiltInType;
import com.siemens.ct.exi.util.PrintfUtils;
import com.siemens.ct.exi.values.IntegerValue;
import com.siemens.ct.exi.values.StringValue;
import com.siemens.ct.exi.values.Value;

public class Grammars2JavaSourceCode {

	protected static final String TOKEN_GRAMMAR_CONTEXT_BEGIN = "/* BEGIN GrammarContext ----- */";
	protected static final String TOKEN_GRAMMAR_CONTEXT_END = "/* END GrammarContext ----- */";

	protected static final String TOKEN_GRAMMARS_BEGIN = "/* BEGIN Grammars ----- */";
	protected static final String TOKEN_GRAMMARS_END = "/* END Grammars ----- */";

	protected static final String TOKEN_GRAMMAR_EVENTS_BEGIN = "/* BEGIN Grammar Events ----- */";
	protected static final String TOKEN_GRAMMAR_EVENTS_END = "/* END Grammar Events ----- */";

	protected static final String TOKEN_GLOBALS_BEGIN = "/* BEGIN Globals ----- */";
	protected static final String TOKEN_GLOBALS_END = "/* END Globals ----- */";

	protected static final String TOKEN_GLOBAL_ELEMENTS_BEGIN = "/* BEGIN GlobalElements ----- */";
	protected static final String TOKEN_GLOBAL_ELEMENTS_END = "/* END GlobalElements ----- */";

	protected static final String TOKEN_GLOBAL_ATTRIBUTES_BEGIN = "/* BEGIN GlobalAttributes ----- */";
	protected static final String TOKEN_GLOBAL_ATTRIBUTES_END = "/* END GlobalAttributes ----- */";

	protected static final String TOKEN_TYPE_GRAMMAR_BEGIN = "/* BEGIN TypeGrammar ----- */";
	protected static final String TOKEN_TYPE_GRAMMAR_END = "/* END TypeGrammar ----- */";

	protected static final String TOKEN_FIRST_STARTTAG_GRAMMAR_BEGIN = "/* BEGIN FirstStartGrammar ----- */";
	protected static final String TOKEN_FIRST_STARTTAG_GRAMMAR_END = "/* END FirstStartGrammar ----- */";

	protected static final String TOKEN_DOCUMENT_GRAMMAR_BEGIN = "/* BEGIN Document Grammar ----- */";
	protected static final String TOKEN_DOCUMENT_GRAMMAR_END = "/* END Document Grammar ----- */";

	protected static final String TOKEN_FRAGMENT_GRAMMAR_BEGIN = "/* BEGIN Fragment Grammar ----- */";
	protected static final String TOKEN_FRAGMENT_GRAMMAR_END = "/* END Fragment Grammar ----- */";

	// package com.siemens.ct.exi.codegen;
	protected static final String TOKEN_PACKAGE = Grammars2JavaSourceCode.class
			.getPackage().toString();
	// public class StaticSampleGrammar
	protected static final String TOKEN_CLASS_SUFFIX = "Template";
	protected static final String TOKEN_CLASS = "public class "
			+ Grammars2JavaSourceCode.class.getSimpleName() + TOKEN_CLASS_SUFFIX;
	protected static final String TOKEN_CLASS_CONSTRUCTOR = "public "
			+ Grammars2JavaSourceCode.class.getSimpleName() + TOKEN_CLASS_SUFFIX;

	static final String STATIC_SAMPLE_GRAMMAR = "./com/siemens/ct/exi/grammars/persistency/Grammars2JavaSourceCodeTemplate.java";

	GrammarsPreperation gpreps = new GrammarsPreperation();

	StringWriter swGC;
	StringWriter swGlobals;
	StringWriter swGlobalElements;
	StringWriter swGlobalAttributes;
	StringWriter swTypeGrammar;
	StringWriter swFirstStartGrammar;

	StringWriter swGrammars;
	StringWriter swEvents;

	int documentGrammarID;
	int fragmentGrammarID;
	
	SchemaInformedGrammars grammars;

	public Grammars2JavaSourceCode(SchemaInformedGrammars grammars) {
		this.grammars = grammars;
	}

	protected int getQNameID(QNameContext qnc) {
		GrammarContext gc = this.grammars.getGrammarContext();

		int qnameID = 0;

		for (int i = 0; i < gc.getNumberOfGrammarUriContexts(); i++) {
			GrammarUriContext guc = gc.getGrammarUriContext(i);
			for (int k = 0; k < guc.getNumberOfQNames(); k++) {
				QNameContext qnX = guc.getQNameContext(k);

				if (qnc.equals(qnX)) {
					return qnameID;
				}

				qnameID++;
			}
		}

		return -1;
	}

	public void generateCode()
			throws IOException {

		// super.prepareRules(exiFactory, seQNames, atQNames);

		// prepare grammar rules
		gpreps.prepareGrammars(grammars);

		documentGrammarID = -1;
		fragmentGrammarID = -1;

		// System.out.println("QNames");

		// global elements/attributes for qnameContext
		swGlobals = new StringWriter();
		swGlobalElements = new StringWriter();
		swGlobalAttributes = new StringWriter();
		swTypeGrammar = new StringWriter();
		swFirstStartGrammar = new StringWriter();

		PrintfUtils.printfIndLn(swGlobalElements, 1, "%s",
				TOKEN_GLOBAL_ELEMENTS_BEGIN);
		PrintfUtils.printfIndLn(swGlobalAttributes, 1, "%s",
				TOKEN_GLOBAL_ATTRIBUTES_BEGIN);
		PrintfUtils.printfIndLn(swTypeGrammar, 1, "%s",
				TOKEN_TYPE_GRAMMAR_BEGIN);
		PrintfUtils.printfIndLn(swFirstStartGrammar, 1, "%s",
				TOKEN_FIRST_STARTTAG_GRAMMAR_BEGIN);

		swGC = new StringWriter();

		PrintfUtils.printfIndLn(swGC, 1, "%s", TOKEN_GRAMMAR_CONTEXT_BEGIN);

		GrammarContext gc = grammars.getGrammarContext();

		StringBuilder sbUriContexts = new StringBuilder();

		int qnameID = 0;

		for (int i = 0; i < gc.getNumberOfGrammarUriContexts(); i++) {
			GrammarUriContext guc = gc.getGrammarUriContext(i);
			// final String ns0 = "";
			PrintfUtils.printfIndLn(swGC, 1, "final String ns%d = \"%s\";", i,
					guc.getNamespaceUri());

			StringBuilder sbQnames = new StringBuilder();

			for (int k = 0; k < guc.getNumberOfQNames(); k++) {
				QNameContext qnc = guc.getQNameContext(k);
				// int namespaceUriID, int localNameID, QName qName, int qNameID
				// final QNameContext qnc0 = new QNameContext(0, 0, new
				// QName(ns0, "notebook"), 0);
				PrintfUtils
						.printfIndLn(
								swGC,
								1,
								"final QNameContext qnc%d = new QNameContext(%d, %d, new QName(ns%d, \"%s\"));",
								qnameID, qnc.getNamespaceUriID(),
								qnc.getLocalNameID(), i, qnc.getLocalName());
				sbQnames.append("qnc");
				sbQnames.append(qnameID);
				if (k != (guc.getNumberOfQNames() - 1)) {
					sbQnames.append(", ");
				}

				assert (qnameID == getQNameID(qnc));

				// global elements
				if (qnc.getGlobalStartElement() != null) {
					StartElement g = qnc.getGlobalStartElement();
					int globalIdID = gpreps.getGrammarID(g.getGrammar());
					PrintfUtils.printfIndLn(swGlobals, 1,
							StartElement.class.getName() + " globalSE%d = new "
									+ StartElement.class.getName() + "(qnc"
									+ qnameID + ", g" + globalIdID + ");",
							qnameID);
					PrintfUtils.printfIndLn(swGlobalElements, 1,
							"qnc%d.setGlobalStartElement(globalSE%d);",
							qnameID, qnameID);
				}

				// global attributes
				if (qnc.getGlobalAttribute() != null) {
					Attribute a = qnc.getGlobalAttribute();
					PrintfUtils.printfIndLn(
							swGlobals,
							1,
							Attribute.class.getName() + " globalAT%d = new "
									+ Attribute.class.getName() + "(qnc"
									+ qnameID + ", "
									+ getDatatypeConstructor(a.getDatatype())
									+ ");", qnameID);
					PrintfUtils.printfIndLn(swGlobalAttributes, 1,
							"qnc%d.setGlobalAttribute(globalAT%d);", qnameID,
							qnameID);
				}

				// type grammar (xsi:type)
				if (qnc.getTypeGrammar() != null) {
					SchemaInformedFirstStartTagGrammar sifstg = qnc
							.getTypeGrammar();
					int grID = gpreps.getGrammarID(sifstg);
					PrintfUtils.printfIndLn(swTypeGrammar, 1,
							"qnc%d.setTypeGrammar(g%d);", qnameID, grID);
				}

				qnameID++;
			}

			// final QNameContext[] grammarQNames0 = {qnc0, qnc1};
			PrintfUtils
					.printfIndLn(swGC, 1,
							"final QNameContext[] grammarQNames%d = {%s};", i,
							sbQnames);

			// final String[] grammarPrefixes0 = {""};
			StringBuilder sbPrefixes = new StringBuilder();
			for (int k = 0; k < guc.getNumberOfPrefixes(); k++) {
				sbPrefixes.append("\"");
				sbPrefixes.append(guc.getPrefix(k));
				sbPrefixes.append("\"");
				if (k != (guc.getNumberOfPrefixes() - 1)) {
					sbPrefixes.append(", ");
				}
			}
			PrintfUtils.printfIndLn(swGC, 1,
					"final String[] grammarPrefixes%d = {%s};", i, sbPrefixes);

			// final GrammarUriContext guc0 = new GrammarUriContext(0, ns0,
			// grammarQNames0, grammarPrefixes0);
			PrintfUtils
					.printfIndLn(
							swGC,
							1,
							"final GrammarUriContext guc%d = new GrammarUriContext(%d, ns%d, grammarQNames%d, grammarPrefixes%d);",
							i, i, i, i, i);

			sbUriContexts.append("guc");
			sbUriContexts.append(i);
			if (i != (gc.getNumberOfGrammarUriContexts() - 1)) {
				sbUriContexts.append(", ");
			}

			PrintfUtils.printfIndLn(swGC, 1, "");
		}

		// final GrammarUriContext[] grammarUriContexts = {guc0, guc1};
		PrintfUtils.printfIndLn(swGC, 1,
				"final GrammarUriContext[] grammarUriContexts = {%s};",
				sbUriContexts);

		// final GrammarContext gc = new GrammarContext(grammarUriContexts, 6);
		PrintfUtils
				.printfIndLn(
						swGC,
						1,
						"final GrammarContext gc = new GrammarContext(grammarUriContexts, %d);",
						gc.getNumberOfGrammarQNameContexts());

		PrintfUtils.printfIndLn(swGC, 1, "%s", TOKEN_GRAMMAR_CONTEXT_END);
		PrintfUtils.printfIndLn(swGlobalElements, 1, "%s",
				TOKEN_GLOBAL_ELEMENTS_END);
		PrintfUtils.printfIndLn(swGlobalAttributes, 1, "%s",
				TOKEN_GLOBAL_ATTRIBUTES_END);
		PrintfUtils.printfIndLn(swTypeGrammar, 1, "%s", TOKEN_TYPE_GRAMMAR_END);

		swGrammars = new StringWriter();
		swEvents = new StringWriter();

		PrintfUtils.printfIndLn(swGrammars, 1, "%s", TOKEN_GRAMMARS_BEGIN);
		PrintfUtils.printfIndLn(swEvents, 1, "%s", TOKEN_GRAMMAR_EVENTS_BEGIN);

		// walk-over all rules
		// Iterator<Grammar> iterGrs = gpreps.getGrammarIterator();
		// while (iterGrs.hasNext()) {
		for (int i = 0; i < gpreps.getNumberOfGrammars(); i++) {
			// for(Grammar r : this.handledRules) {

			// Grammar r = iterGrs.next();
			Grammar r = gpreps.getGrammar(i);

			int currentID = gpreps.getGrammarID(r);
			int numberOfEvents = r.getNumberOfEvents();

			String sConstructor = "null";

			switch (r.getGrammarType()) {
			/* Root grammars */
			case DOCUMENT:
				sConstructor = "new " + Document.class.getName() + "()";
				documentGrammarID = currentID;
				break;
			case FRAGMENT:
				sConstructor = "new " + Fragment.class.getName() + "()";
				fragmentGrammarID = currentID;
				break;
			case DOC_END:
				sConstructor = "new " + DocEnd.class.getName() + "()";
				break;
			/* Schema-informed Document and Fragment Grammars */
			case SCHEMA_INFORMED_DOC_CONTENT:
				sConstructor = "new "
						+ SchemaInformedDocContent.class.getName() + "()";
				break;
			case SCHEMA_INFORMED_FRAGMENT_CONTENT:
				sConstructor = "new "
						+ SchemaInformedFragmentContent.class.getName() + "()";
				break;
			/* Schema-informed Element and Type Grammars */
			case SCHEMA_INFORMED_FIRST_START_TAG_CONTENT:
				sConstructor = "new "
						+ SchemaInformedFirstStartTag.class.getName() + "()";
				SchemaInformedFirstStartTag sifst = (SchemaInformedFirstStartTag) r;

				/*
				 * g2.setElementContentGrammar(null); g2.setTypeCastable(false);
				 * g2.setNillable(false); g2.setTypeEmpty(null);
				 * g2.setTypeName(null);
				 */
				PrintfUtils.printfIndLn(
						swFirstStartGrammar,
						1,
						"g%d.setElementContentGrammar(%s);",
						currentID,
						"g"
								+ gpreps.getGrammarID(sifst
										.getElementContentGrammar()));
				if (sifst.isTypeCastable()) {
					PrintfUtils.printfIndLn(swFirstStartGrammar, 1,
							"g%d.setTypeCastable(%s);", currentID,
							sifst.isTypeCastable());
				}
				if (sifst.isNillable()) {
					PrintfUtils.printfIndLn(swFirstStartGrammar, 1,
							"g%d.setNillable(%s);", currentID,
							sifst.isNillable());
				}
				break;
			case SCHEMA_INFORMED_START_TAG_CONTENT:
				sConstructor = "new " + SchemaInformedStartTag.class.getName()
						+ "()";
				break;
			case SCHEMA_INFORMED_ELEMENT_CONTENT:
				sConstructor = "new " + SchemaInformedElement.class.getName()
						+ "()";
				break;
			/* Built-in Document and Fragment Grammars */
			case BUILT_IN_DOC_CONTENT:
			case BUILT_IN_FRAGMENT_CONTENT:
				/* Built-in Element Grammars */
			case BUILT_IN_START_TAG_CONTENT:
			case BUILT_IN_ELEMENT_CONTENT:
				throw new RuntimeException("Unsupported GrammarType "
						+ r.getGrammarType());
				/* break; */
			}

			PrintfUtils.printfIndLn(swGrammars, 1, "%s g%d = %s;", r.getClass()
					.getName(), currentID, sConstructor);

			/*
			 * Specific Events (encode and decode)
			 */
			sConstructor = null;
			for (int eventCode = 0; eventCode < numberOfEvents; eventCode++) {
				Production ei = r.getProduction(eventCode);
				int nextID = gpreps.getGrammarID(ei.getNextGrammar());

				switch (ei.getEvent().getEventType()) {
				case START_DOCUMENT:
					// g0.addProduction(new StartDocument(), g1);
					sConstructor = "new " + StartDocument.class.getName()
							+ "()";
					break;
				case END_DOCUMENT:
					sConstructor = "new " + EndDocument.class.getName() + "()";
					break;
				case START_ELEMENT:
					StartElement se = (StartElement) ei.getEvent();
					if (se.getQNameContext().getGlobalStartElement() == se) {
						sConstructor = "globalSE"
								+ getQNameID(se.getQNameContext());
					} else {
						sConstructor = "new " + StartElement.class.getName()
								+ "(qnc" + getQNameID(se.getQNameContext())
								+ ", g" + gpreps.getGrammarID(se.getGrammar())
								+ ")";
					}
					break;
				case START_ELEMENT_GENERIC:
					@SuppressWarnings("unused")
					StartElementGeneric seGen = (StartElementGeneric) ei
							.getEvent();
					sConstructor = "new " + StartElementGeneric.class.getName()
							+ "()";
					break;
				case END_ELEMENT:
					sConstructor = "new " + EndElement.class.getName() + "()";
					break;
				case CHARACTERS:
					Characters ch = (Characters) ei.getEvent();
					sConstructor = "new " + Characters.class.getName() + "("
							+ getDatatypeConstructor(ch.getDatatype()) + ")";
					break;
				case CHARACTERS_GENERIC:
					// CharactersGeneric chGen = (CharactersGeneric)
					// ei.getEvent();
					sConstructor = "new " + CharactersGeneric.class.getName()
							+ "()";
					break;
				case ATTRIBUTE:
					Attribute at = (Attribute) ei.getEvent();

					if (at.getQNameContext().getGlobalAttribute() == at) {
						sConstructor = "globalAT"
								+ getQNameID(at.getQNameContext());
					} else {
						sConstructor = "new " + Attribute.class.getName()
								+ "(qnc" + getQNameID(at.getQNameContext())
								+ ", "
								+ getDatatypeConstructor(at.getDatatype())
								+ ")";
					}

					// atWriterDecode.append("AT --> " + currentID + " move to "
					// +
					// nextID + "\n");
					break;
				case ATTRIBUTE_GENERIC:
					sConstructor = "new " + AttributeGeneric.class.getName()
							+ "()";
					break;
				default:
					throw new RuntimeException("Unsupported Event = "
							+ ei.getEvent());
				}

				PrintfUtils.printfIndLn(swEvents, 1,
						"g%d.addProduction(%s, g%d);", currentID, sConstructor,
						nextID);
			}
		}

		PrintfUtils.printfIndLn(swEvents, 1, "%s", TOKEN_GRAMMAR_EVENTS_END);
		PrintfUtils.printfIndLn(swGrammars, 1, "%s", TOKEN_GRAMMARS_END);
		PrintfUtils.printfIndLn(swFirstStartGrammar, 1, "%s",
				TOKEN_FIRST_STARTTAG_GRAMMAR_END);
	}

	public static String readFileToString(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringWriter sFile = new StringWriter();
		int c;

		while ((c = reader.read()) != -1) {
			sFile.append((char) c);
		}
		reader.close();

		return sFile.toString();
	}

	// packageName: is the string "package " and the package name
	public String getGrammars(String packageName, String className)
			throws IOException {
		// File staticSimpleGrammar = new File(STATIC_SAMPLE_GRAMMAR);
		ClassLoader classLoader = getClass().getClassLoader();
		File staticSimpleGrammar = new File(classLoader.getResource(STATIC_SAMPLE_GRAMMAR).getFile());
		
		StringBuilder sStaticSimpleGrammar = new StringBuilder(
				readFileToString(staticSimpleGrammar));

		// System.out.println(sStaticSimpleGrammar.length());

		// grammar context
		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMAR_CONTEXT_BEGIN,
				TOKEN_GRAMMAR_CONTEXT_END, swGC.toString());
		// grammars
		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMARS_BEGIN,
				TOKEN_GRAMMARS_END, swGrammars.toString());
		// globals (ATs, SEs)
		this.replace(sStaticSimpleGrammar, TOKEN_GLOBALS_BEGIN,
				TOKEN_GLOBALS_END, swGlobals.toString());
		// globals elements
		this.replace(sStaticSimpleGrammar, TOKEN_GLOBAL_ELEMENTS_BEGIN,
				TOKEN_GLOBAL_ELEMENTS_END, swGlobalElements.toString());
		// globals attributes
		this.replace(sStaticSimpleGrammar, TOKEN_GLOBAL_ATTRIBUTES_BEGIN,
				TOKEN_GLOBAL_ATTRIBUTES_END, swGlobalAttributes.toString());
		// type grammar
		this.replace(sStaticSimpleGrammar, TOKEN_TYPE_GRAMMAR_BEGIN,
				TOKEN_TYPE_GRAMMAR_END, swTypeGrammar.toString());
		// grammar events
		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMAR_EVENTS_BEGIN,
				TOKEN_GRAMMAR_EVENTS_END, swEvents.toString());
		// first startTag grammar
		this.replace(sStaticSimpleGrammar, TOKEN_FIRST_STARTTAG_GRAMMAR_BEGIN,
				TOKEN_FIRST_STARTTAG_GRAMMAR_END,
				swFirstStartGrammar.toString());
		// document grammar ID
		assert (documentGrammarID != -1);
		this.replace(sStaticSimpleGrammar, TOKEN_DOCUMENT_GRAMMAR_BEGIN,
				TOKEN_DOCUMENT_GRAMMAR_END, "return g" + documentGrammarID
						+ ";");
		// fragment grammar ID
		assert (fragmentGrammarID != -1);
		this.replace(sStaticSimpleGrammar, TOKEN_FRAGMENT_GRAMMAR_BEGIN,
				TOKEN_FRAGMENT_GRAMMAR_END, "return g" + fragmentGrammarID
						+ ";");

		// System.out.println(sStaticSimpleGrammar.length());

		// package com.siemens.ct.exi.codegen
		this.replace(sStaticSimpleGrammar, TOKEN_PACKAGE, TOKEN_PACKAGE,
				packageName);

		// public class StaticSampleGrammar
		this.replace(sStaticSimpleGrammar, TOKEN_CLASS, TOKEN_CLASS,
				"public class " + className);
		this.replace(sStaticSimpleGrammar, TOKEN_CLASS_CONSTRUCTOR,
				TOKEN_CLASS_CONSTRUCTOR, "public " + className );

		return sStaticSimpleGrammar.toString();
	}

	void replace(StringBuilder sb, String tokenBegin, String tokenEnd,
			String newToken) {
		int ib = sb.indexOf(tokenBegin);
		int iE = sb.indexOf(tokenEnd);
		if (ib == -1 || iE == -1 || ib > iE) {
			throw new RuntimeException("Could not find the token BEGIN/END");
		}
		iE += tokenEnd.length();
		sb.replace(ib, iE, newToken);
	}

	private String getDatatypeConstructor(Datatype dt) {
		String addP = "";
		if (dt.getBuiltInType() == BuiltInType.DATETIME) {
			DatetimeDatatype dtt = (DatetimeDatatype) dt;
			addP = dtt.getDatetimeType().getClass().getName() + "."
					+ dtt.getDatetimeType().name() + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.NBIT_UNSIGNED_INTEGER) {
			NBitUnsignedIntegerDatatype nbDT = (NBitUnsignedIntegerDatatype) dt;
			IntegerValue lb = nbDT.getLowerBound();
			IntegerValue ub = nbDT.getUpperBound();
			addP = getIntegerValue(lb) + ", " + getIntegerValue(ub) + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.LIST) {
			ListDatatype ldt = (ListDatatype) dt;
			addP = getDatatypeConstructor(ldt.getListDatatype()) + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.ENUMERATION) {
			EnumerationDatatype edt = (EnumerationDatatype) dt;
			// Value[] enumValues, Datatype dtEnumValues, QNameContext
			// schemaType
			// Value[] enumValues = {new StringValue("a"), new
			// StringValue("b")};

			StringBuilder sv = new StringBuilder("new " + Value.class.getName()
					+ "[] {");
			for (int i = 0; i < edt.getEnumerationSize(); i++) {
				Value v = edt.getEnumValue(i);
				sv.append("new " + v.getClass().getName() + "(");
				if (v instanceof StringValue) {
					sv.append("\"" + v.toString() + "\"");
				} else {

				}
				sv.append(")");
				if (i < (edt.getEnumerationSize() - 1)) {
					sv.append(", ");
				}
			}
			sv.append("}");

			String sdt = this
					.getDatatypeConstructor(edt.getEnumValueDatatype());

			addP = sv + ", " + sdt + ", ";

			// EnumerationDatatype edtX = new EnumerationDatatype(new Value[]
			// {new StringValue("a"), new StringValue("b")},
			// edt.getEnumValueDatatype(), null);
		}

		String s = "new " + dt.getClass().getName() + "(" + addP + "qnc"
				+ getQNameID(dt.getSchemaType()) + ")";

		return s;
	}

	private String getIntegerValue(IntegerValue iv) {
		String s;
		switch (iv.getIntegerValueType()) {
		case INT:
			s = IntegerValue.class.getName() + ".valueOf(" + iv.intValue()
					+ ")";
			break;
		case LONG:
			s = IntegerValue.class.getName() + ".valueOf(" + iv.longValue()
					+ "l)";
			break;
		case BIG:
			s = IntegerValue.class.getName() + ".valueOf(new "
					+ BigInteger.class.getName() + "(" + iv.bigIntegerValue()
					+ "))";
			break;
		default:
			throw new RuntimeException("Unsupported IntegerType " + iv);
		}

		return s;
	}

	public static void main(String[] args) throws EXIException, IOException {
		String className = "Notebook";
		String xsd = "./data/W3C/PrimerNotebook/notebook.xsd";
		
//		String className = "ISO15118_2_2013";
//		String xsd = "..\\V2G_CI_MsgDef.xsd";
		
		// String xsd =
		// "D:/Projects/EXI/EXIficient/exificient/data/EXIOptionsHeader/EXIOptionsHeader.xsd";

		XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

		grammarBuilder.loadGrammars(xsd);

		SchemaInformedGrammars grammarIn = grammarBuilder.toGrammars();

		Grammars2JavaSourceCode grammar2Java = new Grammars2JavaSourceCode(grammarIn);

		grammar2Java.generateCode();

		String sf = grammar2Java.getGrammars(
				Grammars2JavaSourceCode.class.getPackage().toString(),
				className);
		System.out.println(sf);
		
		if(true) {
			File f = File.createTempFile(className, ".java");
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(sf.getBytes());
			fos.close();
			System.out.println("Written to file: " + f);
		}

		// String filename = "C:\\Users\\mchn4310\\Desktop\\gr.xml";
		// XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
		// new FileOutputStream(filename)));
		// // encoder.writeObject(grammarIn.getGrammarContext());
		// encoder.writeObject(grammarIn);
		// encoder.close();
	}

}
