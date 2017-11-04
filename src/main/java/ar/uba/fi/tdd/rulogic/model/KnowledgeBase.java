package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class KnowledgeBase {
	private Fact[] dbFacts;
	private Rule[] dbRules;

	public void parseDB(String filename) {
		try {
			Files.lines(Paths.get(ClassLoader
                            .getSystemClassLoader()
                            .getResource(filename)
                            .toURI()))
                            .map(line -> {
//                            	parser must detect if line is fact or rule
// 								and after this, append the data in the correct database
                                return line;
                                });
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public boolean answer(String query) {

		return true;
	}

}
