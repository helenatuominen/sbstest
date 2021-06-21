package net.burnandbury.sbstest.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.burnandbury.sbstest.cards.poker.StandardDeck;

/**
 * A deck of playing cards.
 * 
 * The contents of the deck are maintained to facilitate a real-world scenario of
 * playing a game of cards. Users must observe the Deck's limited resources.
 * 
 * @author Helena Tuominen
 *
 */
public class Deck extends ArrayList<Card> {
	
	/**
	 * Construct a new deck of cards. Unshuffled and in order of rank and suit.
	 */
	public Deck(Set<? extends Suit> suits, Set<? extends Ranking> ranks) {
		suits.stream().forEach( suit -> {
			ranks.stream().forEach( rank -> {
				this.add(new Card(suit, rank));				
			});
		});
	}
	
	/**
	 * Shuffle the deck.
	 */
	public Deck shuffle() {
		Collections.shuffle(this);
		return this;
	}
	
	/**
	 * Provide a set of cards from the deck, removing them. 
	 * 
	 * @param numberOfCards the number of cards to provide.
 	 */
	public Hand deal(int numberOfCards)
	{
		if (numberOfCards > this.size())
			throw new NotEnoughCardsException(this, numberOfCards);
		
		Hand dealt = new Hand(this.subList(0, numberOfCards));
		this.removeAll(dealt);
		return dealt;
	}
	
	/**
	 * This static method constructs a new Deck, the default being StandardDeck.
	 * 
	 * @return a new StandardDeck.
	 */
	public static Deck createDefaultDeck() {
		return new StandardDeck();
	}
	
	/**
	 * Deal a single hand of cards from a shuffled deck.
	 * This static method constructs a new Deck instance each time it is called,
	 * consequently consecutive calls can return a matching set, on a rare occasion. 
	 * 
	 * @param numberOfCards the number of cards to provide.
	 * @return a set of cards.
	 */
	public static List<Card> getRandomPokerHand(int numberOfCards) {
		return new StandardDeck().shuffle().deal(numberOfCards);
	}
	
	private static final long serialVersionUID = -7290472587627745535L;	
}
