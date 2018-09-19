package blackjack;

import java.util.ArrayList;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	public void testConstructor() {
		Deck d1 = new Deck();
		assertNotNull(d1);
	}

	public void testCreateDeck_CardCount() {
		Deck d1 = new Deck();

		d1.createDeck();
		assertEquals(52, d1.getDeckSize());
	}

	public void testCreateDeck_RankCount() {
		Deck d1 = new Deck();
		d1.createDeck();
		ArrayList<Card> deck = d1.getDeckArray();

		int rankCount = 0;

		// Sum of the values of the ranks of each card
		for (Card card : deck) {
			rankCount += card.getRank();
		}
		// Summation of cards 1 to 10: 55
		// Summation of face cards (J,Q,K): 30
		// Total for one suit: 85
		// 4 suits * 85 = 340 (hard value of cards)
		assertEquals(340, rankCount);
	}

	public void testCreateDeck_SuitCount() {
		Deck d1 = new Deck();
		d1.createDeck();
		ArrayList<Card> deck = d1.getDeckArray();

		int clubsCount = 0;
		int diamondsCount = 0;
		int heartsCount = 0;
		int spadesCount = 0;

		for (Card card : deck) {
			switch (card.getSuit()) {
			// Clubs
			case "C":
				clubsCount++;
				break;
			// Diamonds
			case "D":
				diamondsCount++;
				break;
			// Hearts
			case "H":
				heartsCount++;
				break;
			// Spades
			case "S":
				spadesCount++;
				break;
			default:
				break;
			}
		}

		assertEquals(13, clubsCount);
		assertEquals(13, diamondsCount);
		assertEquals(13, heartsCount);
		assertEquals(13, spadesCount);
	}

	public void testCreateDeck_SpecialCardCount() {
		Deck d1 = new Deck();
		d1.createStandardDeck();
		ArrayList<Card> deck = d1.getDeckArray();

		int aceCount = 0;
		int jackCount = 0;
		int queenCount = 0;
		int kingCount = 0;

		// Checking if four of each special cards
		for (Card card : deck) {
			switch (card.getRankString()) {
			case "ACE":
				aceCount++;
				break;
			case "JACK":
				jackCount++;
				break;
			case "QUEEN":
				queenCount++;
				break;
			case "KING":
				kingCount++;
				break;
			default:
				break;
			}
		}

		assertEquals(4, aceCount);
		assertEquals(4, jackCount);
		assertEquals(4, queenCount);
		assertEquals(4, kingCount);
	}
}
