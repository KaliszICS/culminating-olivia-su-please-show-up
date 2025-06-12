/**
 * this class represents a game being started and should be able to execute different player's actions 
 * and account for different turns, card effects, and more
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

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

    /**
     * this consctrutor takes in players, opponents, the deck being used, and the pile of cards we're playing in
     * @param player the player
     * @param opponent the computer we're playing against
     * @param deck the deck of cards we're drawing from
     * @param pile the pile of cards we are playing our cards to
     */
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

    /**
     * this method gets the current colour of the top card
     * @return the current colour
     */
    public String getCurrentColour(){
        return this.currentColour;
    }

    /**
     * this method gets the current type of the top card
     * @return the current type
     */
    public String getCurrentType(){
        return this.currentType;
    }

    /**
     * this method gets what turn counter its on
     * @return the current turn
     */
    public int getCurrentTurn(){
        return this.currentTurn;
    }

    /**
     * this method gets the boolean of the players turn
     * @return is it the players turn (true if yes false if no)
     */
    public boolean getIsPlayerTurn(){
        return this.isPlayerTurn;
    }
    /**
     * this method sets/alters the players turn
     * @param set the boolean value being used to alter the players turn
     */
    public void setIsPlayerTurn(boolean set){
        this.isPlayerTurn = set;
    }

    /**
     * this method should check if the player have cards to play 
     * if not, it will draw a card
     * @return a string that tells the player whats happening
     */
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

    /**
     * this method reads what the computer or the player is trying to play and add it to the play pile
     * 
     * @param play the card being played
     * @return a message to tell you what card is played
     */
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

    /**
     * this method checks if you or the computer have run out of cards, therefore winning
     * @return a message telling you if you have won, the computer has won, or no one has.
     */
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