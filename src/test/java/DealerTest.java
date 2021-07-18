import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private Player player1;
    private Game game;

    @Before
    public void before(){
        player1 = new Player("Andrew");
        deck = new Deck();
        deck.populateDeck();
        dealer = new Dealer(deck, player1);
        game = new Game(player1, dealer, deck);

    }

    @Test
    public void canDealACardToPlayer(){
        dealer.dealPlayerCard(player1);
        assertEquals(1, player1.getHand().size());
    }

    @Test
    public void dealerDealsToSelf(){
        dealer.dealRound(player1, game);
        assertEquals(1, dealer.getHand().size());
    }



    @Test
    public void findHighestHand(){
        Card playersCard1 = new Card(Suit.SPADES, Rank.EIGHT);
        Card playersCard2 = new Card(Suit.DIAMONDS, Rank.NINE);
        Card dealersCard1 = new Card(Suit.CLUBS, Rank.QUEEN);
        Card dealersCard2 = new Card(Suit.DIAMONDS, Rank.TWO);
        player1.addCard(playersCard1);
        player1.addCard(playersCard2);
        dealer.addCard(dealersCard1);
        dealer.addCard(dealersCard2);
        assertEquals("Player has the highest hand", dealer.findHighestHand(player1, dealer));
    }
}
