/**
 * The Deck class represents a deck of cards that can be drawn from and shuffled.
 * It allows the deck of cards to be shuffled, drawn and added.
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */
import java.util.Random;
import java.util.ArrayList;


class Deck{
    private ArrayList<Card> frontDeck;
    private ArrayList<Card> backDeck;
    

    /**
     * Constructs a deck by copying the given front and back card lists.
     * This constructor is used when a custom deck is passed in.
     * @param newDeck the list of cards for the front deck
     * @param newBack the list of cards for the back deck
     */

 public Deck(ArrayList<Card> newDeck, ArrayList<Card> newBack){
        this.frontDeck = newDeck;
        this.backDeck = newBack;
    }

     /**
     * Constructs a standard UNO deck with both front and back decks initialized.
     * Each color has two copies of each card.
     */
public Deck(){
    //make the front first
    String[] type = {"1","2","3","4","5","6","7","8","9","Flip","Reverse","Skip","Draw1"};
    String[] colour = {"Red", "Blue", "Yellow", "Green"};
    this.frontDeck = new ArrayList<Card>();
    for(int i = 0; i < colour.length; i++){
        for (int j = 0; j< type.length; j++){
            this.frontDeck.add(new Card(colour[i], type[j]));
            // ADD THE CARD AGAIN
            this.frontDeck.add(new Card(colour[i], type[j]));
        }
    }
    this.frontDeck.add(new Card("Wild","colourChange"));
    this.frontDeck.add(new Card("Wild","colourChange"));
    this.frontDeck.add(new Card("Wild","draw2"));
    this.frontDeck.add(new Card("Wild","draw2"));

    // generate back
    String[] typeBack = {"1","2","3","4","5","6","7","8","9","Flip","Reverse","SkipEveryone","Draw5"};
    String[] colourBack = {"Pink", "Teal", "Orange", "Purple"};
    this.backDeck = new ArrayList<Card>();
    for(int i = 0; i < colourBack.length; i++){
        for (int j = 0; j< typeBack.length; j++){
            this.backDeck.add(new Card(colourBack[i], typeBack[j]));
            this.backDeck.add(new Card(colourBack[i], typeBack[j]));
        }
    }
    this.backDeck.add(new Card("Wild","colourChange"));
    this.backDeck.add(new Card("Wild","colourChange"));
    this.backDeck.add(new Card("Wild","drawColour"));
    this.backDeck.add(new Card("Wild","drawColour"));
}

    /**
     * Gets the current front deck.
     * @return the list of cards at the front
     */
    public ArrayList<Card> getFrontDeck(){
        return this.frontDeck;
    }
    
    /**
     * Gets the current back deck.
     * @return the list of cards at the back
     */
    public ArrayList<Card> getBackDeck(){
        return this.backDeck;
    }


    /**
     * Replaces the front deck with a new one.
     * @param newDeck the new front deck
     */
    public void setFrontDeck(ArrayList<Card> newDeck){
        this.frontDeck = newDeck; 
    }


    /**
     * Replaces the back deck with a new one.
     * @param newDeck the new back deck
     */
    public void setBackDeck(ArrayList<Card> newDeck){
        this.backDeck = newDeck;
    }

   /**
     * Returns the number of cards in the front or back deck depending on flip state.
     * @param isFlip true for back deck, false for front deck
     * @return the size of the selected deck
     */
    public int size(boolean isFlip){
        if(isFlip){
            return this.backDeck.size();
        }else{
            return this.frontDeck.size();
        }
        
    }

    /**
     * Converts the entire deck to a string for display.
     * @param isFlip true to show back deck, false for front deck
     * @return string representation of the selected deck
     */
    public String toString(boolean isFlip){
        String out = "";
        if(isFlip==false){
        for(int i = 0; i<this.frontDeck.size(); i++){
            out = out + this.frontDeck.get(i) +", ";
        }
        return out;
    }
    else{
        for(int i = 0; i<this.backDeck.size(); i++){
            out = out + this.backDeck.get(i) +", ";
        }
        return out;
    }
    }

     /**
     * Draws a card from the top of the front or back deck.
     * Removes the drawn card from the deck.
     * @param isFlip true to draw from the back deck, false from the front
     * @return the drawn card, or null if deck is empty
     */
    public Card draw(boolean isFlip){
        if(frontDeck == null || frontDeck.size() == 0){
            return null;
        }


        Card remove = this.frontDeck.get(0);
        Card removeBack = this.backDeck.get(0);
        this.frontDeck.remove(0);
        this.backDeck.remove(0);
        if(isFlip == true){
        return removeBack;
        }
        else{
        return remove;
        }
        } 

    /**
     * Shuffles both the front and back decks using random order.
     * Ensures the order of both decks changes together.
     */
    public void shuffle(){
         Random rand = new Random();
         ArrayList<Card> tempFront= new ArrayList<>(this.frontDeck.size());
         ArrayList<Card> tempBack = new ArrayList<>(this.backDeck.size());
         int help = this.frontDeck.size();
         for (int i = 0; i<help; i++){
            int index = rand.nextInt(help-i);
            tempFront.add(i, this.frontDeck.get(index));
            tempBack.add(i, this.backDeck.get(index));
            this.frontDeck.remove(index);
            this.backDeck.remove(index);

            
        }
            this.frontDeck = tempFront;
            this.backDeck = tempBack;        
    }

    /**
     * Returns the top card from the front or back deck without removing it.
     * @param isFlip true to check back deck, false for front
     * @return the top card
     */
    public Card topCard(boolean isFlip){
        if(isFlip){
            return this.backDeck.get(0);
        }
        return this.frontDeck.get(0);
    }
}

