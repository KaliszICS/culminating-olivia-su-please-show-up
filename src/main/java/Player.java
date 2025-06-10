
/**
 * 
 * The player class is the player in the game with a name, age, and hands
 * 
 * @author Kelly Fu, Olivia Su, Cindy Pan, Katherine Zhou
 * @version 17.0.1
 */

public class Player{
    private String name;
    private Card[] hand;


/**
* Takes a name and array of cards which should be assigned to the hand
* @param name is the name of player
* @param hand the cards in the player's hand
*/
   public Player(String name, Card[] hand){
        this.name = name;
        if (hand != null){
            this.hand = new Card[hand.length];
            for (int i = 0; i < hand.length; i++){
                this.hand[i] = hand[i];
            }
        }
        else{
            this.hand = new Card[0];
        }
    }

/**
* Takes a name while creating a default empty hand of cards
* @param name is the name of the player
*/
    public Player(String name){
        this.name = name;
        this.hand = new Card[0];
    }

/**
* returns the name of the player
* @return returns the name of the player
*/
    public String getName(){
        return this.name;
    }

/**
* returns the cards in the player's hand
* @return returns the player's hand
*/
    public Card[] getHand(){
        return this.hand;
    }

/**
* returns the number of cards in the player's hand
*@return returns the size of the player's hand
*/
    public int size(){
        return this.hand.length;
    }

/**
* Adds a card from the deck to the hand of the player
* @param deck the deck that the card is taken from
*/
    public void draw(Deck deck){
        Card card = deck.draw();
        if (card == null){
            return;
        }
        Card[] newHand = new Card[this.hand.length + 1];
        for (int i = 0; i < this.hand.length; i++){
            newHand[i] = this.hand[i];
        }
        newHand[this.hand.length] = card;
        this.hand = newHand;
    }

/**
* Removes a card from the hand to the given deck's discard pile
* Returns true if the card exists in hand, false otherwise
* @param card is the card that will be discarded
* @param discardPile is the pile the card will be discarded into
* @return returns true if the card exists and was discarded, false otherwise
*/
    public boolean RemoveCard(Card card, DiscardPile discardPile){
        if (card == null || this.hand.length == 0){
            return false;
        }
        for (int i = 0; i < this.hand.length; i++){
            if (this.hand[i].equals(card)){
                discardPile.addCard(card);
                Card[] newHand = new Card[this.hand.length - 1];
                for (int a = 0, b = 0; a < this.hand.length; a++){
                    if (a != i){
                        newHand[b++] = this.hand[a];
                    }
                }
                this.hand = newHand;
                return true;
            }
        }
        return false;
    }

    public void organize(){

    }


/**
* Will print out their name, and hand of cards
* @return returns the player's name, and hand of cards
*/
    public String toString(){
        String person = this.name;
        if (this.hand.length == 0){
            return person;
        }
        for (int i = 0; i < this.hand.length; i++){
            person += ", " + this.hand[i].toString();
        }
        return person;
    }
}
