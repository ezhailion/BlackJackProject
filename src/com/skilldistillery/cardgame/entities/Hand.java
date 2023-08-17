package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> handOfCards = new ArrayList<>();

	public Hand() {
		List<Card> handOfCards;
	}

	public void addCard(Card card) {
		handOfCards.add(card);
	}

	public void seeHand() {
		for (Card card : handOfCards) {
			System.out.println(card);
		}
	}

	abstract int needHandValue();

	public List<Card> getHandOfCards() {
		return handOfCards;
	}

	public void setHandOfCards(List<Card> handOfCards) {
		this.handOfCards = handOfCards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [handOfCards=");
		builder.append(handOfCards);
		builder.append("]");
		return builder.toString();
	}
}
