

import java.io.BufferedReader; //mporting BufferedReader
import java.io.IOException; //importing IOException
import java.io.InputStreamReader; //importing InputStreamReader

public class AlwaysStayPlayer extends Player{ //class AlwaysStayPlayer derived from Player
    public AlwaysStayPlayer(String x){ //accepts the string and overrides Player class
        super(x); //calls the Player constructor
    }
    public int nextAction(){ //overrides nextaction method
        return Player.STAY; //returns the STAY int value from Player
    }
}