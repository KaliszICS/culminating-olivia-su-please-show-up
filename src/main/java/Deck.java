class Deck extends card{
    private 
    private String 


    private Deck(){
    String[] type = {""};
    String[] colour = {"Red", "Blue", "Yellow", "Green"};
    this.deck = new Card[108];
    int index = 0;
    for(int i = 0; i < suits.length; i++){
        for (int j = 0; j< names.length; j++){
            this.deck[index] = new Card(type[j], colour[i], j + 1);
            index++;
        }
    }
}

}