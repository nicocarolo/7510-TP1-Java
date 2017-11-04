package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RuleTest {
    @Test
    public void testRuleShouldBeCreatedWithNameParamAndFact() {
        String[] factParams = {"javier"};
        Fact fact = new Fact("varon", factParams);

        String[] ruleParams = {"X"};
        Fact[] ruleFact = {fact};
        Rule rule = new Rule("hijo", ruleParams, ruleFact);

        Assert.assertTrue(rule.getName().equals("hijo"));
        Assert.assertTrue(Arrays.equals(rule.getParams(), ruleParams));

        String factsInRule = "";
        for (int i = 0; i < rule.getFactsToTest().length; i++){
            factsInRule += rule.getFactsToTest()[i].toString();
        }

        Assert.assertTrue(factsInRule.equals(fact.toString()));
    }

}
