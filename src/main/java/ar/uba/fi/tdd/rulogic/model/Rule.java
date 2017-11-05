package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

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
