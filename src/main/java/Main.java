/**
 * The Main class is the UNO game
 * It makes a deck, lets the players organize their cards, and play the game with UNO flip rules 
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name!");
		String name = sc.nextLine();
		Deck d = new Deck();
		ArrayList<Card> empty = new ArrayList<>();
		Deck pile = new Deck(empty, empty);
		Player pl = new Player(name, d);
		Opponent p = new Opponent("Computer", d);
		Game uno = new Game(pl, p, d, pile);
		boolean win = false;
		

		while (win ==false){

	
		if(uno.getIsPlayerTurn()){
		System.out.println(uno.playable());
		int index = sc.nextInt();
		
		uno.playCard(pl.backHand.get(index));
		uno.gameWon();
		
		}
		else{
			System.out.println("Computers turn!");
			uno.playCard(null);
			uno.gameWon();
		}
	
	
	
	}


		

	}

}
