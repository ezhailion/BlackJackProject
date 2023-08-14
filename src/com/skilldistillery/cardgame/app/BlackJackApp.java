package com.skilldistillery.cardgame.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.BlackJackHand;
import com.skilldistillery.cardgame.entities.Dealer;
import com.skilldistillery.cardgame.entities.Player;

public class BlackJackApp {
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	protected Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

	public void launch() {
		BlackJackHand dealerHand = ((BlackJackHand) (dealer.getHand()));
		BlackJackHand playerHand = ((BlackJackHand) (player.getHand()));
		int startingInput;
		int gameInput;
		showMenu();
		startingInput = sc.nextInt();
		if (startingInput == 1) {
			makeStartingHands();
			System.out.println(playerHand.getHandOfCards());
			gameMenu();
			gameInput = sc.nextInt();
			playerTurnChoice(gameInput, playerHand, dealerHand);
					while (gameInput == 1) {
						gameMenu();
						gameInput = sc.nextInt();

				playerTurnChoice(gameInput, playerHand, dealerHand);
			}
		}

	}

	public void showMenu() {
		System.out.println("*******************");
		System.out.println("* So you think you want to play Blackjack? *");
		System.out.println("* 1. Yes *");
		System.out.println("* 2. No  *");
		System.out.println("*******************");
	}

	public void gameMenu() {
		System.out.println("Would you like to hit or stay?");
		System.out.println("1. Hit");
		System.out.println("2. Stay");
	}

	private void makeStartingHands() {
		for (int i = 0; i == 2; i++) {
			player.addCard(dealer.dealCard());
			player.displayHand();

			dealer.addCard(dealer.dealCard());
			dealer.displayDealerHand();
		}
	}


	private void playerTurnChoice(int input, BlackJackHand playerHand, BlackJackHand dealerHand) {
		if (input == 1) {
			playerHand.addCard(dealer.dealCard());
			if (playerHand.isBust()) {
				System.out.println("Sorry! You bust!");
			} else if (playerHand.isWin()) {
				System.out.println("You win with a perfect 21!");
			} else {
				dealerTurn(dealerHand);
			}
		}

	}

	private void dealerTurn(BlackJackHand dealerHand) {
		dealerHand.addCard(dealer.dealCard());
		if (dealerHand.isBust()) {
			System.out.println("Dealer has busted.");
		}
		if (dealerHand.isWin()) {
			System.out.println("Dealer has a perfect 21.");
		}
		if (dealerHand.needHandValue() < 17) {
			dealerHand.addCard(dealer.dealCard());
		}
	}
}
