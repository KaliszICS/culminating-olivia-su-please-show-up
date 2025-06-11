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


/**
 * Constructs an unshuffled deck of cards 
 * 1 
 */
public Deck(){
    String[] type = {"1","2","3","4","5","6","7","8","9","Flip","Reverse","Skip","Draw1"};
    String[] colour = {"Red", "Blue", "Yellow", "Green"};
    this.deck = new ArrayList<Card>();
    for(int i = 0; i < colour.length; i++){
        for (int j = 0; j< type.length; j++){
            this.deck.add(new Card(colour[i], type[j]));
            // ADD THE CARD AGAIN
            this.deck.add(new Card(colour[i], type[j]));
        }
    }
    this.deck.add(new Card("Wild","colourChange"));
    this.deck.add(new Card("Wild","colourChange"));
    this.deck.add(new Card("Wild","draw2"));
    this.deck.add(new Card("Wild","draw2"));

    String[] typeBack = {"1","2","3","4","5","6","7","8","9","Flip","Reverse","SkipEveryone","Draw5"};
    String[] colourBack = {"Pink", "Teal", "Orange", "Purple"};
    this.deck = new ArrayList<Card>();
    for(int i = 0; i < colourBack.length; i++){
        for (int j = 0; j< typeBack.length; j++){
            this.deck.add(new Card(colourBack[i], typeBack[j]));
            this.deck.add(new Card(colourBack[i], typeBack[j]));
        }
    }
    this.deck.add(new Card("Wild","colourChange"));
    this.deck.add(new Card("Wild","colourChange"));
    this.deck.add(new Card("Wild","drawColour"));
    this.deck.add(new Card("Wild","drawColour"));
}

   

/** 
 * Returns the number of cards in the deck
 * @return the length/size of the deck
 */
    public int size(){
        return this.deck.size();
    }

public ArrayList<Card> getDeck(){
    return this.deck;
}

public String toString(){
    String out = "";
    for(int i = 0; i<this.deck.size(); i++){
        out = out + this.deck.get(i) +", ";
    }
    return out;
}





}