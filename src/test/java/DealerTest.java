import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private Player player1;

    @Before
    public void before(){
        player1 = new Player("Andrew");
        deck = new Deck();
        deck.populateDeck();
        dealer = new Dealer(deck, player1);

    }

    @Test
    public void canDealACardToPlayer(){
        dealer.dealCard(player1);
        assertEquals(1, player1.getHand().size());
    }
}
