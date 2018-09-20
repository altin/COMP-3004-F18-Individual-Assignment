package blackjack;

import java.util.ArrayList;
import java.util.Random;

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
	
	public void addCard(Card card) {
		this.deck.add(card);
	}

	public void shuffle() {
		Random random = new Random();
		ArrayList<Card> tempDeck = new ArrayList<Card>();

		int index = 0;

		for (int i = 0; i < this.deck.size(); i++) {
			index = random.nextInt(this.deck.size());
			tempDeck.add(this.deck.get(index));
			this.deck.remove(index);
		}

		this.deck = tempDeck;
	}

	public int getDeckSize() {
		return this.deck.size();
	}

	public ArrayList<Card> getDeckArray() {
		return this.deck;
	}

	public Card getCardAtIndex(int i) {
		return this.deck.get(i);
	}
	
	public Card deal() {
		return this.deck.remove(deck.size() - 1);
	}

	public boolean equals(Deck deck2) {
		if (this.deck.size() != deck2.getDeckSize())
			return false;

		for (int i = 0; i < this.deck.size(); i++) {
			if (this.deck.get(i).getRank() != deck2.getCardAtIndex(i).getRank()) {
				return false;
			}
		}
		return true;
	}
}
