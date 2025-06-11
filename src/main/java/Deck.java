/**
 * The Deck class represents a deck of cards that can be drawn from and shuffled
 * It allows the deck of cards to be shuffled, drawn and added
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

import java.util.ArrayList;


class Deck{
    private ArrayList<Card> frontDeck;
    private ArrayList<Card> backDeck;
    private ArrayList<Card> discardFront;
    private ArrayList<Card> discardBack;
    private ArrayList<Card> shuffleNum;
 

/**
 * Constructs an unshuffled deck of cards 
 * 1 
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
 * Returns the number of cards in the deck
 * @return the length/size of the deck
 */
    public int size(){
        return this.frontDeck.size();
    }

    public ArrayList<Card> getFrontDeck(){
        return this.frontDeck;
    }

    public String toString(){
        String out = "";
        for(int i = 0; i<this.frontDeck.size(); i++){
            out = out + this.frontDeck.get(i) +", ";
        }
        
        for(int i = 0; i<this.backDeck.size(); i++){
            out = out + this.backDeck.get(i) +", ";
        }
        return out;
    }

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

    public void shuffle(){
        for(int i = 0; i <= 108 && this.deck.size; i++){
            shuffleNum.add(i);
        }

        for (int j = 0; j < shuffleNum.size(); j++) {
                int k = (int)(Math.random() * (j + 1));
                    int temp = shuffleNum.get(j);
                    shuffleNum.set(j, shuffleNum.get(k));
                    shuffleNum.set(k, temp);
                    
        }
    }
}

