package com.skilldistillery.cardgame.entities;

import java.util.Objects;

public class Card {
private Suit aSuit;
private Rank aRank;
	
	private Card(){
		
	}
	public Suit getaSuit() {
		return aSuit;
	}
	public void setaSuit(Suit aSuit) {
		this.aSuit = aSuit;
	}
	public Rank getaRank() {
		return aRank;
	}
	public void setaRank(Rank aRank) {
		this.aRank = aRank;
	}
	public Card(Rank theRank, Suit theSuit){
	this.aRank = theRank;
	this.aSuit = theSuit;
	}
	public int getValue(String card){
		int numValOfCard = Integer.parseInt(card);
		return numValOfCard;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aRank, aSuit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return aRank == other.aRank && aSuit == other.aSuit;
	}
	@Override
	public String toString() {
		return aRank + " of " + aSuit;
	}
}
