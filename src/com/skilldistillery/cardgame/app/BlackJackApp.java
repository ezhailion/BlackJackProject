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
	private int startingInput;
	private int gameInput;
	private boolean running = true;
	private boolean bjRunning = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

	public void launch() {

		while (bjRunning) {
			showMenu();
			startingInput = sc.nextInt();
			sc.nextLine();
			if (startingInput == 1) {
			running = true;
				dealer.getaDeck().shuffleDeck();
				makeStartingHands();
				initialCheck();
				playerTurnChoice();
				dealerTurn();

				pickWinner();
				resetHands();
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
		System.out.println("Dealer's hand: [First card face down]");
		dealer.getaDeck().dealCard(player.getHand());
		player.showHand();
		dealer.getaDeck().dealCard(dealer.getHand());
		dealer.displayDealerHand();
	}

	private void playerTurnChoice() {

		while (running) {
			gameMenu();
			gameInput = sc.nextInt();
			sc.nextLine();
			if (gameInput == 1) {
				dealer.getaDeck().dealCard(player.getHand());
				player.showHand();
				if (((BlackJackHand) player.getHand()).isBust()) {
					System.out.println("Sorry! You bust!");
					running = false;
					break;
				}
			} else if (gameInput == 2) {
				System.out.println();
				System.out.println();
				player.showHand();
				running = false;
			}
		}
	}

	private void dealerTurn() {
		boolean	on = true;
		if (((BlackJackHand) player.getHand()).needHandValue() > 21) {
			dealer.showDHand();
			on = false;
		}
		while (on && ((BlackJackHand) dealer.getHand()).needHandValue() < 17 ) {
				dealer.getHand().addCard(dealer.dealCard());
				dealer.showDHand();
				if (((BlackJackHand) dealer.getHand()).isBust()) {
					System.out.println("Dealer has busted.");
					on = false;
					break;
				}
				if (((BlackJackHand) dealer.getHand()).isWin()) {
					System.out.println("Dealer has a perfect 21.");
					on = false;
					break;
				}
			}
	}

	private void pickWinner() {
		int dealerHandVal = ((BlackJackHand) dealer.getHand()).needHandValue();
		int playerHandVal = ((BlackJackHand) player.getHand()).needHandValue();

		if (dealerHandVal == playerHandVal) {
			System.out.println("Draw!");
		} else if (playerHandVal > dealerHandVal && !((BlackJackHand) player.getHand()).isBust()
				|| ((BlackJackHand) dealer.getHand()).isBust()) {
			System.out.println("You win!" + player.getHand());
			dealer.showDHand();
		} else {
			System.out.print("Dealer wins. " );
			dealer.showDHand();
			player.showHand();
		}
	}

	private void initialCheck() {
		if (((BlackJackHand) dealer.getHand()).isWin()) {
			System.out.println("Dealer has a perfect 21!");
			running = false;
		} else if (((BlackJackHand) player.getHand()).isWin()) {
			System.out.println("You have a perfect 21!");
			running = false;
		}
	}

	private void resetHands() {
		player.getHand().getHandOfCards().removeAll(player.getHand().getHandOfCards());
		dealer.getHand().getHandOfCards().removeAll(dealer.getHand().getHandOfCards());
		if (dealer.deckSize() < 12) {
			dealer.getNewDeck();
		}
	}
}
