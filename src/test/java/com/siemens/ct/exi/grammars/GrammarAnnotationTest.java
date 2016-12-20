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

package com.siemens.ct.exi.grammars;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

import com.siemens.ct.exi.GrammarFactory;
import com.siemens.ct.exi.context.QNameContext;
import com.siemens.ct.exi.datatype.Datatype;
import com.siemens.ct.exi.datatype.EnumDatatype;
import com.siemens.ct.exi.datatype.EnumerationDatatype;
import com.siemens.ct.exi.grammars.event.Characters;
import com.siemens.ct.exi.grammars.event.Event;
import com.siemens.ct.exi.grammars.event.EventType;
import com.siemens.ct.exi.types.BuiltInType;

public class GrammarAnnotationTest extends TestCase {
	
	static GrammarFactory grammarFactory = GrammarFactory.newInstance();
	
	String schema;

	public static Grammars getGrammarFromSchemaAsString(String schemaAsString)
			throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(
				schemaAsString.getBytes());
		
		Grammars grammar = grammarFactory.createGrammars(bais);

		return grammar;
	}

	public void test1() throws Exception {
		String schema = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
				"    <xs:element name=\"root\">\r\n" + 
				"        <xs:simpleType>\r\n" + 
				"            <xs:annotation exi:prepopulateValues=\"true\" xmlns:exi=\"http://www.w3.org/2009/exi\">\r\n" + 
				"                <xs:appinfo>\r\n" + 
				"                    <xs:restriction base=\"xs:string\">\r\n" + 
				"                        <xs:enumeration value=\"A\"/>\r\n" + 
				"                        <xs:enumeration value=\"B\"/>\r\n" + 
				"                        <xs:enumeration value=\"C\"/>\r\n" + 
				"                    </xs:restriction>\r\n" + 
				"                </xs:appinfo>\r\n" + 
				"            </xs:annotation>\r\n" + 
				"            <xs:restriction base=\"xs:string\"/>\r\n" + 
				"        </xs:simpleType>\r\n" + 
				"    </xs:element>\r\n" + 
				"</xs:schema>";
		
		Grammars grs = grammarFactory.createGrammars(new ByteArrayInputStream(schema.getBytes())); // StandardCharsets.UTF_8 not Java5/6
		QNameContext qncRoot = grs.getGrammarContext().getGrammarUriContext("").getQNameContext("root");
		
		Event ev = qncRoot.getGlobalStartElement().getGrammar().getProduction(0).getEvent();
		assertTrue(ev.getEventType() == EventType.CHARACTERS);
		Characters cev = (Characters) ev;
		Datatype dt = cev.getDatatype();
		assertTrue(dt.getBuiltInType() == BuiltInType.STRING);
		
		EnumDatatype enumDT = dt.getGrammarEnumeration();
		// TODO enhance EnumDatatype
		EnumerationDatatype edt = (EnumerationDatatype) enumDT;
		assertTrue(edt.getEnumerationSize() == 3);
		assertTrue(edt.getEnumValue(0).toString().equals("A"));
		assertTrue(edt.getEnumValue(0).toString().equals("A"));
		assertTrue(edt.getEnumValue(0).toString().equals("A"));
	}
	
	public void testNoPrep1() throws Exception {
		// missing attribute exi:prepopulateValues="true"
		String schema = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n" + 
				"    <xs:element name=\"root\">\r\n" + 
				"        <xs:simpleType>\r\n" + 
				"            <xs:annotation  xmlns:exi=\"http://www.w3.org/2009/exi\">\r\n" + 
				"                <xs:appinfo>\r\n" + 
				"                    <xs:restriction base=\"xs:string\">\r\n" + 
				"                        <xs:enumeration value=\"A\"/>\r\n" + 
				"                        <xs:enumeration value=\"B\"/>\r\n" + 
				"                        <xs:enumeration value=\"C\"/>\r\n" + 
				"                    </xs:restriction>\r\n" + 
				"                </xs:appinfo>\r\n" + 
				"            </xs:annotation>\r\n" + 
				"            <xs:restriction base=\"xs:string\"/>\r\n" + 
				"        </xs:simpleType>\r\n" + 
				"    </xs:element>\r\n" + 
				"</xs:schema>";
		
		Grammars grs = grammarFactory.createGrammars(new ByteArrayInputStream(schema.getBytes())); // StandardCharsets.UTF_8 not Java5/6
		QNameContext qncRoot = grs.getGrammarContext().getGrammarUriContext("").getQNameContext("root");
		
		Event ev = qncRoot.getGlobalStartElement().getGrammar().getProduction(0).getEvent();
		assertTrue(ev.getEventType() == EventType.CHARACTERS);
		Characters cev = (Characters) ev;
		Datatype dt = cev.getDatatype();
		assertTrue(dt.getBuiltInType() == BuiltInType.STRING);
		
		EnumDatatype enumDT = dt.getGrammarEnumeration();
		assertTrue(enumDT == null); // attribute exi:prepopulateValues="true"
	}

	
}
