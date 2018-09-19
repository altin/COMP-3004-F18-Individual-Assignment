package blackjack;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;

	public Hand() {
		this.cards = new ArrayList<Card>();
	}
	
	public void drawCard(Deck deck) {
		this.cards.add(deck.deal());
	}
	
	public void drawHand(Deck deck) {
		this.drawCard(deck);
		this.drawCard(deck);
	}
	
	@Override
	public String toString() {
		String cardsString = "";
		// add counter for each hand
		for (Card aCard : this.cards) {
			cardsString += aCard.toString();
		}
		return cardsString;
	}
}
