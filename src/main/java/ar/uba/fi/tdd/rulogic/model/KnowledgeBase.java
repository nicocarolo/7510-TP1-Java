package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnowledgeBase {

	private List<Fact> dbFacts;
	private List<Rule> dbRules;
	private Parser parser;

	public KnowledgeBase(){
		this.parser = new Parser();
	}


	public List<Fact> getDbFacts() {
		return dbFacts;
	}

	public List<Rule> getDbRules() {
		return dbRules;
	}

	public void parseDB(String filename) {
		Supplier<Stream<String>> fileData = () -> {
			try {
				return
				Files.lines(Paths.get(ClassLoader
						.getSystemClassLoader()
						.getResource(filename)
						.toURI()));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		};
		this.dbRules = fileData.get()
				.filter(line -> this.parser.validRule(line))
				.map(line -> this.parser.parseRule(line))
				.collect(Collectors.toList());
		this.dbFacts = fileData.get()
				.filter(line -> this.parser.validFact(line))
				.map(line -> this.parser.parseFact(line))
				.collect(Collectors.toList());

	}

	public boolean answer(String query) {
		if (this.parser.validQuery(query)) {
            Fact parsedQuery = this.parser.parseFact(query);
			if (this.isFact(parsedQuery)){
				return true;
			}
			else {
				if (this.isRule(parsedQuery)) {
                    List<Fact> factsToTest = this.matchRule(parsedQuery);
					return factsToTest.stream().allMatch(fact -> this.isFact(fact));
				}
			}
		}
		return false;
	}

	public boolean isFact(Fact query){
		Boolean isFact = this.dbFacts.stream().anyMatch(fact -> fact.isEqualTo(query));
		return isFact;
	}

	public boolean isRule(Fact query){
		Boolean isRule = this.dbRules.stream().anyMatch(rule -> rule.getName().equals(query.getName()));
		return isRule;
	}

	public List<Fact> matchRule(Fact query) {
		Optional<Rule> rule = this.dbRules.stream().filter(rules -> rules.getName().equals(query.getName())).findFirst();
		if (rule.isPresent()) {
			return rule.get().factsToTestReplacedParams(query.getValues());
		}
		return null;
	}

}
