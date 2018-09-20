package blackjack;

import java.util.ArrayList;

public class Player {
	public enum State {
		BLACKJACK, BUST, STAND, NONE;
	}
	
	protected String name = "Player";
	protected ArrayList<Hand> hands;
	protected ArrayList<Hand> standingHands;
	protected State state;

	public Player() {
		this.hands = new ArrayList<Hand>();
		this.standingHands = new ArrayList<Hand>();
	}
	
	public Hand getCurrentHand() {
		return this.hands.get(getNumActiveHands() - 1);
	}
	
	public int getNumActiveHands() {
		return this.hands.size();
	}
}
