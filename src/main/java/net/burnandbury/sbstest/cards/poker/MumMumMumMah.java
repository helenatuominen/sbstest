package net.burnandbury.sbstest.cards.poker;

import java.util.stream.Collectors;

import net.burnandbury.sbstest.cards.Card;
import net.burnandbury.sbstest.cards.Hand;

/**
 * Poker Face utility methods. 
 * @author Helena Tuominen
 *
 */
public class MumMumMumMah {
	/**
	 * Checks if a given hand of cards contains a set of straights, 
	 * boolean checks for aces high or low.
	 * @param hand a hannnnd of carrrrds.
	 * @return result of a convoluted ternary operator.
	 */
	public static boolean isStraight(Hand hand) {
		hand.sort((Card c1, Card c2) -> 
			{ 
				return c1.rank().orderingValue().compareTo(c2.rank().orderingValue()); 
			});

		Integer[] vals = hand.stream().map(c -> c.rank().intValue()).toArray(Integer[]::new);

		return  vals[0] == 1 &&
				  vals[1] != 2 && vals[vals.length-1] != 13 ? false :
					vals[0] == 1 && vals[1] + vals.length -1 == vals[vals.length - 1] + 1 ? true :
						vals[0] + vals.length == vals[vals.length - 1] + 1;
	}

	public static boolean isFlush(Hand hand) {
		String handy = hand.stream().map(c -> c.suit().textValue()).collect(Collectors.joining());
		return !handy.matches("^" + new String( new byte[] { handy.getBytes()[0] }));
	}
}
