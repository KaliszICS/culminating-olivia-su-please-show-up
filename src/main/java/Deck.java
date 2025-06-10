import java.util.ArrayList;

class Deck{
    private ArrayList<Card> deck;

public Deck(){

    String[] type = {"1","2","3","4","5","6","7","8","9","Flip","Reverse","Skip","Draw"};
    String[] colour = {"Red", "Blue", "Yellow", "Green"};
    this.deck = new ArrayList<Card>();
    for(int i = 0; i < colour.length; i++){
        for (int j = 0; j< type.length; j++){
            this.deck.add(new Card(colour[i], type[j]));
            this.deck.add(new Card(colour[i], type[j]));
        }
    }
    this.deck.add(new Card("Wild","Wild"));
    this.deck.add(new Card("Wild","Wild"));
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