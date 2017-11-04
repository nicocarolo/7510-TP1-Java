package ar.uba.fi.tdd.rulogic.model;

public class Parser {

    public boolean validRule (String entry) {
        return entry.matches("^[a-z]+\\(([A-Z]+, )*[A-Z]+\\) :- (([a-z]+\\(([A-Z]+, )*[A-Z]+\\)), )*([a-z]+\\(([A-Z]+, )*[A-Z]+\\))\\.");
    }

    public boolean validFact (String entry) {
        return entry.matches("^[a-z]+\\(([a-z]+, )*[a-z]+\\)\\.");
    }
}
