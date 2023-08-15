package com.skilldistillery.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card aCard = new Card(rank, suit);
				deckOfCards.add(aCard);
			}

		}
	}

	public int cardsLeftInDeck() {
		int cardsLeft = checkDeckSize();
		return cardsLeft;
	}
	public int checkDeckSize() {
		return deckOfCards.size();
	}

	public Card dealCard() {
		Card cardToDeal = deckOfCards.remove(0);
		
		return cardToDeal;
	}
	public void dealCard(Hand hand) {
		hand.handOfCards.add(deckOfCards.remove(0));
	}

	public void shuffleDeck() {
		Collections.shuffle(deckOfCards);
	}
}
