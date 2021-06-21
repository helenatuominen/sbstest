package net.burnandbury.sbstest.cards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.burnandbury.sbstest.ConsoleLogging;

/**
 * Test the deck methods.
 * 
 * @author Helena Tuominen
 *
 */
public class StandardDeckTest {

	Deck deck;
	static final Logger logger = ConsoleLogging.getLogger(StandardDeckTest.class);
	
	@BeforeEach
	public void createDeck() {
		deck = Deck.createDefaultDeck();
	}
	
	@Test
	public void testCleanDeckContents() {
		logger.info("Testing a new clean deck.");

		Hand hand = deck.deal(5);
		logger.info("First hand drawn without shuffle: " + hand.toString());

		assertFalse(deck.containsAll(hand), "Drawn cards should be removed from the deck.");

		assertTrue("array('ac', '2c', '3c', '4c', '5c')".equals(hand.toString()),
				"The is unshuffled and the toString method behaves correctly.");
	}
	
	@Test
	public void testShuffledDeckContents() {
		
		logger.info("Testing a new shuffled deck.");
		
		deck.shuffle();
		List<Card> hand = deck.deal(5);

		logger.info("First hand drawn after shuffle: " + hand.toString());
		 
		assertFalse(deck.containsAll(hand), "Drawn cards should be removed from the deck.");
		
		assertThrows(NotEnoughCardsException.class, () -> {
			while (true) logger.info(deck.deal(5));
		}, "Exception is thrown when remaining size isn't checked.");
	}

}
