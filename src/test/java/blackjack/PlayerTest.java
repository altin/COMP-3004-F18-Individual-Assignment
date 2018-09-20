package blackjack;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testConstructor() {
		Player p1 = new Player();
		
		assertNotNull(p1);
	}
}
