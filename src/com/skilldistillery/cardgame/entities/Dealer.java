package com.skilldistillery.cardgame.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck aDeck = new Deck();

	public Dealer(){
		super();
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
		if(hand.needHandValue() < 17) {
			return true;
		}
		return false;
	}
	public int deckSize() {
		return aDeck.checkDeckSize();
	}
	public void displayDealerHand() {
		List<Card> dealerHand = hand.getHandOfCards();
		System.out.print("Dealer's hand: [First card face down");
		for(int i = 1; i < dealerHand.size(); i++) {
			System.out.print(", " + dealerHand.get(i));
		}
		System.out.println("]");
	}
}
