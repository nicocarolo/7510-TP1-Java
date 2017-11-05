package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private String name;
    private String[] params;
    private List<Fact> factsToTest;

    public Rule(String description, String[] params, List<Fact> factsToTest) {
        this.name = description;
        this.params = params;
        this.factsToTest = factsToTest;
    }

    public String getName() {
        return name;
    }

    public String[] getParams() {
        return params;
    }

    public List<Fact> getFactsToTest() {
        return factsToTest;
    }

    public List<Fact> factsToTestReplacedParams(String[] params) {
        
        List<Fact> factsOfRule = new ArrayList<>();
        for (int i = 0; i < this.factsToTest.size(); i++) { //loop facts to test
            Fact fact = new Fact(this.factsToTest.get(i).getName(), this.factsToTest.get(i).getValues().clone());
            for (int j = 0; j < this.params.length; j++) {  //loop params
                int index = Arrays.asList(fact.getValues()).indexOf(this.params[j]);
                if (index != -1) {
                    fact.getValues()[index] = params[j];
                }
            }
            factsOfRule.add(fact);
        }
        return factsOfRule;
    }

    @Override
    public String toString() {
        String ruleString = this.name + "(";
        for (int j = 0; j < this.params.length; j++) {  //loop params
            ruleString += this.params[j] + ", ";
        }
        ruleString = ruleString.substring(0, ruleString.length() - 2);
        ruleString += ") :- ";
        for (int j = 0; j < this.factsToTest.size(); j++) {  //loop params
            ruleString += this.factsToTest.get(j).toString() + "\n";
        }
        ruleString = ruleString.substring(0, ruleString.length() - 1);
        return ruleString;
    }
}
