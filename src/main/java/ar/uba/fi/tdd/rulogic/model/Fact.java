package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;

public class Fact {
    private String name;
    private String[] values;

    public Fact(String name, String[] params){
        this.name = name;
        this.values = params;
    }

    public String getName() {
        return name;
    }

    public String[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        String factString =  this.name + "(";
        for (int j = 0; j < this.values.length; j++) {
            factString += this.values[j] + ", ";
        }
        factString = factString.substring(0, factString.length() - 2);
        factString += ").";
        return factString;
    }

    public boolean isEqualTo(Fact factToCompare) {
        if (this.name.equals(factToCompare.getName())
                && String.join(",", this.values).equals(String.join(",", factToCompare.getValues()))) return true;
        return false;
    }
}