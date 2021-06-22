package net.burnandbury.sbstest.cards.poker;

import java.util.EnumSet;

import net.burnandbury.sbstest.cards.Deck;

/**
 * A standard deck of playing cards using French suits and "aces high" rankings.
 * 
 * @author Helena Tuominen
 *
 */
public class StandardDeck extends Deck {
	
	public enum Aces {
		HIGH,
		LOW,
		BOTH
	}

	public StandardDeck() {
		super(EnumSet.allOf(FrenchSuit.class), EnumSet.allOf(FrenchRanking.class));
	}
	
	private static final long serialVersionUID = -1532833323672049993L;
}
