package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
		System.out.println("hola");

	}

	public boolean answer(String query) {

		return true;
	}

}
