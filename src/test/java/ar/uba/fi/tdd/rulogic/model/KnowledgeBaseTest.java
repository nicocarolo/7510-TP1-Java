package ar.uba.fi.tdd.rulogic.model;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBaseTest {

	@InjectMocks
	private KnowledgeBase knowledgeBase;

/*	rules.db
		varon(juan).
		varon(pepe).
		varon(hector).
		varon(roberto).
		varon(alejandro).
		mujer(maria) .
		mujer(cecilia).
		padre(juan, pepe).
		padre(juan, pepa).
		padre(hector, maria).
		padre(roberto, alejandro).
		padre(roberto, cecilia).
		hijo(X, Y) :- varon(X), padre(Y, X).
		hija(X, Y) :- mujer(X), padre(Y, X).
		hermano(nicolas, roberto).
		hermano(roberto, nicolas).
		varon ( nicolas ) .
		tio(X, Y, Z):- varon(X),	hermano(X, Z),padre(Z, Y).
		tia(X, Y, Z):- mujer(X),	hermano(X, Z),padre(Z, Y).
		*/
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		this.knowledgeBase.parseDB("rules.db");
	}

	@Test
	public void testBaseAnswerFact() {
		Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
		Assert.assertFalse(this.knowledgeBase.answer("varon (juan)."));

		Assert.assertFalse(this.knowledgeBase.answer("varon(maria)."));

		Assert.assertTrue(this.knowledgeBase.answer("varon(juan)."));
		Assert.assertTrue(this.knowledgeBase.answer("mujer(cecilia)."));
		Assert.assertTrue(this.knowledgeBase.answer("padre(juan, pepe)."));

	}

	@Test
	public void testBaseAnswerRule() {
		Assert.assertFalse(this.knowledgeBase.answer("hijo (javier)."));
		Assert.assertFalse(this.knowledgeBase.answer("hija (juan)."));
		Assert.assertFalse(this.knowledgeBase.answer("hijo (juan,pepe)."));
//
		Assert.assertFalse(this.knowledgeBase.answer("hija(juan, pepe)."));

		Assert.assertTrue(this.knowledgeBase.answer("hijo(pepe, juan)."));
		Assert.assertTrue(this.knowledgeBase.answer("hija(cecilia, roberto)."));

	}

	@Test
	public void testBaseShouldLoadDatabase() {
//		varon(juan).
//		varon(pepe).
//		varon(hector).
//		varon(roberto).
//		varon(alejandro).
//		mujer(cecilia).
//		padre(juan, pepe).
//		padre(juan, pepa).
//		padre(hector, maria).
//		padre(roberto, alejandro).
//		padre(roberto, cecilia).
//		hermano(nicolas, roberto).
//		hermano(roberto, nicolas).
		Assert.assertTrue(this.knowledgeBase.getDbFacts().size() == 13);

//		hijo(X, Y) :- varon(X), padre(Y, X).
//		hija(X, Y) :- mujer(X), padre(Y, X).
		Assert.assertTrue(this.knowledgeBase.getDbRules().size() == 2);
	}

	@Test
	public void testBaseShouldKnowIfIsFact() {
		String[] trueFactParams = {"juan"};
		Fact trueFact = new Fact("varon", trueFactParams);

		String[] falseFactParams = {"miguel"};
		Fact falseFact = new Fact("varon", falseFactParams);

		Assert.assertTrue(this.knowledgeBase.isFact(trueFact));
		Assert.assertFalse(this.knowledgeBase.isFact(falseFact));

	}

	@Test
	public void testBaseShouldKnowIfIsRule() {
		String[] falseFactParams = {"juan"};
		Fact falseFact = new Fact("varon", falseFactParams);

		String[] trueFactParams = {"miguel"};
		Fact trueFact = new Fact("hijo", trueFactParams);

		Assert.assertTrue(this.knowledgeBase.isRule(trueFact));
		Assert.assertFalse(this.knowledgeBase.isRule(falseFact));

	}

}
