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
	public void displayHand() {
		List<Card> playerHand = hand.getHandOfCards();
		for(int i = 1; i < playerHand.size(); i++) {
			System.out.println(playerHand.get(i));
		}
	}

	@Override
	public String toString() {
		return "[hand=" + hand + "]";
	}
	
	
}
//