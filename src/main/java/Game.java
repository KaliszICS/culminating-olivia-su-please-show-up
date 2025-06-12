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

    




    
}