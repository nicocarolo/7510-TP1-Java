package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleTest {

    @Test
    public void testRuleShouldBeCreatedWithNameParamAndFact() {
        String[] factParams = {"X"};
        Fact fact = new Fact("varon", factParams);

        String[] ruleParams = {"X"};
        List<Fact> ruleFact = new ArrayList<>();
        ruleFact.add(fact);
        Rule rule = new Rule("hijo", ruleParams, ruleFact);

        Assert.assertTrue(rule.getName().equals("hijo"));
        Assert.assertTrue(Arrays.equals(rule.getParams(), ruleParams));

        String factsInRule = "";
        for (int i = 0; i < rule.getFactsToTest().size(); i++){
            factsInRule += rule.getFactsToTest().get(i).toString();
        }

        Assert.assertTrue(factsInRule.equals(fact.toString()));
    }

    @Test
    public void testRuleShouldBeGetAsString() {
        String[] ruleParams = {"X"};

        String[] factParams = {"X"};
        Fact fact = new Fact("varon", factParams);
        String[] otherFactParams = {"Y", "X"};
        Fact otherFact = new Fact("padre", otherFactParams);
        List<Fact> ruleFact = new ArrayList<>();
        ruleFact.add(fact);
        ruleFact.add(otherFact);

        Rule rule = new Rule("hijo", ruleParams, ruleFact);
        assert(rule.toString().equals("hijo(X) :- varon(X).\npadre(Y, X)."));
    }
}
