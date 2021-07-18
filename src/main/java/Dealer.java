import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private Player player;
    private ArrayList<Card> hand;

    public Dealer(Deck deck, Player player) {
        this.deck = deck;
        this.deck.populateDeck();
        this.player = player;
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card drawCard(){
        return deck.getCards().get(0);
    }

    public void removeCard(){
        deck.getCards().remove(0);
    }

    public void dealPlayerCard(Player player){
        Card newCard = drawCard();
        player.addCard(newCard);
        removeCard();
    }

    public void dealDealerCard(){
        Card newCard = drawCard();
        addCard(newCard);
        removeCard();
    }

    public void dealTableCard(Game game){
        Card newCard = drawCard();
        game.addCard(newCard);
        removeCard();
    }

    public void dealRound(Player player, Game game){
        dealPlayerCard(player);
        dealDealerCard();
        dealPlayerCard(player);
        dealDealerCard();
        dealTableCard(game);
    }

    public String findHighestHand(Player player, Dealer dealer) {
        String result = "";
        int playerHandValue = player.getHandTotal();
        int dealerHandValue = getHandTotal();
        if(playerHandValue > dealerHandValue){
            result = "Player has the highest hand";
        }
        if(playerHandValue < dealerHandValue){
            result = "Dealer has the the highest hand";
        }
        if(playerHandValue == dealerHandValue){
            result = "Tie";
        }

        return result;
    }

    public int getHandTotal() {
        int total = 0;
        for(Card card : getHand()){
            total += card.getRank().getValue();
        }
        return total;
    }

}
