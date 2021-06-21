package net.burnandbury.sbstest.cards;

/**
 * An exception thrown when the deck is requested to supply more cards than are remaining within it.
 * Users of the Deck must observe the number of remaining cards, or check for this exception - failing
 * to do either can result in upset players and a possible barfight.
 *
 * @author Helena Tuominen
 *
 */
public class NotEnoughCardsException extends RuntimeException {
	
	final static String message = """
				You've asked for too many cards, requested %d but deck has %d.
				""";
	
	public NotEnoughCardsException(Deck deck, int requested)
	{
		super(String.format(message, deck.size(), requested));
	}

	private static final long serialVersionUID = -5777581707901145652L;
}