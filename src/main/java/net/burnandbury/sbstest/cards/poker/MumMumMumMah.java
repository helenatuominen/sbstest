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
	 * @param h a hannnnd of carrrrds.
	 * @return result of a convoluted ternary operator.
	 */
	public static boolean isStraight(Hand h) {
		h.sort((Card c1, Card c2) -> 
			{ 
				return c1.rank().orderingValue().compareTo(c2.rank().orderingValue()); 
			});

		Integer[] v = h.stream().map(c -> c.rank().intValue()).toArray(Integer[]::new);

		return  v[0] == 1 &&
				  v[1] != 2 && v[v.length-1] != 13 ? false :
					v[0] == 1 && v[1] + v.length -1 == v[v.length - 1] + 1 ? true :
						v[0] + v.length == v[v.length - 1] + 1;
	}

	public static boolean isFlush(Hand hand) {
		String h = hand.stream().map(c -> c.suit().textValue()).collect(Collectors.joining());
		return !h.matches("^" + new String( new byte[] { h.getBytes()[0] }));
	}
}
