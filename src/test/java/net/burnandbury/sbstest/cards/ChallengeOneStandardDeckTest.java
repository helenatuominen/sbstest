package net.burnandbury.sbstest.cards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.burnandbury.sbstest.ConsoleLogging;
import net.burnandbury.sbstest.cards.Deck;
import net.burnandbury.sbstest.cards.Hand;
import net.burnandbury.sbstest.cards.NotEnoughCardsException;

/**
 * Test the deck methods.
 * 
 * @author Helena Tuominen
 *
 */
public class ChallengeOneStandardDeckTest {

	Deck deck;
	static final Logger logger = ConsoleLogging.getLogger(ChallengeOneStandardDeckTest.class);
	
	@BeforeEach
	public void createDeck() {
		deck = Deck.createDefaultDeck();
	}
	
	/**
	 * Create a function that will generate a random hand of 5 standard playing
	 * cards from a single deck of cards. The hand of cards must be returned in the
	 * format: <pre> 
	 * array('2c', '6d', 'as', 'jh', '10c');
	 * </pre>
	 */
	@Test
	public void testCleanDeckContents() {
		logger.info("Testing a new clean deck.");

		var hand = deck.deal(5);
		logger.info("First hand drawn without shuffle: " + hand.toString());

		assertFalse(deck.containsAll(hand), "Drawn cards should be removed from the deck.");

		assertTrue("array('ac', '2c', '3c', '4c', '5c')".equals(hand.toString()),
				"The is unshuffled and the toString method behaves correctly.");
	}
	
	/**
	 * Confirm the deck returns a different set of results when shuffled from new.
	 */
	@Test
	public void testShuffledDeckContents() {
		
		logger.info("Testing a new shuffled deck.");
		
		deck.shuffle();
		var hand = deck.deal(5);

		logger.info("First hand drawn after shuffle: " + hand.toString());
		 
		assertFalse(deck.containsAll(hand), "Drawn cards should be removed from the deck.");
		
		assertThrows(NotEnoughCardsException.class, () -> {
			while (true) logger.info(deck.deal(5));
		}, "Exception is thrown when remaining size isn't checked.");
	}

}
