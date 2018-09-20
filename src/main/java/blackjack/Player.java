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
	
	public String getName() {
		return this.name;
	}
	
	public Hand getCurrentHand() {
		return this.hands.get(getNumActiveHands() - 1);
	}
	
	public int getNumActiveHands() {
		return this.hands.size();
	}
	
	public State getState() {
		return this.state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public Hand putDownHand() {
		return this.hands.remove(getNumActiveHands() - 1);
	}
	
	public void hit(Deck deck) {
		if (hands.size() == 0) {
			this.hands.add(new Hand());
			this.getCurrentHand().drawHand(deck);
			System.out.println(this.getName() + "'s Hand: " + this.getCurrentHand().toString() + "");
			this.setState(this.checkHands());
		} else {
			this.getCurrentHand().drawCard(deck);
			System.out.println("\n" + this.getName() + " Hits: " + this.getCurrentHand().getLastCard());
			System.out.println(this.getName() + "'s Hand: " + this.getCurrentHand().toString() + "");
			this.setState(this.checkHands());
		}
	}
	
	public Hand evaluateHands() {
		Hand bestHand = new Hand();
		int currentScore = 0;
		for (Hand hand : this.standingHands) {
			if (hand.getScore() > currentScore) {
				currentScore = hand.getScore();
				bestHand = hand;
			}
		}
		return bestHand;
	}
	
	public void stand(Deck deck) {
		System.out.println("\n" + this.getName() + " Stands.");
		this.standingHands.add(this.putDownHand());

		this.setState(State.STAND);
	}
	
	public State checkHands() {
		if (this.hands.size() == 1) {
			if (this.getCurrentHand().isBlackjack()) {
				System.out.println(this.getName() + " has a BlackJack!\n");
				this.standingHands.add(this.putDownHand());
				return State.BLACKJACK;
			}
		}

		if (this.getCurrentHand().isBust()) {
			System.out.println(this.getName() + " busts!\n");
			this.standingHands.add(this.putDownHand());
			return State.BUST;
		}

		return State.NONE;
	}
}
