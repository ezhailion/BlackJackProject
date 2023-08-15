package com.skilldistillery.cardgame.entities;

public enum Rank {
	TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7, "Seven"), 
	EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"), JACK(10, "Jack"), QUEEN(10,"Queen"), KING(10, "King"),
	ACE(11, "Ace");

	private int value;
	private String textRank;
	Rank() {
	}

	Rank(int assignedValue, String textRank) {
		this.value = assignedValue;
		this.textRank = textRank;
	}

	public int getValue() {
		return value;
	}
	public String toString() {
		return textRank;
	}
}
