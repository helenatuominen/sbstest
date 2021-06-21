package net.burnandbury.sbstest.cards.poker;

import java.util.stream.Collectors;

import net.burnandbury.sbstest.cards.Card;
import net.burnandbury.sbstest.cards.Hand;

public class MumMumMumMah {
	
	Hand hand;
	
	public MumMumMumMah(Hand hand) {
		this.hand = hand;
	}
	
	public static boolean isStraight(Hand hand) {
		hand.sort((Card c1, Card c2) -> { return c1.compareTo(c2); } );

		Integer[] vals = (Integer[])hand.stream().map(c -> c.rank().intValue()).toArray();

		return 
				vals[0] == 1 && 
				vals[1] != 2 && 
				vals[vals.length-1] != 13 ? 
						false :
							vals[0] + vals.length != vals[vals.length - 1] + 1;
	}
	
//	static <Card> IWannaHoldEm() { return hand.stream(); }
//	
//	static class Gaga {
//		LikeTheyDoInTexasPlease	
//	}
//	
//	
//	FoldEmLetEmHitMe
//	RaiseItBabyStayWithMe
//	ILoveIt
	
//	Love game intuition, play the cards with spades to start
//	And after he's been hooked, I'll play the one that's on his heart
	
	
	
	public static boolean isFlush(Hand hand) {
		String handy = hand.stream().map(c -> c.suit().textValue()).collect(Collectors.joining());
		return handy.matches("^" + new String( new byte[] { handy.getBytes()[0] }));
	}
}
