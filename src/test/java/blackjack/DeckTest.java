package blackjack;

import junit.framework.TestCase;

public class DeckTest extends TestCase {
	public void testConstructor( ) {
		Deck d1 = new Deck();
		assertNotNull(d1);
	}
}
