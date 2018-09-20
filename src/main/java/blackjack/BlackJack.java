package blackjack;

import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in); // Reading from System.in

		System.out.println("COMP 3004 F18 Individual Assignment\n");
		System.out.println("-- Altin Rexhepaj (101000622)\n");
		System.out.print("Type 'C' for console input or 'F' for file input: ");

		String n = reader.nextLine();

		if (n.equalsIgnoreCase("c")) {
			System.out.println("Starting console version...\n");
			Table table = new Table(new Player(), new Dealer(), new Deck());
			table.startGame();
			reader.close();
		} else if (n.equalsIgnoreCase("f")) {
			System.out.println("Not yet supported");
			reader.close();
		}
	}
}
