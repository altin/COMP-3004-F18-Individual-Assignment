package blackjack;

public class Player {
	protected String name = "Player";
	protected ArrayList<Hand> hands;
	protected ArrayList<Hand> standingHands;
	protected State state;

	public Player() {
		this.hands = new ArrayList<Hand>();
		this.standingHands = new ArrayList<Hand>();
	}
}
