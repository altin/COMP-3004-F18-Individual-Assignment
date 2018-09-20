package blackjack;

import blackjack.Card.Rank;
import blackjack.Card.Suit;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testConstructor() {
		Player p1 = new Player();
		
		assertNotNull(p1);
	}
	
	public void testCanHit() {
		Hand hand = new Hand();
		
		Player p1 = new Player();
		Deck d1 = new Deck();
		d1.createDeck();
		
		Card c1 = new Card(Rank.QUEEN, Suit.SPADES);
		
		p1.hit(d1);
		hand = p1.getCurrentHand();
		assertEquals(c1.toString(), hand.getLastCard());
	}
	
	
}
