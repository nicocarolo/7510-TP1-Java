package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;

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
}
