package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) {
		KnowledgeBase base = new KnowledgeBase();
		base.parseDB("rules.db");
		System.out.println("I shall answer all your questions!");
    }
}
