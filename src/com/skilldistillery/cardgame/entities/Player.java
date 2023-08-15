package com.skilldistillery.cardgame.entities;

import java.util.List;

public class Player {
	protected Hand hand;
	
	public Player() {
		hand = new BlackJackHand();
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}
	public void showHand() {
		System.out.print("Player's hand: " + hand + " " + ((BlackJackHand) getHand()).needHandValue() + "\n");
	}

	@Override
	public String toString() {
		return "[hand=" + hand + "]";
	}
	
	
}
//