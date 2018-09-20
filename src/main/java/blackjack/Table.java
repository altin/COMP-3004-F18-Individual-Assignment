package blackjack;

import java.util.Scanner;

import blackjack.Player.State;

public class Table {

	private Player player;
	private Player dealer;
	private Deck deck;

	public Table(Player player, Player dealer, Deck deck) {
		this.player = player;
		this.dealer = dealer;
		this.deck = deck;
	}

	public Player determineWinner() {
		switch (player.getState()) {
		case BLACKJACK:
			dealer.hit(deck);
			if (dealer.getState().equals(State.BLACKJACK)) {
				//System.out.println("Dealer wins.");
				return dealer;
			} else {
				//System.out.println("Player wins.");
				return player;
			}
		case BUST:
			//System.out.println("Dealer wins.");
			return dealer;
		case STAND:
		case NONE:
			System.out.println("@========+------~------+========@");
			System.out.println("@         Dealer's Turn         @");
			System.out.println("@========+------~------+========@");
			dealer.hit(deck);
			switch (dealer.getState()) {
			case BLACKJACK:
				//System.out.println("Dealer wins.");
				return dealer;
			case STAND:
			case NONE:
				if (dealer.evaluateHands().getScore() > player.evaluateHands().getScore()) {
					//System.out.println("Dealer wins.");
					return dealer;
				} else {
					//System.out.println("Player wins.");
					return player;
				}
			case BUST:
				//System.out.println("Player wins.");
				return player;
			default:
				return null;
			}
		default:
			return null;
		}
	}

	public void startGame() {
		System.out.println("Welcome to COMP 3004 BlackJack!");
		
		Scanner reader = new Scanner(System.in);

		deck.createDeck();
		deck.shuffle();

		System.out.println("@========+------~------+========@");
		System.out.println("@         Player's Turn         @");
		System.out.println("@========+------~------+========@");
		
		dealer.hit(deck);
		player.hit(deck);

		while (player.getNumActiveHands() > 0) {
			System.out.print("\n=> Type 'H' to Hit or 'S' to Stand: ");
			String n = reader.nextLine();

			if (n.toUpperCase().equals("H")) {
				player.hit(deck);
			} else if (n.toUpperCase().equals("S")) {
				player.stand(deck);
			}
		}
		reader.close();
		
		Player winner = determineWinner();
		System.out.println(winner.getName() + " wins!");
	}

}
