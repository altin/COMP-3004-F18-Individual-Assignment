package blackjack;

import blackjack.Card.Rank;
import blackjack.Card.Suit;
import junit.framework.TestCase;

public class CardTest extends TestCase {

	public void testConstructor() {
		Card c1 = new Card(Rank.ACE, Suit.CLUBS);
		assertNotNull(c1);
	}

	public void testGetRank() {
		Card c1 = new Card(Rank.ACE, Suit.DIAMONDS);
		assertEquals(c1.getRank(), 1);

		Card c2 = new Card(Rank.TWO, Suit.DIAMONDS);
		assertEquals(c2.getRank(), 2);

		Card c3 = new Card(Rank.JACK, Suit.DIAMONDS);
		assertEquals(c3.getRank(), 10);
	}

	public void testGetSuit() {
		Card c1 = new Card(Rank.ACE, Suit.DIAMONDS);
		assertEquals(c1.getSuit(), "D");

		Card c2 = new Card(Rank.TWO, Suit.CLUBS);
		assertEquals(c2.getSuit(), "C");

		Card c3 = new Card(Rank.JACK, Suit.SPADES);
		assertEquals(c3.getSuit(), "S");

		Card c4 = new Card(Rank.JACK, Suit.HEARTS);
		assertEquals(c4.getSuit(), "H");
	}
	
	public void testCardToString() {
		Card c1 = new Card(Rank.KING, Suit.SPADES);
		Card c2 = new Card(Rank.QUEEN, Suit.HEARTS);
		Card c3 = new Card(Rank.JACK, Suit.DIAMONDS);
		Card c4 = new Card(Rank.ACE, Suit.CLUBS);
		
		assertEquals("SK", c1.toString());
		assertEquals("HQ", c2.toString());
		assertEquals("DJ", c3.toString());
		assertEquals("CA", c4.toString());
	}
}
