class Card{

    private String colour;
    private String type;

    public Card (String colour, String type){
        this.colour = colour;
        this.type = type;
    }

    public String getColour(){
        return colour;

    }

    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return this.colour + " " + this.type;
    }

    public boolean equals(Object obj){
    if (obj == null || obj.getClass() != this.getClass()){
        return false;
    }
    Card card = (Card) obj;
        if (this.colour.equals(card.colour) && this.type.equals(card.type)){

        }
    }
}