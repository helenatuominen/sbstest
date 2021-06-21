package net.burnandbury.sbstest.cards;

/**
 * The basic concept of a Rank for a card, and how it relates to another.
 * This interface is intended for enum implementation and facilitates different rank 
 * methodologies and playing sets, for instance "aces high" or a reduced set such as a piquet pack.
 * 
 * The ranking provides a simplified textual representation, and a numeric value.
 * 
 * @author Helena Tuominen
 *
 */
public interface Ranking {
	
	/** 
	 * @return the textual representation.
	 */
	public String textValue();

	/**
	 * @return the numeric value.
	 */
	public int intValue();
	
	/**
	 * @return the natural ordering value.
	 */
	public Integer orderingValue();
}