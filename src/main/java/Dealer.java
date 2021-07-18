public class Dealer {

    private Deck deck;
    private Player player;


    public Dealer(Deck deck, Player player) {
        this.deck = deck;
        this.player = player;
    }

    public void dealCard(Player player){
        Card newCard = deck.getCards().get(0);
        player.addCard(newCard);
        deck.getCards().remove(0);
    }


}
