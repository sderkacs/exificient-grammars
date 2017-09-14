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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.siemens.ct.exi.datatype.Datatype;
import com.siemens.ct.exi.datatype.DatetimeDatatype;
import com.siemens.ct.exi.datatype.EnumerationDatatype;
import com.siemens.ct.exi.datatype.ListDatatype;
import com.siemens.ct.exi.datatype.NBitUnsignedIntegerDatatype;
import com.siemens.ct.exi.datatype.RestrictedCharacterSetDatatype;
import com.siemens.ct.exi.datatype.charset.RestrictedCharacterSet;
import com.siemens.ct.exi.grammars.event.Attribute;
import com.siemens.ct.exi.grammars.event.AttributeNS;
import com.siemens.ct.exi.grammars.event.Characters;
import com.siemens.ct.exi.grammars.event.Event;
import com.siemens.ct.exi.grammars.event.StartElement;
import com.siemens.ct.exi.grammars.event.StartElementNS;
import com.siemens.ct.exi.grammars.grammar.BuiltInDocContent;
import com.siemens.ct.exi.grammars.grammar.BuiltInFragmentContent;
import com.siemens.ct.exi.grammars.grammar.DocEnd;
import com.siemens.ct.exi.grammars.grammar.Document;
import com.siemens.ct.exi.grammars.grammar.Fragment;
import com.siemens.ct.exi.grammars.grammar.Grammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedElement;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTagGrammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFragmentContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTagGrammar;
import com.siemens.ct.exi.grammars.production.Production;
import com.siemens.ct.exi.types.BuiltInType;
import com.siemens.ct.exi.values.Value;

public class GrammarIdDispenser {

	/**
	 * large maxOccurs values create very large grammars that tend to consume
	 * much computational power. Define the maximum depth. 
	 */
	static final int DEFAULT_RECURSIVE_HANDLED_DEPTH_STOP = 100;
	final int RECURSIVE_HANDLED_DEPTH_STOP;

	final boolean doOptimizeGrammars;
	
	private List<Grammar> grammars;
	
	public GrammarIdDispenser() {
		this(true);
	}
	
	public GrammarIdDispenser(boolean optimizeGrammars) {
		this(optimizeGrammars, DEFAULT_RECURSIVE_HANDLED_DEPTH_STOP);
	}
	
	public GrammarIdDispenser(boolean optimizeGrammars, int depth) {
		doOptimizeGrammars = optimizeGrammars;
		RECURSIVE_HANDLED_DEPTH_STOP = depth;
		grammars = new ArrayList<Grammar>();	
	}
	
	
	public void clear() {
		grammars.clear();
	}
	
	// null ... grammar not found
	// != null ... found equal grammar
	private Grammar getEqualGrammar(Grammar gr) {
		
		for(Grammar gx : this.grammars) {
			if(gr == gx) {
				// System.out.println("Exactly the same grammar found: " + gx);
				return gx;
			}
			
			if ( isSameGrammarType(gr, gx) ) {
				// type of grammar the same
				
				if (gr.getNumberOfEvents() == gx.getNumberOfEvents()) {
					List<Grammar> handled = new ArrayList<Grammar>();
					if( isEqualGrammar(gr, gx, handled) ) {
						// the same grammar found
						// System.out.println("Same grammar found for: " +  gx + " == " + gr);
						return gx;
					}
				}
			}
			
		}
		
		return null;
	}
	
	private static int getGrammarTypeID(Grammar gr) {
		if ( gr instanceof Document) {
			return 0;
		} else if ( gr instanceof SchemaInformedDocContent) {
			return 1;
		} else if ( gr instanceof DocEnd) {
			return 2;
		} else if ( gr instanceof Fragment) {
			return 3;
		} else if ( gr instanceof SchemaInformedFragmentContent) {
			return 4;
		} else if ( gr instanceof SchemaInformedFirstStartTagGrammar) {
			return 5;
		} else if ( gr instanceof SchemaInformedStartTagGrammar) {
			return 6;
		} else if ( gr instanceof SchemaInformedElement) {
			return 7;
		///////////////
		} else if ( gr instanceof BuiltInDocContent) {
			return 8;
		} else if ( gr instanceof BuiltInFragmentContent) {
			return 9;
		} else {
			throw new RuntimeException("Unexpected Grammar Type for: " + gr);
		}	
	}

	

	
	private static boolean isSameGrammarType(Grammar gr, Grammar gx) {
		int grTID = getGrammarTypeID(gr);
		int gxTID = getGrammarTypeID(gx);
		
		if (grTID != gxTID) {
			return false;
		}
		
		if ( gr instanceof SchemaInformedFirstStartTagGrammar) {
			SchemaInformedFirstStartTagGrammar fr = (SchemaInformedFirstStartTagGrammar) gr;
			SchemaInformedFirstStartTagGrammar fx = (SchemaInformedFirstStartTagGrammar) gx;
			if(fr.isTypeCastable() != fx.isTypeCastable() ) {
				return false;
			}
			if(fr.isNillable() != fx.isNillable() ) {
				return false;
			}
		}
		
		return true;
	}
	
	
	private boolean isEqualGrammar(Grammar gr, Grammar gx, List<Grammar> handled) {
		if( gr == gx) {
			return true;
		}
		
		// handled already ?
		for(Grammar g : handled) {
			if(g == gx) {
				// return true;
				for(Grammar gg : handled) {
					if(gg == gr) {
						return true;
					}
				}
			}
		}
		handled.add(gx);
		handled.add(gr);
		
		if(handled.size() > RECURSIVE_HANDLED_DEPTH_STOP) {
			// System.out.println(handled.size());	
			return false;
		}
		
		
		if ( ! isSameGrammarType(gr, gx) ) {
			return false;
		}
		
		if (gr.getNumberOfEvents() != gx.getNumberOfEvents()) {
			return false;
		}
		
		for(int i=0; i<gr.getNumberOfEvents(); i++) {
			Production pr = gr.getProduction(i);
			Production px = gx.getProduction(i);
			
			// event
			Event er = pr.getEvent();
			Event ex = px.getEvent();
			
			if(er.getEventType() != ex.getEventType()) {
				return false;
			}
			
			switch(er.getEventType()) {
			case START_DOCUMENT:
			case END_DOCUMENT:
			case ATTRIBUTE_GENERIC:
			case START_ELEMENT_GENERIC:
			case END_ELEMENT:
			case CHARACTERS_GENERIC:
				break;
			case ATTRIBUTE:
				Attribute ar = (Attribute) er;
				Attribute ax = (Attribute) ex;
				if ( ! ar.getQName().equals(ax.getQName())) {
					return false;
				}
				if ( ! isEqualDatatype(ar.getDatatype(), ax.getDatatype()) ) {
					return false;
				}
				break;
			case ATTRIBUTE_NS:
				AttributeNS ansr = (AttributeNS) er;
				AttributeNS ansx = (AttributeNS) ex;
				if ( ! ansr.getNamespaceURI().equals(ansx.getNamespaceURI())) {
					return false;
				}
				break;
			case START_ELEMENT:
				StartElement ser = (StartElement) er;
				StartElement sex = (StartElement) ex;
				
				if ( ! ser.getQName().equals(sex.getQName())) {
					return false;
				}
				
				if( ! isEqualGrammar(ser.getGrammar(), sex.getGrammar(), handled )  ) {
				// if( ! isEqualGrammar(ser.getGrammar(), sex.getGrammar(), new ArrayList<Grammar>() )  ) {
					return false;
				}
				
				break;
			case START_ELEMENT_NS:
				StartElementNS sensr = (StartElementNS) er;
				StartElementNS sensx = (StartElementNS) ex;
				if ( ! sensr.getNamespaceURI().equals(sensx.getNamespaceURI())) {
					return false;
				}
				break;
			case CHARACTERS:
				Characters chr = (Characters) er;
				Characters chx = (Characters) ex;
				if ( ! isEqualDatatype(chr.getDatatype(), chx.getDatatype()) ) {
					return false;
				}
				break;
			default:
				throw new RuntimeException("Unexpected Grammar Event Type for: " + er);
			}
			
				
			// next grammar
			Grammar nr = pr.getNextGrammar();
			Grammar nx = px.getNextGrammar();
			
			if( ! isEqualGrammar(nr, nx, handled )  ) {
			// if( ! isEqualGrammar(nr, nx, new ArrayList<Grammar>()  )  ) {
				return false;
			}
		}
		
		
		return true;
	}
	
	

	private static boolean isEqualDatatype(Datatype dt1, Datatype dt2) {
		BuiltInType bit1 = dt1.getBuiltInType();
		BuiltInType bit2 = dt2.getBuiltInType();
		
		if(bit1 != bit2) {
			return false;
		}
		
		
		switch(bit1) {
		case BINARY_BASE64:
		case BINARY_HEX:
		case BOOLEAN:
		case BOOLEAN_FACET:
		case DECIMAL:
		case FLOAT:
		case UNSIGNED_INTEGER:
		case INTEGER:
		case STRING:
			/* the same --> OK */
			break;
		case NBIT_UNSIGNED_INTEGER:
			NBitUnsignedIntegerDatatype nbit1 = (NBitUnsignedIntegerDatatype) dt1;
			NBitUnsignedIntegerDatatype nbit2 = (NBitUnsignedIntegerDatatype) dt2;
			if ( nbit1.getNumberOfBits() != nbit2.getNumberOfBits() ) {
				return false;
			}
			if ( !nbit1.getLowerBound().equals(nbit2.getLowerBound()) ) {
				return false;
			}
			if ( !nbit1.getUpperBound().equals(nbit2.getUpperBound()) ) {
				return false;
			}
			break;
		case DATETIME:
			DatetimeDatatype d1 =  (DatetimeDatatype) dt1;
			DatetimeDatatype d2 =  (DatetimeDatatype) dt2;
			if ( d1.getDatetimeType() != d2.getDatetimeType() ) {
				return false;
			}
			break;
		case RCS_STRING:
			RestrictedCharacterSetDatatype r1 =   (RestrictedCharacterSetDatatype) dt1;
			RestrictedCharacterSetDatatype r2 =   (RestrictedCharacterSetDatatype) dt2;
			RestrictedCharacterSet rcs1 = r1.getRestrictedCharacterSet();
			RestrictedCharacterSet rcs2 = r2.getRestrictedCharacterSet();
			if(rcs1.size() != rcs2.size()) {
				return false;
			}
			for(int i=0; i<rcs1.size(); i++) {
				if( rcs1.getCodePoint(i) != rcs2.getCodePoint(i) ) {
					return false;
				}
			}
			break;
		case ENUMERATION:
			EnumerationDatatype e1 =  (EnumerationDatatype) dt1;
			EnumerationDatatype e2 =  (EnumerationDatatype) dt2;
			if ( e1.getEnumerationSize() != e2.getEnumerationSize() ) {
				return false;
			}
			if ( e1.getEnumValueDatatype().getBuiltInType() != e2.getEnumValueDatatype().getBuiltInType() ) {
				return false;
			}
			for(int i=0; i<e1.getEnumerationSize(); i++) {
				Value v1 = e1.getEnumValue(i);
				Value v2 = e2.getEnumValue(i);
				if( !v1.equals(v2) ) {
					return false;
				}
			}
			break;
		case LIST:
			ListDatatype l1 =  (ListDatatype) dt1;
			ListDatatype l2 =  (ListDatatype) dt2;
			
			if( ! isEqualDatatype(l1.getListDatatype(), l2.getListDatatype()) ) {
				return false;
			}
			break;
		default:
			return false;
		}
		
		
		return true;
	}


	public boolean isGrammarHandled(Grammar gr) {
		boolean handled = false;
		if (doOptimizeGrammars) {
			// System.out.println("getEqualGrammar for " + gr);
			Grammar gx = getEqualGrammar(gr);
			if(gx == null) {
				handled = false;
			} else {
				handled = true;
			}
			
		} else {
			Iterator<Grammar> giter =  this.getGrammarIterator();
			while(handled == false && giter.hasNext() ) {
				Grammar g = giter.next();
				if(g == gr) {
					// abort
					handled = true;
				}
			}
		}
		
		return handled;
	}
	

	
	public void addHandledGrammar(Grammar gr) {
//		if(grammars.contains(gr)) {
//			System.err.println("Duplicate entry");
//		}
//		assert(!grammars.contains(gr));
		this.grammars.add(gr);
	}

	
	public Iterator<Grammar> getGrammarIterator() {
		return this.grammars.iterator();
	}
	
	private int getKnownGrammarID(Grammar r) {
		for(int i=0; i<grammars.size(); i++) {
			if ( grammars.get(i) == r  ) {
				return i;
			}
		}
		return -1;
	}
	
	public Grammar getGrammar(int gid) {
		if(this.grammars != null && this.grammars.size() > gid && gid >= 0) {
			return this.grammars.get(gid);
		} else {
			throw new RuntimeException("Unexpected grammarID");
		}
	}
	
	
	public int getGrammarIDProof(Grammar g) {
		if (!isGrammarHandled(g)) {
			this.addHandledGrammar(g);
		}
		
		return getGrammarID(g);
	}
	
	public int getGrammarID(Grammar r) {
		int id;
		
		//System.out.println("getGrammarID " + r);
		
		if (doOptimizeGrammars) {
			id = getKnownGrammarID(r);
			if(id != -1) {
				return id;
			}
			// IF not found pointer equality, retrieve "equal" grammar
			Grammar gx = getEqualGrammar(r);
			if(gx == null) {
				throw new RuntimeException("no valid grammar ID found for :" + r + ". MUST be handled before!!");
			} else {
				id = getGrammarID(gx);
			}
		} else {
			if (!isGrammarHandled(r)) {
				this.addHandledGrammar(r);
			}
			
			id = getKnownGrammarID(r);
		}


		return id;
	}
	
	
	
}
