package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

import java.util.Scanner;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) {
		KnowledgeBase base = new KnowledgeBase();
		base.parseDB("rules.db");
		System.out.println("I shall answer all your questions!");
		System.out.println("Please answer to me like nameFact(value, otherValue). \nOr say Bye to exit:");

		Scanner scan = new Scanner(System.in);
		String query = scan.next();
		while (!query.equals("Bye")){
			System.out.println(base.answer(query));
			System.out.println("Please answer to me like nameFact(value, otherValue). \nOr say Bye to exit:");
			query = scan.next();
		}
    }
}
