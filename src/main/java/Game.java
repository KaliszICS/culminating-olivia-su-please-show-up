class Game{
    private int currentTurn;
    private String currentColour;
    private String currentType;
    private Rules rules;
    private Player player;
    private Opponent opponent;
    private Deck deck;
    private Deck discardPile;
    private boolean isPlayerTurn;
    private Card topCard;

     public Game(Player player, Opponent opponent, Deck deck, Deck pile) {
        this.currentTurn = 0;
        this.player = player;
        this.opponent = opponent;
        this.deck = deck;
        this.discardPile = pile;
        this.rules = new Rules(false, false, player, opponent, deck);
        this.topCard = deck.draw(false); // Draw the first card
        this.currentColour = topCard.getColour();
        this.currentType = topCard.getType();
        this.isPlayerTurn = true; // Player starts first
        System.out.println("Game started! First card: " + topCard);
    }

    public String getCurrentColour(){
        return this.currentColour;
    }

    public String getCurrentType(){
        return this.currentType;
    }

    public int getCurrentTurn(){
        return this.currentTurn;
    }
    public boolean getIsPlayerTurn(){
        return this.isPlayerTurn;
    }
    public void setIsPlayerTurn(boolean set){
        this.isPlayerTurn = set;
    }

    public String playable(){
        if(this.isPlayerTurn){
            this.isPlayerTurn = !isPlayerTurn;
            for (int i=0; i<9; i++){
                if(this.player.frontHand.get(i).equals(this.topCard)){
                    System.out.println("Select a card to play!");
                    System.out.println(this.player.toString()+" Put in the index for the cards, starting from 0");
                    return "play a card!";

                }
                else{
                    this.player.draw(deck);
                    return "no card to play, draw a card, "+ this.player.toString();
                    
                }
            }
        }
        
            this.isPlayerTurn = true;
            return "Computer's turn, wait.";
        

    }
    public String playCard(Card play){
        if(this.isPlayerTurn){
            this.isPlayerTurn = !this.isPlayerTurn;
            if (play.equals(this.topCard)){
                this.topCard = play;
                return "Card played!"+play.toString();
            }
        }
            this.isPlayerTurn =!this.isPlayerTurn;
            opponent.chooseCardToPlay(this.topCard, this.player);
            this.topCard = opponent.getShouldPlay();
            return "Opoonents turn";

        
    }

    public String gameWon(){
        if(player.size()==0){
            return "You won!";
        }
        else if(this.opponent.size()==0){
            return "Computer won!";
        }
        else{
            return "next turn.";
        }
    }




    
}