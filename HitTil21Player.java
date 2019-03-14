

public class HitTil21Player extends Player{
    public HitTil21Player(String x){
        super(x);
    }
    public int nextAction(){
        if(hand.hardValue() < 21 && hand.softValue() < 21){
            return Player.HIT;
        }
        else{
            return Player.STAY;
        }

    }
}