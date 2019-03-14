
public class Card{
    private int cardNumber; //declaring an int value 
    private static String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; //assigning the ranks in the rank array
    private static String[] suit = {"S", "H", "C", "D"}; //assigning the suits in the suit array
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;
    public static final int ACE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    public static final int SIX = 5;
    public static final int SEVEN = 6;
    public static final int EIGHT = 7;
    public static final int NINE = 8;
    public static final int TEN = 9;
    public static final int JACK = 10;
    public static final int QUEEN = 11;
    public static final int KING = 12; 
    
    public Card(int n){ //constructor for Card class
        cardNumber = n; //assgning the value of n to cardNumber
    }
    //initializing the cardnumber field
    public int getCardNumber(){ //returning the value of cardNumber
        return this.cardNumber;
    }

    public int getRank(){ //for the Rank value
        int n = cardNumber %13;
        return n;
    }
    public int getSuit(){ //for the suit value
        int x = cardNumber/13;
        return x;

    }
    public String getRankName(){ //getting the rank's name from the rank value
        int x = getRank();
        String rankName = rank[x];
        return rankName;
    }
    public String getSuitName(){ //getting the suits name from suit value
        int y = getSuit();
        String suitName = suit[y];
        return suitName;
    }
    @Override
    public String toString(){ 
        String x = getRankName();
        String y = getSuitName();
        String t = x + y; //putting both the rank's name and suit name together
        return t;
    }
    
    public boolean equals(Card x){
        if(cardNumber == x.getCardNumber()){
            return true;
        }
        else{
            return false;
        }
        
    }

}