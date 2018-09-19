package blackjack;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	public void testConstructor() {
		Hand h1 = new Hand();
		assertNotNull(h1);
	}
}
