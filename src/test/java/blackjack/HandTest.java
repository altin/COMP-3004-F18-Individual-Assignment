package blackjack;

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
		h1.drawCard();

		assertEquals("SK", h1.toString());
	}
}
