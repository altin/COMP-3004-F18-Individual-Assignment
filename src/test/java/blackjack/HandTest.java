package blackjack;

import blackjack.Card.Rank;
import blackjack.Card.Suit;
import junit.framework.TestCase;

public class HandTest extends TestCase {
	public void testConstructor() {
		Hand h1 = new Hand();
		assertNotNull(h1);
	}

	public void testDrawCard() {
		Deck d1 = new Deck();
		d1.createDeck();

		Hand h1 = new Hand();
		h1.drawCard(d1);

		assertEquals("SK", h1.toString());
	}
	
	public void testAceWorthOneOrEleven {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		
		Hand h1 = new Hand();
		h1.drawHand(deck);
		
		// Two aces = value of 12 (1 ace is 11, the other is 1)
		assertEquals(12, h1.getScore());
		
	}
}
