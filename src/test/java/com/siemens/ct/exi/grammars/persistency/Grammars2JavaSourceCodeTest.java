package com.siemens.ct.exi.grammars.persistency;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.siemens.ct.exi.exceptions.EXIException;
import com.siemens.ct.exi.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;

public class Grammars2JavaSourceCodeTest extends TestCase {
	
	XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

	public Grammars2JavaSourceCodeTest() throws EXIException {
		super();
	}
	
	protected void _test(String xsd) throws EXIException, IOException {
		grammarBuilder.loadGrammars(xsd);
		SchemaInformedGrammars grammars = grammarBuilder.toGrammars();
		
		Grammars2JavaSourceCode g2j = new Grammars2JavaSourceCode(grammars);
		g2j.generateCode();
		String packageName = Grammars2JavaSourceCode.class.getPackage().toString();
		String className = "Test"+ System.currentTimeMillis();
		
		@SuppressWarnings("unused")
		String sFile = g2j.getGrammars(packageName, className);
		// System.out.println(sFile);
		
		// TODO further validation	
	}

	@Test
	public void testNotebook() throws EXIException, IOException {
		String xsd = "data/W3C/PrimerNotebook/notebook.xsd";
		_test(xsd);
	}
	
	@Test
	public void testEXIForJSON() throws EXIException, IOException {
		String xsd = "data/W3C/EXIforJSON/exi4json.xsd";
		_test(xsd);
	}

}
