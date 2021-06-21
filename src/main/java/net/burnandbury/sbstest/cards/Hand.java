package net.burnandbury.sbstest.cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A hand of cards obtained from a deck.
 * 
 * @author Helena Tuominen
 *
 */
public class Hand extends ArrayList<Card> {

	public Hand(List<Card> cards) {
		super(cards);
	}
	
    /**
     * Returns a string representation of this collection.
     * Matches the desired format specified in the  
     * <a href="file:../doc-files/sbs_tech_assessment_code_only.txt">
     * requirements document</a>
     * 
     * <pre>
     *   array('2c', '6d', 'as', 'jh', '10c');
     * </pre>
     *
     * @return a string representation of this collection
     */
    public String toString() {
        Iterator<Card> it = iterator();
        if (! it.hasNext())
            return "array();";

        StringBuilder sb = new StringBuilder();
        sb.append("array(");
        for (;;) {
            Card c = it.next();
            sb.append("'" + c + "'");
            if (! it.hasNext())
                return sb.append(')').toString();
            sb.append(',').append(' ');
        }
    }

	private static final long serialVersionUID = -309601536375172943L;	
}
