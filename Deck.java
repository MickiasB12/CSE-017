
import java.util.Random;

public class Deck{
    private Card[] cards;
    private int nextCard;
    private Random rand;

    public Deck(){
        rand = new Random();
        cards = new Card[52];
        int cardCt = 1;
        for(int i = 0; i < 52; i++){
            cards[i] = new Card(cardCt);
            cardCt++;
        }
        nextCard = 0;
    }
    public void shuffle(){
        Card temp;
        int randi;
        for(int i = 0; i < 52; i++){
            randi = rand.nextInt(i+1);
            temp = cards[i];
            cards[i] = cards[randi];
            cards[randi] = temp;

        }
        nextCard = 0;

    }
    public Card dealCard(){
        if(nextCard == cards.length){
            shuffle();
            
        }
        
        return cards[nextCard++];
        
    }
    public int getCardsRemaining(){
        return cards.length - nextCard;
    }

}