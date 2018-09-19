package blackjack;

public class Card {
	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

		public int getValue() {
			// Face Cards
			if (this.ordinal() + 1 > 10) {
				return 10;
				// All other cards
			} else {
				return this.ordinal() + 1;
			}
		}
	}

	public enum Suit {
		CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

		private final String symbol;

		private Suit(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return this.symbol;
		}
	}

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getRank() {
		return this.rank.getValue();
	}

	public String getSuit() {
		return this.suit.getSymbol();
	}

	public String getRankString() {
		return this.rank.name();
	}
	
}
