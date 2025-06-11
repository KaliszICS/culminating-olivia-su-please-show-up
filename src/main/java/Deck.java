/**
 * The Deck class represents a deck of cards that can be drawn from and shuffled
 * It allows the deck of cards to be shuffled, drawn and added
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */
import java.util.Random;
import java.util.ArrayList;


class Deck{
    private ArrayList<Card> frontDeck;
    private ArrayList<Card> backDeck;
    

 

 public Deck(ArrayList<Card> newDeck, ArrayList<Card> newBack){
        this.frontDeck = (ArrayList)newDeck.clone();
        this.backDeck = (ArrayList)newBack.clone();
    }
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


    public ArrayList<Card> getFrontDeck(){
        return this.frontDeck;
    }
    
    public ArrayList<Card> getBackDeck(){
        return this.backDeck;
    }

    public void setFrontDeck(ArrayList<Card> newDeck){
        this.frontDeck = newDeck; 
    }

    public void setBackDeck(ArrayList<Card> newDeck){
        this.backDeck = newDeck;
    }

    /** 
    * Returns the number of cards in the deck
    * @return the length/size of the deck
    */
    public int size(boolean isFlip){
        if(isFlip){
            return this.backDeck.size();
        }else{
            return this.frontDeck.size();
        }
        
    }

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

    public Card topCard(boolean isFlip){
        if(isFlip){
            return this.backDeck.get(0);
        }
        return this.frontDeck.get(0);
    }
}

