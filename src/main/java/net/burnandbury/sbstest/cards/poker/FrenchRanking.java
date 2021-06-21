package net.burnandbury.sbstest.cards.poker;

import net.burnandbury.sbstest.cards.Ranking;

/**
 * French deck card ranks.
 * 
 * @author Helena Tuominen
 */
public enum FrenchRanking implements Ranking {
	ACE("a", 1),
	TWO("2", 2),
	THREE("3", 3),
	FOUR("4", 4),
	FIVE("5", 5),
	SIX("6", 6),
	SEVEN("7", 7),
	EIGHT("8", 8),
	NINE("9", 9),
	TEN("10", 10),
	JACK("j", 11),
	QUEEN("q", 12),
	KING("k", 13);
	
	private final String textValue;
	private final int intValue;
	
	private FrenchRanking(String t, int v)
	{
		textValue = t;
		intValue = v;
	}

	@Override
	public String textValue() {
		return this.textValue;
	}

	@Override
	public int intValue() {
		return this.intValue;
	}

	@Override
	public Integer orderingValue() {
		return this.ordinal();
	}
}