/**
 * The Card class represents the card's colour and type
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

class Card{

    private String colour;
    private String type;

/**
 * Constructs a card object with the given name, suit, value
 * @param type the type of the card(eg. 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Flip, Reverse, Skip, Draw)
 * @param colour the colour of the card (eg. Yellow, Green, Red, Blue)
 */

    public Card (String colour, String type){
        this.colour = colour;
        this.type = type;
    }

/**
 * Gets the card's colour
 * @return the card's colour
 */
    public String getColour(){
        return this.colour;
    }

/**
 * Gets the card's type
 * @return the card's type
 */
    public String getType(){
        return this.type;
    }

/**
 * Returns its full form (e.g. "Red Flip" if the colour is "Red" and the type is "Flip")
 */
    @Override
    public String toString(){
        return this.colour + " " + this.type;
    }

/**
 * Checks if the two cards have the same type or colour
 */
    public boolean equals(Object obj){
    if (obj == null || obj.getClass() != this.getClass()){
        return false;
    }
    Card card = (Card) obj;
        if (this.colour.equals(card.colour) || this.type.equals(card.type)){
            return true;
        }
        else{
            return false;
        }
    }
}