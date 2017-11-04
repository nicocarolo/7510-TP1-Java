package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;

public class Rule {

    private String name;
    private String[] params;
    private Fact[] factsToTest;

    public Rule(String description, String[] params, Fact[] factsToTest) {
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

    public Fact[] getFactsToTest() {
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
        for (int j = 0; j < this.factsToTest.length; j++) {  //loop params
            ruleString += this.factsToTest[j].toString() + "\n";
        }
        ruleString = ruleString.substring(0, ruleString.length() - 1);
        return ruleString;
    }
}
