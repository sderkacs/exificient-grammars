package com.siemens.ct.exi.grammars.persistency;

import com.siemens.ct.exi.core.context.GrammarContext;
import com.siemens.ct.exi.core.context.GrammarUriContext;
import com.siemens.ct.exi.core.context.QNameContext;
import com.siemens.ct.exi.core.datatype.*;
import com.siemens.ct.exi.core.exceptions.EXIException;
import com.siemens.ct.exi.core.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.core.grammars.event.*;
import com.siemens.ct.exi.core.grammars.grammar.Grammar;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedFirstStartTag;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedFirstStartTagGrammar;
import com.siemens.ct.exi.core.grammars.grammar.SchemaInformedStartTag;
import com.siemens.ct.exi.core.grammars.production.Production;
import com.siemens.ct.exi.core.types.BuiltIn;
import com.siemens.ct.exi.core.types.BuiltInType;
import com.siemens.ct.exi.core.values.IntegerValue;
import com.siemens.ct.exi.core.values.StringValue;
import com.siemens.ct.exi.core.values.Value;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;
import com.siemens.ct.exi.grammars.util.PrintfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;

public class Grammars2GoSourceCode {

	/** The logger used in this class. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Grammars2GoSourceCode.class);

	protected static final String TOKEN_GRAMMAR_STRUCT_INIT_BEGIN = "/* BEGIN GrammarStructInit ----- */";
	protected static final String TOKEN_GRAMMAR_STRUCT_INIT_END = "/* END GrammarStructInit ----- */";

	protected static final String TOKEN_GRAMMAR_CONTEXT_BEGIN = "/* BEGIN GrammarContext ----- */";
	protected static final String TOKEN_GRAMMAR_CONTEXT_END = "/* END GrammarContext ----- */";

	protected static final String TOKEN_GRAMMARS_BEGIN = "/* BEGIN Grammars ----- */";
	protected static final String TOKEN_GRAMMARS_END = "/* END Grammars ----- */";

	protected static final String TOKEN_GRAMMARS_WITH_ELEMENT_CONTENT_BEGIN = "/* BEGIN Grammars with element content ----- */";
	protected static final String TOKEN_GRAMMARS_WITH_ELEMENT_CONTENT_END = "/* END Grammars with element content ----- */";

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

	// package template
	protected static final String TOKEN_PACKAGE_PREFIX = "package ";
	protected static final String TOKEN_PACKAGE_BEGIN = "/* BEGIN Package ----- */";
	protected static final String TOKEN_PACKAGE_END = "/* END Package ----- */";

	// public class StaticSampleGrammar
	protected static final String TOKEN_CLASS_SUFFIX = "Template";
	protected static final String TOKEN_STRUCT = Grammars2GoSourceCode.class.getSimpleName() + TOKEN_CLASS_SUFFIX;
//	protected static final String TOKEN_CLASS = "type " + Grammars2GoSourceCode.class.getSimpleName() + TOKEN_CLASS_SUFFIX + " struct ";
//	protected static final String TOKEN_CLASS_CONSTRUCTOR = "func New" + Grammars2GoSourceCode.class.getSimpleName() + TOKEN_CLASS_SUFFIX;

	static final String STATIC_SAMPLE_GRAMMAR = "com/siemens/ct/exi/grammars/persistency/Grammars2GoSourceCodeTemplate.go";

	GrammarsPreperation gpreps = new GrammarsPreperation();

	StringWriter swGC;
	StringWriter swGlobals;
	StringWriter swGlobalElements;
	StringWriter swGlobalAttributes;
	StringWriter swTypeGrammar;
	StringWriter swFirstStartGrammar;

	StringWriter swGrammars;
	StringWriter swGrammarsWithElementContent;
	StringWriter swEvents;

	int documentGrammarID;
	int fragmentGrammarID;

	String schemaId;

	SchemaInformedGrammars grammars;

	public Grammars2GoSourceCode(SchemaInformedGrammars grammars) {
		this.grammars = grammars;
	}

	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
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

	public void generateCode() throws IOException {

		// super.prepareRules(exiFactory, seQNames, atQNames);

		// prepare grammar rules
		gpreps.prepareGrammars(grammars);

		documentGrammarID = -1;
		fragmentGrammarID = -1;

		boolean errorDeclared = false;

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
			PrintfUtils.printfIndLn(swGC, 1, "ns%d := \"%s\"", i,
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
								"qnc%d := core.NewQNameContext(%d, %d, utils.QName{ Space: ns%d, Local: \"%s\"})",
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
							"globalSE%d := core.New" + StartElement.class.getSimpleName() + "WithGrammar(qnc" + qnameID + ", g" + globalIdID + ")",
							qnameID);
					PrintfUtils.printfIndLn(swGlobalElements, 1,
							"qnc%d.SetGlobalStartElement(globalSE%d)",
							qnameID, qnameID);
				}

				// global attributes
				if (qnc.getGlobalAttribute() != null) {
					Attribute a = qnc.getGlobalAttribute();
					PrintfUtils.printfIndLn(
							swGlobals,
							1,
							"globalAT%d := core.New" + Attribute.class.getSimpleName() + "(qnc" + qnameID + ", " + getDatatypeConstructor(a.getDatatype(), false) + ")"
							, qnameID);
					PrintfUtils.printfIndLn(swGlobalAttributes, 1,
							"qnc%d.SetGlobalAttribute(globalAT%d)", qnameID,
							qnameID);
				}

				// type grammar (xsi:type)
				if (qnc.getTypeGrammar() != null) {
					SchemaInformedFirstStartTagGrammar sifstg = qnc
							.getTypeGrammar();
					int grID = gpreps.getGrammarID(sifstg);
					PrintfUtils.printfIndLn(swTypeGrammar, 1,
							"qnc%d.SetTypeGrammar(g%d)", qnameID, grID);
				}

				qnameID++;
			}

			// final QNameContext[] grammarQNames0 = {qnc0, qnc1};
			PrintfUtils
					.printfIndLn(swGC, 1,
							"grammarQNames%d := []*core.QNameContext{%s}", i,
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
					"grammarPrefixes%d := []string{%s}", i, sbPrefixes);

			// final GrammarUriContext guc0 = new GrammarUriContext(0, ns0,
			// grammarQNames0, grammarPrefixes0);
			PrintfUtils
					.printfIndLn(
							swGC,
							1,
							"guc%d := core.NewGrammarUriContext(%d, ns%d, grammarQNames%d, grammarPrefixes%d)",
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
				"grammarUriContexts := []*core.GrammarUriContext{%s}",
				sbUriContexts);

		// final GrammarContext gc = new GrammarContext(grammarUriContexts, 6);
		PrintfUtils
				.printfIndLn(
						swGC,
						1,
						"gc := core.NewGrammarContext(grammarUriContexts, %d)",
						gc.getNumberOfGrammarQNameContexts());

		PrintfUtils.printfIndLn(swGC, 1, "%s", TOKEN_GRAMMAR_CONTEXT_END);
		PrintfUtils.printfIndLn(swGlobalElements, 1, "%s",
				TOKEN_GLOBAL_ELEMENTS_END);
		PrintfUtils.printfIndLn(swGlobalAttributes, 1, "%s",
				TOKEN_GLOBAL_ATTRIBUTES_END);
		PrintfUtils.printfIndLn(swTypeGrammar, 1, "%s", TOKEN_TYPE_GRAMMAR_END);

		swGrammars = new StringWriter();
		swGrammarsWithElementContent = new StringWriter();
		swEvents = new StringWriter();

		PrintfUtils.printfIndLn(swGrammars, 1, "%s", TOKEN_GRAMMARS_BEGIN);
		PrintfUtils.printfIndLn(swGrammarsWithElementContent, 1, "%s",
				TOKEN_GRAMMARS_WITH_ELEMENT_CONTENT_BEGIN);
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
				documentGrammarID = currentID;
				PrintfUtils.printfIndLn(swGrammars, 1, "g%d := core.New%s()", currentID, r.getClass().getSimpleName());
				break;
			case FRAGMENT:
				fragmentGrammarID = currentID;
				PrintfUtils.printfIndLn(swGrammars, 1, "g%d := core.New%s()", currentID, r.getClass().getSimpleName());
				break;
			case DOC_END:
				/* Schema-informed Document and Fragment Grammars */
			case SCHEMA_INFORMED_DOC_CONTENT:
			case SCHEMA_INFORMED_FRAGMENT_CONTENT:
			case SCHEMA_INFORMED_ELEMENT_CONTENT:
				PrintfUtils.printfIndLn(swGrammars, 1, "g%d := core.New%s()", currentID, r.getClass().getSimpleName());
				break;
			/* Schema-informed Element and Type Grammars */
			case SCHEMA_INFORMED_FIRST_START_TAG_CONTENT: {
				SchemaInformedFirstStartTag sifst = (SchemaInformedFirstStartTag) r;
				Grammar elementContentGrammar = sifst
						.getElementContentGrammar();
				int elementContentGrammarID = gpreps
						.getGrammarID(elementContentGrammar);
				PrintfUtils.printfIndLn(swGrammarsWithElementContent, 1,
						"g%d := core.New%sWithEC2(g%d)", currentID, r.getClass().getSimpleName(), elementContentGrammarID);
				/*
				 * g2.setElementContentGrammar(null); g2.setTypeCastable(false);
				 * g2.setNillable(false); g2.setTypeEmpty(null);
				 * g2.setTypeName(null);
				 */
				PrintfUtils.printfIndLn(
						swFirstStartGrammar,
						1,
						"g%d.SetElementContentGrammar(%s)",
						currentID,
						"g"
								+ gpreps.getGrammarID(sifst
										.getElementContentGrammar()));
				if (sifst.isTypeCastable()) {
					PrintfUtils.printfIndLn(swFirstStartGrammar, 1,
							"g%d.SetTypeCastable(%s)", currentID,
							sifst.isTypeCastable());
				}
				if (sifst.isNillable()) {
					PrintfUtils.printfIndLn(swFirstStartGrammar, 1,
							"g%d.SetNillable(%s);", currentID,
							sifst.isNillable());
				}
				break;
			}
			case SCHEMA_INFORMED_START_TAG_CONTENT: {
				SchemaInformedStartTag sist = (SchemaInformedStartTag) r;
				Grammar elementContentGrammar = sist.getElementContentGrammar();
				if (elementContentGrammar instanceof SchemaInformedStartTag) {
					LOGGER.error("Error for {} and {}", sist, elementContentGrammar);
				}
				int elementContentGrammarID = gpreps
						.getGrammarID(elementContentGrammar);
				PrintfUtils.printfIndLn(swGrammarsWithElementContent, 1,
						"g%d := core.New%sWithEC2(g%d)", currentID, r.getClass().getSimpleName(), elementContentGrammarID);
				break;
			}
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

			/*
			 * Specific Events (encode and decode)
			 */
			for (int eventCode = 0; eventCode < numberOfEvents; eventCode++) {
				Production ei = r.getProduction(eventCode);
				int nextID = gpreps.getGrammarID(ei.getNextGrammar());
				String sConstructorWithError = null;

				switch (ei.getEvent().getEventType()) {
				case START_DOCUMENT:
					// g0.addProduction(new StartDocument(), g1);
					sConstructor = "core.New" + StartDocument.class.getSimpleName() + "()";
					break;
				case END_DOCUMENT:
					sConstructor = "core.New" + EndDocument.class.getSimpleName() + "()";
					break;
				case START_ELEMENT:
					StartElement se = (StartElement) ei.getEvent();
					if (se.getQNameContext().getGlobalStartElement() == se) {
						sConstructor = "globalSE" + getQNameID(se.getQNameContext());
					} else {
						sConstructor = "core.New" + StartElement.class.getSimpleName()
								+ "WithGrammar(qnc" + getQNameID(se.getQNameContext())
								+ ", g" + gpreps.getGrammarID(se.getGrammar())
								+ ")";
					}
					break;
				case START_ELEMENT_NS:
					StartElementNS seNS = (StartElementNS) ei.getEvent();
					sConstructor = "core.New" + StartElementNS.class.getSimpleName()
							+ "(" + seNS.getNamespaceUriID() + ", \""
							+ seNS.getNamespaceURI() + "\")";
					break;
				case START_ELEMENT_GENERIC:
					@SuppressWarnings("unused")
					StartElementGeneric seGen = (StartElementGeneric) ei
							.getEvent();
					sConstructor = "core.New" + StartElementGeneric.class.getSimpleName() + "()";
					break;
				case END_ELEMENT:
					sConstructor = "core.New" + EndElement.class.getSimpleName() + "()";
					break;
				case CHARACTERS:
					Characters ch = (Characters) ei.getEvent();
					sConstructor = "core.New" + Characters.class.getSimpleName() + "("
							+ getDatatypeConstructor(ch.getDatatype(), false) + ")";
					break;
				case CHARACTERS_GENERIC:
					// CharactersGeneric chGen = (CharactersGeneric)
					// ei.getEvent();
					sConstructor = "core.New" + CharactersGeneric.class.getSimpleName() + "()";
					break;
				case ATTRIBUTE:
					Attribute at = (Attribute) ei.getEvent();

					if (at.getQNameContext().getGlobalAttribute() == at) {
						sConstructor = "globalAT" + getQNameID(at.getQNameContext());
					} else {
						sConstructor = "core.New" + Attribute.class.getSimpleName()
								+ "WithDatatype(qnc" + getQNameID(at.getQNameContext())
								+ ", "
								+ getDatatypeConstructor(at.getDatatype(), false)
								+ ")";
					}

					// atWriterDecode.append("AT --> " + currentID + " move to "
					// +
					// nextID + "\n");
					break;
				case ATTRIBUTE_GENERIC:
					sConstructor = "core.New" + AttributeGeneric.class.getSimpleName() + "()";
					break;
				default:
					throw new RuntimeException("Unsupported Event = " + ei.getEvent());
				}

				PrintfUtils.printfIndLn(swEvents, 1,
						"g%d.AddProduction(%s, g%d)", currentID, sConstructor,
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
		// check whether it contains the needed package prefix
		packageName = packageName.trim();

		// File staticSimpleGrammar = new File(STATIC_SAMPLE_GRAMMAR);
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader
				.getResource(STATIC_SAMPLE_GRAMMAR).openStream();

		BufferedInputStream bis = new BufferedInputStream(inputStream);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		int result = bis.read();
		while (result != -1) {
			buf.write((byte) result);
			result = bis.read();
		}
		// StandardCharsets.UTF_8.name() > JDK 7
		StringBuilder sStaticSimpleGrammar = new StringBuilder(
				buf.toString("UTF-8"));

		// File staticSimpleGrammar = new
		// File(classLoader.getResource(STATIC_SAMPLE_GRAMMAR).getFile());
		//
		// StringBuilder sStaticSimpleGrammar = new StringBuilder(
		// readFileToString(staticSimpleGrammar));

		// System.out.println(sStaticSimpleGrammar.length());

		// grammar context
		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMAR_CONTEXT_BEGIN,
				TOKEN_GRAMMAR_CONTEXT_END, swGC.toString());
		// grammars
		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMARS_BEGIN,
				TOKEN_GRAMMARS_END, swGrammars.toString());
		// grammars
		this.replace(sStaticSimpleGrammar,
				TOKEN_GRAMMARS_WITH_ELEMENT_CONTENT_BEGIN,
				TOKEN_GRAMMARS_WITH_ELEMENT_CONTENT_END,
				swGrammarsWithElementContent.toString());
		// globals (ATs, SEs)
		this.replace(sStaticSimpleGrammar, TOKEN_GLOBALS_BEGIN,
				TOKEN_GLOBALS_END, swGlobals.toString());
		// schemaId
//		if (schemaId != null) {
//			this.replace(sStaticSimpleGrammar, TOKEN_SCHEMA_ID_BEGIN, TOKEN_SCHEMA_ID_END, "g.schemaId = \"" + schemaId + "\"");
//		}
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
//		this.replace(sStaticSimpleGrammar, TOKEN_DOCUMENT_GRAMMAR_BEGIN,
//				TOKEN_DOCUMENT_GRAMMAR_END, "return g" + documentGrammarID);
		// fragment grammar ID
		assert (fragmentGrammarID != -1);
//		this.replace(sStaticSimpleGrammar, TOKEN_FRAGMENT_GRAMMAR_BEGIN,
//				TOKEN_FRAGMENT_GRAMMAR_END, "return g" + fragmentGrammarID);

		// System.out.println(sStaticSimpleGrammar.length());

		// package com.siemens.ct.exi.codegen
		this.replace(sStaticSimpleGrammar, TOKEN_PACKAGE_BEGIN, TOKEN_PACKAGE_END, TOKEN_PACKAGE_PREFIX + packageName);

		// public class StaticSampleGrammar
		//this.replace(sStaticSimpleGrammar, TOKEN_CLASS, TOKEN_CLASS, "type " + className + " struct");
		//this.replace(sStaticSimpleGrammar, TOKEN_CLASS_CONSTRUCTOR, TOKEN_CLASS_CONSTRUCTOR, "func New" + className);
		this.replaceAll(sStaticSimpleGrammar, TOKEN_STRUCT, TOKEN_STRUCT, className);

		int siefGrammarID = gpreps.getGrammarID(grammars
				.getSchemaInformedElementFragmentGrammar());
//		this.replace(sStaticSimpleGrammar,
//				TOKEN_SCHEMA_INFORMED_GRAMMARS_BEGIN,
//				TOKEN_SCHEMA_INFORMED_GRAMMARS_END,
//				"gs := grammars.NewSchemaInformedGrammars(g.grammarContext, g.g" + documentGrammarID + ", g.g" + fragmentGrammarID + ", g.g" + siefGrammarID + ")");

		this.replace(sStaticSimpleGrammar, TOKEN_GRAMMAR_STRUCT_INIT_BEGIN, TOKEN_GRAMMAR_STRUCT_INIT_END,
				"return &" + className + "{\n" +
						"schemaID:       " + (schemaId != null ? schemaId : "nil") + ",\n" +
						"grammarContext: gc,\n" +
						"document:       g" + documentGrammarID + ",\n" +
						"fragment:       g" + fragmentGrammarID + ",\n" +
						"sief:           g" + siefGrammarID + ",\n" +
						"}, nil");

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

	void replaceAll(StringBuilder sb, String tokenBegin, String tokenEnd, String newToken) {
		try {
			while (true) {
				replace(sb, tokenBegin, tokenEnd, newToken);
			}
		} catch (Exception e) {}
	}

	private String capitalize(String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(1);
	}

	private String getDatatypeConstructor(Datatype dt, boolean skipInner) {
		String addP = "";
		if (dt.getBuiltInType() == BuiltInType.DATETIME) {
			DatetimeDatatype dtt = (DatetimeDatatype) dt;
			//addP = dtt.getDatetimeType().getClass().getSimpleName() + "." + dtt.getDatetimeType().name() + ", ";
			addP = "core.DateTime" + capitalize(dtt.getDatetimeType().name()) + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.NBIT_UNSIGNED_INTEGER) {
			NBitUnsignedIntegerDatatype nbDT = (NBitUnsignedIntegerDatatype) dt;
			IntegerValue lb = nbDT.getLowerBound();
			IntegerValue ub = nbDT.getUpperBound();
			addP = getIntegerValue(lb) + ", " + getIntegerValue(ub) + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.LIST) {
			ListDatatype ldt = (ListDatatype) dt;
			addP = getDatatypeConstructor(ldt.getListDatatype(), false) + ", ";
		} else if (dt.getBuiltInType() == BuiltInType.ENUMERATION) {
			EnumerationDatatype edt = (EnumerationDatatype) dt;
			// Value[] enumValues, Datatype dtEnumValues, QNameContext
			// schemaType
			// Value[] enumValues = {new StringValue("a"), new
			// StringValue("b")};

			StringBuilder sv = new StringBuilder("[]core." + Value.class.getSimpleName() + "{");
			for (int i = 0; i < edt.getEnumerationSize(); i++) {
				Value v = edt.getEnumValue(i);
				String clazz = v.getClass().getSimpleName();
				if (v instanceof StringValue) {
					clazz += "FromString";
				}

				sv.append("core.New" + clazz + "(");
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
					.getDatatypeConstructor(edt.getEnumValueDatatype(), false);

			addP = sv + ", " + sdt + ", ";

			// EnumerationDatatype edtX = new EnumerationDatatype(new Value[]
			// {new StringValue("a"), new StringValue("b")},
			// edt.getEnumValueDatatype(), null);
		}

		// BuiltIn.DEFAULT_DATATYPE;

		int qnameID = getQNameID(dt.getSchemaType());
		String s;
		if (qnameID < 0) {
			s = "core." + BuiltIn.class.getSimpleName() + "GetDefaultDatatype()"; // .getClass().getName();
		} else {
			s = "core.New" + dt.getClass().getSimpleName() + "(" + addP + "qnc" + qnameID + ")";
		}

		return s;
	}

	private String getIntegerValue(IntegerValue iv) {
		String s;
		switch (iv.getIntegerValueType()) {
		case INT:
			s = "core.NewIntegerValue32(" + iv.intValue() + ")";
			break;
		case LONG:
			s = "core.NewIntegerValue64(" + iv.longValue() + ")";
			break;
		case BIG:
			s = "core.NewIntegerValueBig(" + iv.bigIntegerValue() + ")";
			break;
		default:
			throw new RuntimeException("Unsupported IntegerType " + iv);
		}

		return s;
	}

	public static void main(String[] args) throws EXIException, IOException {
		String className = "GrammarsForGrammars";
		String xsd = "./src/main/resources/SchemaForGrammars.xsd";

		// String className = "ISO15118_2_2013";
		// String xsd = "..\\V2G_CI_MsgDef.xsd";

		// String xsd =
		// "D:/Projects/EXI/EXIficient/exificient/data/EXIOptionsHeader/EXIOptionsHeader.xsd";

		XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

		grammarBuilder.loadGrammars(xsd);

		SchemaInformedGrammars grammarIn = grammarBuilder.toGrammars();

		Grammars2GoSourceCode grammar2Java = new Grammars2GoSourceCode(
				grammarIn);
		grammar2Java
				.setSchemaId("http://www.ct.siemens.com/exi/2017/SchemaForGrammars");
		grammar2Java.generateCode();

		String sf = grammar2Java.getGrammars(Grammars2GoSourceCode.class
				.getPackage().toString(), className);
		System.out.println(sf);

		if (true) {
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
