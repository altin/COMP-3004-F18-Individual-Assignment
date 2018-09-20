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
	
	public int getHandSize() {
		return this.cards.size();
	}
	
	public String getLastCard() {
		return this.cards.get(this.getHandSize() - 1).toString();
	}
	
	public ArrayList<Card> getHand() {
		ArrayList<Card> hand = new ArrayList<Card>();

		for (Card aCard : this.cards) {
			hand.add(aCard);
		}

		return hand;
	}
	
	public int getScore() {
		int score = 0;
		boolean ace = false;
		
		for (Card card : cards) {
			int cardValue = card.getRank();
			if (cardValue == 1) {
				ace = true;
			}
			score = score + cardValue;
		}
		
		if (ace == true && score + 10 <= 21) {
			score = score + 10;
		}

		return score;
	}
	
	public boolean isBlackjack() {
		if (this.getScore() == 21 && this.cards.size() == 2) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (this.getScore() > 21) {
			return true;
		}
		return false;
	}

	public boolean isSoftSeventeen() {
		return this.getScore() == 17 && this.getHandSize() == 2;
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
