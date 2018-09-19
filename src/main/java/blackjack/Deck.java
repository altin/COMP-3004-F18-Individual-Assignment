package blackjack;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck;

	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public void createDeck() {
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				this.deck.add(new Card(rank, suit));
			}
		}
	}
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	public ArrayList<Card> getDeckArray() {
		return this.deck;
	}
}
