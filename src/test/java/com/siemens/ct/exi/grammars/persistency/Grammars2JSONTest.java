package com.siemens.ct.exi.grammars.persistency;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.siemens.ct.exi.core.exceptions.EXIException;
import com.siemens.ct.exi.core.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.grammars.XSDGrammarsBuilder;

public class Grammars2JSONTest extends TestCase {
	
	XSDGrammarsBuilder grammarBuilder = XSDGrammarsBuilder.newInstance();

	public Grammars2JSONTest() throws EXIException {
		super();
	}
	
	protected void _test(String xsd) throws EXIException, IOException {
		grammarBuilder.loadGrammars(xsd);
		SchemaInformedGrammars grammars = grammarBuilder.toGrammars();
		
		Grammars2JSON g2j = new Grammars2JSON();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		g2j.toGrammarsJSON(grammars, baos);
		
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
