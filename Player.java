

public abstract class Player{
    public static final int HIT = 1;
    public static final int STAY = 0;
    protected Hand hand;
    protected String name;
    
    public Player(String y){
        name = y;
        hand = new Hand();
    }
    public String getName(){
        return name;
    }

    public void acceptCard(Card card){
        hand.acceptCard(card);

    }
    public int handValue(){
        int x;
        if(hand.hardValue() <= 21){
            x = hand.softValue();
        }
        else{
            x = hand.hardValue();
        }
        return x;
        
    }
    public abstract int nextAction();
    
    @Override
    public String toString(){
        String x = hand.toString();
        return x;
    }

}