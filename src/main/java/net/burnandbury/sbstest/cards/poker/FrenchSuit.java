package net.burnandbury.sbstest.cards.poker;

import net.burnandbury.sbstest.cards.Suit;

/**
 * All French card suits in order of lowest to highest ranking.
 * 
 * @author Helena Tuominen
 */
public enum FrenchSuit implements Suit {
	CLUB("c"),
	DIAMOND("d"),
	HEART("h"),
	SPADE("s");
	
	private final String textValue;
	
	private FrenchSuit(String t)
	{
		textValue = t;
	}
	
	@Override
	public String textValue() {
		return this.textValue;
	}
	
	@Override
	public Integer orderingValue() {
		return this.ordinal();
	}
}