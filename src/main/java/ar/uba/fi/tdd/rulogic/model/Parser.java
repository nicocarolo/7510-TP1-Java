package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    public boolean validRule (String entry) {
        return entry.matches("^[a-z]+\\(([A-Z]+, )*[A-Z]+\\) :- (([a-z]+\\(([A-Z]+, )*[A-Z]+\\)), )*([a-z]+\\(([A-Z]+, )*[A-Z]+\\))\\.");
    }

    public boolean validFact (String entry) {
        return entry.matches("^[a-z]+\\(([a-z]+, )*[a-z]+\\)\\.");
    }

    public Fact parseFact(String entryFact) {
        //Split entry:  in first position of the result will have fact name
        //              in second position of the result will have the params
        String[] splittedEntry = entryFact.split("[().]");
        return new Fact(splittedEntry[0], splittedEntry[1].split("/, /"));
    }

    public Rule parseRule(String entryRule) {
        //Split entry:  in first position of the result will have fact name
        //              in second position of the result will have the params
//        String[] splittedEntry = entryRule.split("[().]||( :- )");
        String[] splittedEntry = entryRule.split("\\(|, \\)|\\.\\:-");
        List<Fact> factsOfRule = new ArrayList<>();
        for (int i = 2; i < splittedEntry.length -1; i = i + 2) {
            if (!splittedEntry[i].equals("")) {
                factsOfRule.add(new Fact(splittedEntry[i], splittedEntry[i+1].split("/, /")));
            }
        }
        return new Rule(splittedEntry[0], splittedEntry[1].split("/, /"), factsOfRule);
    }

    public boolean validQuery (String query) {
        return query.matches("/^[a-z]+\\(([a-z]+, )*[a-z]+\\)");
    }
}
