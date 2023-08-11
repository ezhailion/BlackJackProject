package com.skilldistillery.enums.drills.cards;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.Card;
import com.skilldistillery.cardgame.entities.Deck;

public class Dealing {
	Scanner dealer = new Scanner(System.in);

	public static void main(String[] args) {
		
		Dealing dealApp = new Dealing();
		dealApp.play();
		
		
		
	}
	public void play() {
		Deck aDeck = new Deck();
		System.out.println(aDeck.checkDeckSize());
		aDeck.shuffleDeck();

		dealingCards(aDeck);
		dealer.close();
	}
	public void dealingCards(Deck aDeck) {
		System.out.println("How many cards do you want?");
		int numOfCards = dealer.nextInt();
		dealer.nextLine();

		if (numOfCards > 52) {
			System.err.println("Don't be ridiculous!");
		} else {
			for (int i = 0; i < numOfCards; i++) {
				Card dealtCard = aDeck.dealCard();
				System.out.println(dealtCard + " ");
			}

			System.out.println(numOfCards + " have been dealt.");
		}
	}

}
