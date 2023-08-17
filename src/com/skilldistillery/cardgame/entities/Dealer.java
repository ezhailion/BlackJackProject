package com.skilldistillery.cardgame.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck aDeck = new Deck();

	public Dealer() {
		super();
	}
	public void getNewDeck() {
		aDeck = new Deck();
	}
	public void play() {
		Deck aDeck = new Deck();
		System.out.println(aDeck.checkDeckSize());
		aDeck.shuffleDeck();
	}

	public Card dealCard() {
		Card dealtCard = aDeck.dealCard();
		return dealtCard;
	}

	public boolean needsHit() {
		if (hand.needHandValue() < 17) {
			return true;
		}
		return false;
	}

	public int deckSize() {
		return aDeck.checkDeckSize();
	}

	public void displayDealerHand() {
		System.out.println("Dealer's hand: [First card face down, " + hand.getHandOfCards().get(1) + "] " + hand.getHandOfCards().get(1).getValue());
	}

	public void showDHand() {
		System.out.println("Dealer's hand: " + hand + " " + ((BlackJackHand) getHand()).needHandValue() + "\n");
	}

	public Deck getaDeck() {
		return aDeck;
	}

	public void setaDeck(Deck aDeck) {
		this.aDeck = aDeck;
	}

}
