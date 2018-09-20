package blackjack;

import java.util.ArrayList;

public class Dealer extends Player {
	private String name = "Dealer";

	public Dealer() {
		super();
	}

	public void hit(Deck deck) {
		if (hands.size() == 0) {
			this.hands.add(new Hand());
			this.getCurrentHand().drawHand(deck);
			System.out.println(this.getName() + "'s Hand: " + this.peekHand());
		} else {
			State currentState = this.revealHand();

			if (!currentState.equals(State.NONE)) {
				this.setState(currentState);
				return;
			}

			while (this.getNumActiveHands() > 0 && this.getCurrentHand().getScore() < 17
					|| this.getCurrentHand().isSoftSeventeen()) {

				this.getCurrentHand().drawCard(deck);

				System.out.println("\n" + this.getName() + " Hits: " + this.getCurrentHand().getLastCard());
				System.out.println(this.getName() + "'s Hand: " + this.getCurrentHand().toString());

				currentState = this.checkHands();

				if (!currentState.equals(State.NONE)) {
					this.setState(currentState);
					return;
				}
			}

			this.stand(deck);
			return;
		}

		this.setState(State.NONE);
		return;
	}

	public State revealHand() {
		System.out.println(this.getName() + "'s Hand: " + this.getCurrentHand().toString());
		return this.checkHands();
	}

	public String peekHand() {
		ArrayList<Card> handString = this.getCurrentHand().getHand();

		String firstCard = handString.get(0).toString();
		String firstCardScore = Integer.toString(handString.get(0).getRank());

		return firstCard + " ?? (" + firstCardScore + ")";
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

		if (this.getCurrentHand().isSoftSeventeen()) {
			System.out.println(this.getName() + " stands.\n");
			//this.standingHands.add(this.putDownHand());
			return State.STAND;
		}

		return State.NONE;
	}

	public String getName() {
		return this.name;
	}

}
