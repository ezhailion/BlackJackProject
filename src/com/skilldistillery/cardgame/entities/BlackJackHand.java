package com.skilldistillery.cardgame.entities;

public class BlackJackHand extends Hand {
	public BlackJackHand() {
		super();
	}

	public boolean isWin() {
		if (needHandValue() == 21) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "[" + handOfCards + "]";
	}

	public boolean isBust() {
		if (needHandValue() > 21) {
			return true;
		}
		return false;
	}

	public int needHandValue() {
		int valueOfHand = 0;
		for (Card card : handOfCards) {
			valueOfHand += card.getValue();
		}
		return valueOfHand;
	}

}
