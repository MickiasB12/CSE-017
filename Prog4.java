
/*CSE17 
Mickias Bekele
mib222
Program Description: The purpose of this program is to perform blackjack
card game using multiple classes (including derived and abstract classes)
Program #4*/


import java.util.*; //importing the necessary objects
import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
public class Prog4{ /* class prog4*/
 
    private static Deck deck = new Deck(); //declaring deck 
    
    //main method required for every java program
    public static void main(String[] args) {
        deck.shuffle(); //calling the shuffling method
        Dealer dealer = new Dealer("Danny the Dealer"); //
        ArrayList<Player> players = new ArrayList<>(); //declaring an array of Player object
        for(Player player : players) { //for the other players
            System.out.printf("Player %s\n", player.getName()); //shows the player's name
            for (int i=0; i < 2; ++i) {
                Card card = deck.dealCard();
                System.out.printf("...gets a %s\n", card); //randomly generated Card objects will be called
                player.acceptCard(card); //adds the cards to array in other classes
            } 
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //using BufferedReader as a Scanner object
        System.out.println("What is your name? "); 
        String name = null;
        try {
            name = in.readLine(); //storing the players name
        } catch (IOException ex) {
            name = "Bozo";
        }
        if (name.length() == 0)
            name = "Bozo";

        players.add(new AlwaysStayPlayer("Always Stay Alan")); //player Alan
        players.add(new AlwaysStayPlayer("Always Stay Alice")); //player Alice
        players.add(new HitTil21Player("Hit Til 21 Harry")); //player Harry
        players.add(new HitTil21Player("Hit Til 21 Helen")); //player Helen
        players.add(new RealPlayer(name)); //user 
        
    

        for (Player player : players) { //for calling the playhand metho
            playHand(player);
        }
        playHand(dealer); //calling playerhand for dealer
        if (dealer.handValue() > 21) {
            for (Player player : players) { //for listing out the player's list
                if (player.handValue() <= 21) { //if the the value is less than 21
                    System.out.println(player.getName() + " Wins! ");
                 
                }
            }
        } else {
            for (Player player : players) {
                if (player.handValue() <= 21 && player.handValue() >
                    dealer.handValue()) {
                    System.out.println(player.getName() +" Wins! "); //if the player's value is less than 21 and still greater than dealer's hand
                    System.out.println();
                }
            }
        }
    }
    public static void playHand(Player player) {
        while (player.nextAction() == Player.HIT) { //if the person enter h
            System.out.printf("%s Hits\n", player.getName()); //lists out the player's name
            Card card = deck.dealCard();
            System.out.printf("...gets a %s\n", card); //randomly generated Card objects
            player.acceptCard(card);
        }
        System.out.printf("%s Stays\n", player.getName()); //when the player stops
        if (player.handValue() > 21) { //if the value is greater than 21
            System.out.printf("%s is busted!\n", player.getName());
        }
        System.out.println();
    }
}
