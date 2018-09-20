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
	
	public void testAceWorthOneOrEleven() {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		
		Hand h1 = new Hand();
		h1.drawHand(d1);
		
		// Two aces = value of 12 (1 ace is 11, the other is 1)
		assertEquals(12, h1.getScore());
		
	}
	
	public void testAceWorthOne() {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.KING, Suit.DIAMONDS));
		d1.addCard(new Card(Rank.KING, Suit.HEARTS));
		
		Hand h1 = new Hand();
		h1.drawCard(d1);
		h1.drawCard(d1);
		h1.drawCard(d1);
		
		// Two kings = 20, 1 ace = 1, therefore 21
		assertEquals(21, h1.getScore());
		
	}
	
	public void testAceWorthEleven() {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.NINE, Suit.DIAMONDS));
		
		Hand h1 = new Hand();
		h1.drawCard(d1);
		h1.drawCard(d1);
		
		// Ace = 11, Nine = 9, total = 20
		assertEquals(20, h1.getScore());
		
	}
	
	public void testTwoAcesWorthOneEach() {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		d1.addCard(new Card(Rank.KING, Suit.HEARTS));
		
		Hand h1 = new Hand();
		h1.drawCard(d1);
		h1.drawCard(d1);
		h1.drawCard(d1);
		
		// King = 10, Ace = 1, Ace = 1
		assertEquals(12, h1.getScore());
		
	}
	
	public void testAceWorthElevenThenOne() {
		Deck d1 = new Deck();
		
		d1.addCard(new Card(Rank.ACE, Suit.CLUBS));
		d1.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		d1.addCard(new Card(Rank.KING, Suit.HEARTS));
		
		Hand h1 = new Hand();
		h1.drawCard(d1);
		h1.drawCard(d1);
		// King = 10, Ace = 11, therefore 21
		assertEquals(21, h1.getScore());
		
		// King = 10, Ace = 1, Ace = 1
		h1.drawCard(d1);
		assertEquals(12, h1.getScore());
		
	}
}
