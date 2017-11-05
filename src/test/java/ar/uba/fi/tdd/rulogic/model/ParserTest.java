package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class ParserTest {

    @InjectMocks
    private Parser parser;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testParseShouldDetectWhenEntryIsFact() {

        Assert.assertTrue(parser.validFact("varon(tito)."));
        Assert.assertTrue(parser.validFact("varon(tito, juan)."));
        Assert.assertFalse(parser.validFact("varon:-(tito)."));
    }

    @Test
    public void testParseShouldDetectWhenEntryIsRule() {

        Assert.assertTrue(parser.validRule("hijo(X, Y) :- varon(X)."));
        Assert.assertTrue(parser.validRule("hijo(X, Y) :- varon(X), padre(Y, X)."));
        Assert.assertFalse(parser.validRule("hijo(X, Y) :-  varon(X),padre(Y, X)."));
    }

    @Test
    public void testParseShouldDetectWhenQueryFormatIsValid() {

        Assert.assertFalse(parser.validQuery("hijo(X, Y) :- varon(X)."));
        Assert.assertFalse(parser.validQuery("hijo(X, Y) :- varon(X), padre(Y, X)."));
        Assert.assertFalse(parser.validQuery("hijo(X, Y)."));
        Assert.assertFalse(parser.validQuery("hijo(juan)"));
        Assert.assertFalse(parser.validQuery("hijo (juan)"));

        Assert.assertTrue(parser.validQuery("hijo(juan)."));
        Assert.assertTrue(parser.validQuery("hijo(juan, pepe)."));

    }

    @Test
    public void testParseFact() {
        String[] factParams = {"juan"};
        Fact fact = new Fact("varon", factParams);

        Assert.assertTrue(parser.parseFact("varon(juan).").isEqualTo(fact));
        Assert.assertFalse(parser.parseFact("varon(marta).").isEqualTo(fact));
    }

    @Test
    public void testParseRule() {
        String[] factParams = {"X"};
        Fact fact = new Fact("varon", factParams);

        String[] ruleParams = {"X"};
        List<Fact> ruleFact = new ArrayList<>();
        ruleFact.add(fact);
        Rule rule = new Rule("hijo", ruleParams, ruleFact);

        Assert.assertTrue(parser.parseRule("hijo(X) :- varon(X).").toString().equals(rule.toString()));
        Assert.assertFalse(parser.parseRule("hijo(PEPE) :- varon(PEPE).").toString().equals(rule.toString()));
    }
}
