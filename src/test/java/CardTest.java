import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void Before(){
        card = new Card(Suit.SPADES,Rank.ACE);
    }

    @Test
    public void cardHasSuit(){
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void cardHasRank(){
        assertEquals(Rank.ACE, card.getRank());
    }



}
