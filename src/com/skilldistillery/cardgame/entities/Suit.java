package com.skilldistillery.cardgame.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private String name;

	Suit() {
	}

	Suit(String suitName) {
		this.name = suitName;
	}

	@Override
	public String toString() {
		return name;
	}
}
