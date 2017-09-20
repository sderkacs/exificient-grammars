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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.siemens.ct.exi.grammars.persistency.GrammarIdDispenser;
import com.siemens.ct.exi.context.GrammarContext;
import com.siemens.ct.exi.context.GrammarUriContext;
import com.siemens.ct.exi.context.QNameContext;
import com.siemens.ct.exi.grammars.Grammars;
import com.siemens.ct.exi.grammars.SchemaInformedGrammars;
import com.siemens.ct.exi.grammars.event.StartElement;
import com.siemens.ct.exi.grammars.grammar.DocEnd;
import com.siemens.ct.exi.grammars.grammar.Document;
import com.siemens.ct.exi.grammars.grammar.Fragment;
import com.siemens.ct.exi.grammars.grammar.Grammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedDocContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedElement;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTag;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFirstStartTagGrammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedFragmentContent;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedGrammar;
import com.siemens.ct.exi.grammars.grammar.SchemaInformedStartTag;
import com.siemens.ct.exi.grammars.production.Production;

public class GrammarsPreperation {
	
	protected GrammarIdDispenser grsIdDispenser;
	
	protected List<Grammar> sortedGrammars;


	protected int numberOfFirstStartTagGrammars;
	protected int numberOfStartTagGrammars;
	protected int numberOfElementGrammars;
	
	public GrammarsPreperation() {
		grsIdDispenser = new GrammarIdDispenser();
		sortedGrammars = new ArrayList<Grammar>();
	}
	
	public void clear() {
		grsIdDispenser.clear();
		sortedGrammars.clear();
		
		numberOfFirstStartTagGrammars = 0;
		numberOfStartTagGrammars = 0;
		numberOfElementGrammars = 0;
	}
	
	
	public void prepareGrammars(Grammars grammar) throws IOException {
		this.clear();
		
		// document
		Grammar doc = grammar.getDocumentGrammar();
		prepareGrammar(doc);
		
		// fragment
		Grammar frag = grammar.getFragmentGrammar();
		prepareGrammar(frag);
		
		// element fragment grammar
		if(grammar instanceof SchemaInformedGrammars) {
			SchemaInformedGrammar elFragGr = ((SchemaInformedGrammars)grammar).getSchemaInformedElementFragmentGrammar();
			prepareGrammar(elFragGr);
		}

		// global type grammars
		GrammarContext gc = grammar.getGrammarContext();
		for (int uriId = 0; uriId < gc.getNumberOfGrammarUriContexts(); uriId++) {
			GrammarUriContext guc = gc.getGrammarUriContext(uriId);
			for (int qnId = 0; qnId < guc.getNumberOfQNames(); qnId++) {
				QNameContext qnc = guc.getQNameContext(qnId);
				SchemaInformedFirstStartTagGrammar typeGrammar = qnc
						.getTypeGrammar();
				if (typeGrammar != null) {
					this.prepareGrammar(typeGrammar);
				}
			}
		}
		
		sortedGrammars.clear();
		
		// walk over all handled rules to create sorted rule IDs
		for(int k=0; k<8; k++ ) {
			// Note: k defines grammar order: 1.Document to 7.ElementContent grammar
			Iterator<Grammar> iterGrs = this.grsIdDispenser.getGrammarIterator();
			while(iterGrs.hasNext()) {
				Grammar r = iterGrs.next();
				switch(k) {
				case 0:
					/* Document */
					if (r instanceof Document) {
						sortedGrammars.add(r);
					}
					break;
				case 1:
					/* DocContent */
					if (r instanceof SchemaInformedDocContent) {
						sortedGrammars.add(r);
					}
					break;
				case 2:
					/* DocEnd */
					if (r instanceof DocEnd) {
						sortedGrammars.add(r);
					}
					break;
				case 3:
					/* Fragment */
					if (r instanceof Fragment) {
						sortedGrammars.add(r);
					}
					break;
				case 4:
					/* FragmentContent */
					if (r instanceof SchemaInformedFragmentContent) {
						sortedGrammars.add(r);
					}
					break;
				case 5:
					/* FirstStartTagContent */
					if (r instanceof SchemaInformedFirstStartTag) {
						numberOfFirstStartTagGrammars++;
						sortedGrammars.add(r);
					}
					break;
				case 6:
					/* StartTagContent */
					if (r instanceof SchemaInformedStartTag) {
						if(!(r instanceof SchemaInformedFirstStartTag)) {
							numberOfStartTagGrammars++;	
							sortedGrammars.add(r);
						}
					}
					break;
				case 7:
					/* ElementContent */
					if (r instanceof SchemaInformedElement) {
						numberOfElementGrammars++;
						sortedGrammars.add(r);
					}
					break;
				}
				
			}			
		}
		
		System.out.println("Sorted Grammars: " + sortedGrammars);

	}
	
	
	void prepareGrammar(Grammar r) throws IOException {
		if (this.grsIdDispenser.isGrammarHandled(r)) {
			// abort, already processed
			return;
		}
		this.grsIdDispenser.addHandledGrammar(r);

		int numberOfEvents = r.getNumberOfEvents();

		/*
		 * Other Events (encode and decode)
		 */
		for (int eventCode = 0; eventCode < numberOfEvents; eventCode++) {
			Production ei = r.getProduction(eventCode);

			switch (ei.getEvent().getEventType()) {
			case START_ELEMENT:
				StartElement se = (StartElement) ei.getEvent();

				/*
				 * another element to deal with?
				 */
				if (!this.grsIdDispenser.isGrammarHandled(se.getGrammar())) {
					this.prepareGrammar(se.getGrammar());
				}
				break;
			default:
				// no further event to prepare
			}

			prepareGrammar(ei.getNextGrammar());
		}

		// prepare element content rule?
		prepareGrammar(r.getElementContentGrammar());
		
	}

	// note: returns "sorted" id
	public int getGrammarID(Grammar r) {
		// get ID of "equal" grammar (may be also pointer equal)
		int id1 = this.grsIdDispenser.getGrammarID(r);
		Grammar g1 = this.grsIdDispenser.getGrammar(id1);
		
		for(int i=0; i<this.sortedGrammars.size(); i++) {
			Grammar g = this.sortedGrammars.get(i);
			if (g1 == g) {
				return i;
			}
		}
		
		throw new RuntimeException("No grammar id found for: " + r);
	}
	
	public Grammar getGrammar(int id) {
		return this.sortedGrammars.get(id);
	}
	
	public int getNumberOfGrammars() {
		return this.sortedGrammars.size();
	}
	
	public int getNumberOfFirstStartTagGrammars() {
		return numberOfFirstStartTagGrammars;
	}


	public int getNumberOfStartTagGrammars() {
		return numberOfStartTagGrammars;
	}


	public int getNumberOfElementGrammars() {
		return numberOfElementGrammars;
	}
	
}
