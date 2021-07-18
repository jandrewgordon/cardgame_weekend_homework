import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;

    @Before
    public void before(){
        player1 = new Player("Andrew");
    }

    @Test
    public void canCheckHandTotal(){
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.EIGHT);
        player1.addCard(card1);
        player1.addCard(card2);
        assertEquals(19, player1.getHandTotal());
    }
}
