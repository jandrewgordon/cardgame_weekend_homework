import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Dealer dealer;
    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Andrew");
        dealer = new Dealer(deck, player1);
        game = new Game(player1, dealer, deck);
    }

    @Test
    public void cardsDealtIfRoundPlayed() {
        game.playRound("stick");
        assertNotEquals(52, deck.getCards().size());
    }

    @Test
    public void playerCanGetBlackJack() {
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.SPADES, Rank.KING);
        player1.addCard(card1);
        player1.addCard(card2);
        assertEquals(22, player1.getHandTotal());
    }

    @Test
    public void playerCanStick() {
        Card card1 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        assertEquals(true, game.handleStick(player1, dealer, "stick"));
    }

    @Test
    public void dealerCanStick(){
        Card card1 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        assertEquals(true, game.handleStick(player1, dealer, "stick"));
    }

    @Test
    public void playerCanTwist() {
        Card card1 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        assertEquals(false, game.handleStick(player1, dealer, "twist"));
    }

    @Test
    public void dealerTwistsUnderSixteen() {
        Card card1 = new Card(Suit.SPADES, Rank.FIVE);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        assertEquals(false, game.handleStick(player1, dealer, "stick"));
    }

    @Test
    public void handleStickReturnsTrueIfBothStick() {
        Card card1 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        dealer.addCard(card1);
        dealer.addCard(card2);
        assertEquals(true, game.handleStick(player1, dealer, "stick"));
    }

    @Test
    public void compareIfBothStick() {
        assertNotEquals(null, game.playRound("stick"));
    }

    @Test
    public void testPlayerCanBust() {
        Card card1 = new Card(Suit.SPADES, Rank.SEVEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        Card card3 = new Card(Suit.SPADES, Rank.FIVE);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);
        assertEquals(true, game.playerBust(player1));
    }
}
