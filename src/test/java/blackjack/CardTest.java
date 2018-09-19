package blackjack;

import blackjack.Card.Rank;
import blackjack.Card.Suit;
import junit.framework.TestCase;

public class CardTest extends TestCase {
	
	public void testConstructor() {
		Card c1  = new Card(Rank.ACE, Suit.CLUBS);
	}
}
