package com.siemens.ct.exi.grammars.persistency;

/*
 * Copyright (c) 2007-2016 Siemens AG
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

	static final String NUMBER_OF_URIS = "numberOfUris";
	static final String NUMBER_OF_QNAMES = "numberOfQNames";
	static final String NUMBER_OF_LOCAL_NAMES = "numberOfLocalNames";
	static final String NUMBER_OF_FIRST_START_TAG_GRAMMARS = "numberOfFirstStartTagGrammars";
	static final String NUMBER_OF_START_TAG_GRAMMARS = "numberOfStartTagGrammars";
	static final String NUMBER_OF_ELEMENT_GRAMMARS = "numberOfElementGrammars";	
	
	static final String FIRST_START_TAG_CONTENT = "firstStartTagContent";
	static final String START_TAG_CONTENT = "startTagContent";
	static final String ELEMENT_CONTENT = "elementContent";
	static final String DOCUMENT = "document";
	static final String DOCUMENT_GRAMMAR_ID = "documentGrammarID";
	static final String DOC_CONTENT = "docContent";
	static final String DOC_END = "docEnd";
	static final String FRAGMENT = "fragment";
	static final String FRAGMENT_GRAMMAR_ID = "fragmentGrammarID";
	
	static final String FRAGMENT_CONTENT = "fragmentContent";
	
	static final String PRODUCTION = "production";

	static final String TYPE = "type";
	static final String VALUE_TYPE = "valueType";
	static final String GLOBAL_ATTRIBUTE_TYPE_QNAME_ID = "globalAttributeTypeQNameID";
	static final String GLOBAL_ATTRIBUTE_SCHEMA_TYPE_QNAME_ID = "globalAttributeSchemaTypeQNameID";
	static final String ATTRIBUTE_SCHEMA_TYPE_QNAME_ID = "attributeSchemaTypeQNameID";
	static final String ATTRIBUTE_TYPE_QNAME_ID = "attributeTypeQNameID";
	static final String CHARACTERS_TYPE_QNAME_ID = "charactersTypeQNameID";
	static final String CHARACTERS_SCHEMA_TYPE_QNAME_ID = "charactersSchemaTypeQNameID";
	static final String VALUE_TYPE_QNAME_ID = "valueTypeQNameID";
	static final String PREFIX = "prefix";
	static final String NAMESPACE_URI = "namespaceUri";
	static final String LOCAL_NAME = "localName";
	static final String LOCAL_NAME_ID = "localNameID";
	
	
	static final String START_ELEMENT_QNAME_ID = "startElementQNameID";
	static final String START_ELEMENT_NAMESPACE_ID = "startElementNamespaceID";
	static final String START_ELEMENT_LOCALNAME_ID = "startElementLocalNameID";
	static final String GLOBAL_TYPE_GRAMMAR_ID = "globalTypeGrammarID";
	static final String GLOBAL_ELEMENT_GRAMMAR_ID = "globalElementGrammarID";

	static final String GLOBAL_ATTRIBUTE_DATATYPE = "globalAttributeDatatype";
	static final String GLOBAL_ATTRIBUTE_DATATYPE_ID = "globalAttributeDatatypeID";
	static final String ATTRIBUTE_DATATYPE_ID = "attributeDatatypeID";
	static final String CHARACTERS_DATATYPE_ID = "charactersDatatypeID";
	static final String ATTRIBUTE_QNAME_ID = "attributeQNameID";
	static final String ATTRIBUTE_NAMESPACE_ID = "attributeNamespaceID";
	static final String ATTRIBUTE_LOCALNAME_ID = "attributeLocalNameID";
	static final String SIMPLE_DATATYPE = "simpleDatatype";
	static final String SIMPLE_DATATYPE_ID = "simpleDatatypeID";
	static final String SIMPLE_DATATYPES = "simpleDatatypes";
	static final String SIMPLE_SUB_TYPE_QNAME_IDS = "simpleSubTypeQNameIDs";

	static final String START_DOCUMENT = "startDocument";
	static final String END_DOCUMENT = "endDocument";
	static final String START_ELEMENT = "startElement";
	static final String END_ELEMENT = "endElement";
	static final String ATTRIBUTE = "attribute";
	static final String ATTRIBUTE_NAME = "attributeName";
	static final String CHARACTERS = "characters";
	static final String START_ELEMENT_NS = "startElementNS";
	static final String START_ELEMENT_GENERIC = "startElementGeneric";
	static final String CHARACTERS_GENERIC = "charactersGeneric";
	static final String ATTRIBUTE_NS = "attributeNS";
	static final String ATTRIBUTE_GENERIC = "attributeGeneric";
	
	static final String ATTRIBUTE_DATATYPE = "attributeDatatype";
	static final String CHARACTERS_DATATYPE = "charactersDatatype";
	
	static final String DATATYPE_BUILTIN_TYPE = "datatypeBuiltInType";
	static final String DATATYPE_BOOLEAN = "datatypeBoolean";
	static final String DATATYPE_BOOLEAN_FACET = "facet";
	static final String DATATYPE_LIST = "datatypeList";
	static final String DATATYPE_NBIT_UNSIGNED_INTEGER = "datatypeNBitUnsignedInteger";
	static final String DATATYPE_DATETIME = "datatypeDateTime";
	static final String DATATYPE_RCS = "datatypeRestrictedCharSet";
	static final String DATATYPE_ENUMERATION = "datatypeEnumeration";
	static final String DATATYPE_ENUM_VALUES = "enumValues";
	static final String DATATYPE_ENUM_VALUES_BUILTIN_TYPE = "enumValuesBuiltInType";

	static final String LOWER_BOUND = "lowerBound";
	static final String UPPER_BOUND = "upperBound";

	static final String NEXT_GRAMMAR_ID = "nextGrammarID";
	static final String START_ELEMENT_GRAMMAR_ID = "startElementGrammarID";

	static final String IS_NILLABLE = "isNillable";
	static final String IS_TYPE_CASTABLE = "isTypeCastable";

	static final String EVENT = "event";
	
	static final String GRAMMARS = "grammars";
	static final String GRAMMAR = "grammar";
	static final String GRAMMAR_ID = "grammarID";
	static final String QNAMES = "qnames";
	static final String NAMESPACE_CONTEXT = "namespaceContext";
	static final String QNAME_CONTEXT = "qnameContext";
	static final String QNAME_ID = "qnameID";
	static final String URI = "uri";
	static final String URI_ID = "uriID";
}
