package net.burnandbury.sbstest.cards;

/**
 * A playing card having a suit and a rank.
 *
 * @author Helena Tuominen
 * 
 */
public record Card(Ranking rank, Suit suit) implements Comparable<Card> {
	
	@Override
	public int compareTo(Card card) {
		var result = this.suit.orderingValue().compareTo(card.suit.orderingValue());				
		if (result == 0)
			result = this.rank.orderingValue().compareTo(card.rank.orderingValue());
		
		return result;
	}
	
	@Override	
	public String toString() {
		return rank.textValue() + suit.textValue();
	}
}