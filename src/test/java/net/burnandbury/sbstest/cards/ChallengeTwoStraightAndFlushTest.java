package net.burnandbury.sbstest.cards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.burnandbury.sbstest.cards.poker.FrenchRanking;
import net.burnandbury.sbstest.cards.poker.FrenchSuit;
import net.burnandbury.sbstest.cards.poker.MumMumMumMah;

public class ChallengeTwoStraightAndFlushTest {
		
	@Test
	void doubleUporQuitDoubleStakeOrSplit() {
		var motörhead = new ArrayList<Card>();
		// Low straight flush, I don't share your greed, the only card I need is...
		motörhead.add(new Card(FrenchRanking.ACE, FrenchSuit.SPADES));
		motörhead.add(new Card(FrenchRanking.TWO, FrenchSuit.SPADES));
		motörhead.add(new Card(FrenchRanking.FIVE, FrenchSuit.SPADES));
		motörhead.add(new Card(FrenchRanking.FOUR, FrenchSuit.SPADES));
		motörhead.add(new Card(FrenchRanking.THREE, FrenchSuit.SPADES));
		var aceOfSpades = new Hand(motörhead);
		assertTrue(MumMumMumMah.isStraight(aceOfSpades), "A low straight. " + motörhead);
		assertTrue(MumMumMumMah.isFlush(aceOfSpades), "Flush of spades with ace low. RIP Lemmy. " + motörhead);
	}
	
	@Test
	void Pushing_up_the_ante_I_know_you_gotta_see_me() {
		// Aces and eights, queen kicker. Read em and weep
		var again = new Card[] {
			new Card(FrenchRanking.ACE, FrenchSuit.CLUBS),
			new Card(FrenchRanking.ACE, FrenchSuit.SPADES),
			new Card(FrenchRanking.EIGHT, FrenchSuit.SPADES),
			new Card(FrenchRanking.EIGHT, FrenchSuit.CLUBS),
			new Card(FrenchRanking.QUEEN, FrenchSuit.CLUBS)
		};
		var deadMans = new Hand(again);
		assertFalse(MumMumMumMah.isStraight(deadMans), "Read em and weep, Dead Man's Hand again.. shouldn't be straight. " + deadMans);

		// Middling straight.
		var andGamblingsForFools = new Card[] {
			new Card(FrenchRanking.EIGHT, FrenchSuit.CLUBS),
			new Card(FrenchRanking.FIVE, FrenchSuit.HEARTS),
			new Card(FrenchRanking.SIX, FrenchSuit.HEARTS),
			new Card(FrenchRanking.SEVEN, FrenchSuit.SPADES),
			new Card(FrenchRanking.NINE, FrenchSuit.DIAMONDS)
		};
		var youKnowImBornToLose = new Hand(andGamblingsForFools);
		assertTrue(MumMumMumMah.isStraight(youKnowImBornToLose), """
				Middling straight.. but that's the way I like it baby, I don't want to live forever! 
				"""
					+ youKnowImBornToLose);
	}
	
	@Test
	void I_see_it_in_your_eyessss__take_one_look_and_die() {
		// Aces high.
		var youKnowItsGonnaBeTheAceOfSpades = new Card[] {
			new Card(FrenchRanking.ACE, FrenchSuit.SPADES),
			new Card(FrenchRanking.QUEEN, FrenchSuit.CLUBS),
			new Card(FrenchRanking.KING, FrenchSuit.DIAMONDS),
			new Card(FrenchRanking.JACK, FrenchSuit.HEARTS),
			new Card(FrenchRanking.TEN, FrenchSuit.DIAMONDS)
		};
		var theOnlyYhingYouSee = new Hand(youKnowItsGonnaBeTheAceOfSpades);
		assertTrue(MumMumMumMah.isStraight(theOnlyYhingYouSee), "Aces high. " + theOnlyYhingYouSee);
	}

}
