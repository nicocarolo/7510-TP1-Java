package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;

public class Rule {

    String name;
    String[] params;
    Fact[] factsToTest;

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
}
