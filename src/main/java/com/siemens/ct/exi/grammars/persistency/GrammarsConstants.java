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

public class GrammarsConstants {

//	static final String NUMBER_OF_URIS = "numberOfUris";
//	static final String NUMBER_OF_QNAMES = "numberOfQNames";
//	static final String NUMBER_OF_LOCAL_NAMES = "numberOfLocalNames";
	public static final String NUMBER_OF_FIRST_START_TAG_GRAMMARS = "numberOfFirstStartTagGrammars";
	public static final String NUMBER_OF_START_TAG_GRAMMARS = "numberOfStartTagGrammars";
	public static final String NUMBER_OF_ELEMENT_GRAMMARS = "numberOfElementGrammars";	
	
	public static final String FIRST_START_TAG_CONTENT = "firstStartTagContent";
	public static final String START_TAG_CONTENT = "startTagContent";
	public static final String ELEMENT_CONTENT = "elementContent";
	public static final String DOCUMENT = "document";
	public static final String DOCUMENT_GRAMMAR_ID = "documentGrammarID";
	public static final String DOC_CONTENT = "docContent";
	public static final String DOC_END = "docEnd";
	public static final String FRAGMENT = "fragment";
	public static final String FRAGMENT_GRAMMAR_ID = "fragmentGrammarID";
	
	public static final String FRAGMENT_CONTENT = "fragmentContent";
	
	public static final String PRODUCTION = "production";

	public static final String TYPE = "type";
	public static final String VALUE_TYPE = "valueType";
	public static final String GLOBAL_ATTRIBUTE_TYPE_QNAME_ID = "globalAttributeTypeQNameID";
	public static final String GLOBAL_ATTRIBUTE_SCHEMA_TYPE_QNAME_ID = "globalAttributeSchemaTypeQNameID";
	public static final String ATTRIBUTE_SCHEMA_TYPE_QNAME_ID = "attributeSchemaTypeQNameID";
	public static final String ATTRIBUTE_TYPE_QNAME_ID = "attributeTypeQNameID";
	public static final String CHARACTERS_TYPE_QNAME_ID = "charactersTypeQNameID";
	public static final String CHARACTERS_SCHEMA_TYPE_QNAME_ID = "charactersSchemaTypeQNameID";
	public static final String VALUE_TYPE_QNAME_ID = "valueTypeQNameID";
	public static final String PREFIX = "prefix";
	public static final String NAMESPACE_URI = "namespaceUri";
	public static final String LOCAL_NAME = "localName";
	public static final String LOCAL_NAME_ID = "localNameID";
	
	
	public static final String START_ELEMENT_QNAME_ID = "startElementQNameID";
	public static final String START_ELEMENT_NAMESPACE_ID = "startElementNamespaceID";
	public static final String START_ELEMENT_LOCALNAME_ID = "startElementLocalNameID";
	public static final String GLOBAL_TYPE_GRAMMAR_ID = "globalTypeGrammarID";
	public static final String GLOBAL_ELEMENT_GRAMMAR_ID = "globalElementGrammarID";

	public static final String GLOBAL_ATTRIBUTE_DATATYPE = "globalAttributeDatatype";
	public static final String GLOBAL_ATTRIBUTE_DATATYPE_ID = "globalAttributeDatatypeID";
	public static final String ATTRIBUTE_DATATYPE_ID = "attributeDatatypeID";
	public static final String CHARACTERS_DATATYPE_ID = "charactersDatatypeID";
	public static final String ATTRIBUTE_QNAME_ID = "attributeQNameID";
	public static final String ATTRIBUTE_NAMESPACE_ID = "attributeNamespaceID";
	public static final String ATTRIBUTE_LOCALNAME_ID = "attributeLocalNameID";
	public static final String SIMPLE_DATATYPE = "simpleDatatype";
	public static final String SIMPLE_DATATYPE_ID = "simpleDatatypeID";
	public static final String SIMPLE_DATATYPES = "simpleDatatypes";
	public static final String SIMPLE_SUB_TYPE_QNAME_IDS = "simpleSubTypeQNameIDs";

	public static final String START_DOCUMENT = "startDocument";
	public static final String END_DOCUMENT = "endDocument";
	public static final String START_ELEMENT = "startElement";
	public static final String END_ELEMENT = "endElement";
	public static final String ATTRIBUTE = "attribute";
	public static final String ATTRIBUTE_NAME = "attributeName";
	public final String CHARACTERS = "characters";
	public static final String START_ELEMENT_NS = "startElementNS";
	public static final String START_ELEMENT_GENERIC = "startElementGeneric";
	public static final String CHARACTERS_GENERIC = "charactersGeneric";
	public static final String ATTRIBUTE_NS = "attributeNS";
	public static final String ATTRIBUTE_GENERIC = "attributeGeneric";
	
	public static final String ATTRIBUTE_DATATYPE = "attributeDatatype";
	public static final String CHARACTERS_DATATYPE = "charactersDatatype";
	
	public static final String DATATYPE_BUILTIN_TYPE = "datatypeBuiltInType";
	public static final String DATATYPE_BOOLEAN = "datatypeBoolean";
	public static final String DATATYPE_BOOLEAN_FACET = "facet";
	public static final String DATATYPE_LIST = "datatypeList";
	public static final String DATATYPE_NBIT_UNSIGNED_INTEGER = "datatypeNBitUnsignedInteger";
	public static final String DATATYPE_DATETIME = "datatypeDateTime";
	public static final String DATATYPE_RCS = "datatypeRestrictedCharSet";
	public static final String DATATYPE_ENUMERATION = "datatypeEnumeration";
	public static final String DATATYPE_ENUM_VALUES = "enumValues";
	public static final String DATATYPE_ENUM_VALUES_BUILTIN_TYPE = "enumValuesBuiltInType";

	public static final String LOWER_BOUND = "lowerBound";
	public static final String UPPER_BOUND = "upperBound";

	public static final String NEXT_GRAMMAR_ID = "nextGrammarID";
	public static final String START_ELEMENT_GRAMMAR_ID = "startElementGrammarID";

	public static final String IS_NILLABLE = "isNillable";
	public static final String IS_TYPE_CASTABLE = "isTypeCastable";

	public static final String EVENT = "event";
	
	public static final String GRAMMARS = "grammars";
	public static final String GRAMMAR = "grammar";
	public static final String GRAMMAR_ID = "grammarID";
	public static final String QNAMES = "qnames";
	public static final String NAMESPACE_CONTEXT = "namespaceContext";
	public static final String QNAME_CONTEXT = "qnameContext";
	public static final String QNAME_ID = "qnameID";
	public static final String URI = "uri";
	public static final String URI_ID = "uriID";
}
