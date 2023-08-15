package com.skilldistillery.cardgame.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.entities.BlackJackHand;
import com.skilldistillery.cardgame.entities.Dealer;
import com.skilldistillery.cardgame.entities.Deck;
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
		int startingInput;
		int gameInput;
		showMenu();
		startingInput = sc.nextInt();
		sc.nextLine();
		if (startingInput == 1) {
			dealer.getaDeck().shuffleDeck();
			makeStartingHands();
			gameMenu();
			gameInput = sc.nextInt();
			sc.nextLine();
			playerTurnChoice(gameInput);
			while (gameInput == 1) {
				gameMenu();
				gameInput = sc.nextInt();
				sc.nextLine();
				playerTurnChoice(gameInput);
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

		dealer.getaDeck().dealCard(player.getHand());
		player.showHand();
		dealer.getaDeck().dealCard(dealer.getHand());
		System.out.println("Dealer's hand: [First card face down");
		dealer.getaDeck().dealCard(player.getHand());
		player.showHand();
		System.out.println();
		dealer.getaDeck().dealCard(dealer.getHand());
		dealer.displayDealerHand();
	}

	private void playerTurnChoice(int input) {
		if (input == 1) {
			dealer.getaDeck().dealCard(player.getHand());
			player.showHand();
			if (((BlackJackHand) player.getHand()).isBust()) {
				System.out.println("Sorry! You bust!");
			} else if (((BlackJackHand) player.getHand()).isWin()) {
				System.out.println("You win with a perfect 21!");
			}
		} else if (input == 2) {
			dealerTurn();
		}

	}

	private void dealerTurn() {
		while (((BlackJackHand) dealer.getHand()).needHandValue() < 17) {
			dealer.getHand().addCard(dealer.dealCard());
			dealer.showHand();
			if (((BlackJackHand) dealer.getHand()).isBust()) {
				System.out.println("Dealer has busted.");
				break;
			}
			if (((BlackJackHand) dealer.getHand()).isWin()) {
				System.out.println("Dealer has a perfect 21.");
				break;
			}
		}
	}
}
