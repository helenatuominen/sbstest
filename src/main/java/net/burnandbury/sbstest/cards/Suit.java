package net.burnandbury.sbstest.cards;

/**
 * A card suit containing a simple textual representation.
 * This interface intended for implementation by enums, 
 * and is to allow any style of suit, for instance French, Spanish, or even Uno.
 * 
 * @author Helena Tuominen
 *
 */
public interface Suit {

	/** 
	 * @return the textual representation of this Suit.
	 */
	public String textValue();
	
	/**
	 * @return the natural ordering value.
	 */
	public Integer orderingValue();
}