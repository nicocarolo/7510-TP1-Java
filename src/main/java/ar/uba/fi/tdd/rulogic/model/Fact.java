package ar.uba.fi.tdd.rulogic.model;

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
}