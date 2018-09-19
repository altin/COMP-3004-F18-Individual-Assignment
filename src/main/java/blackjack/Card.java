package blackjack;

public class Card {
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN,
		KING;
	}
	
	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
}
