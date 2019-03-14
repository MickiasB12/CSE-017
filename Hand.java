

import java.util.ArrayList;

public class Hand{
    private ArrayList<Card> cards;

   public Hand(){
        Deck deck = new Deck();    
        cards = new ArrayList<Card>();
        for(int i = 0; i < 2; i++){
            cards.add(deck.dealCard());
            
        }
   }
   @Override
   public String toString(){
        String x = "(";
        for(int i = 0; i < cards.size(); i++){
            x += cards.get(i).toString();
            x += " ";
        }
        x += ")";
        return x;
   }
   public int hardValue(){
        int sum = 0;

        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRank() >= 11){
                sum += 10;
            }
            else{
                sum += cards.get(i).getRank() + 1;
            }
            
       }
       return sum;
       
   }
   public int softValue(){
    
    int sum = 0;

    for(int i = 0; i < cards.size(); i++){
        if(cards.get(i).getRank() >= 11){
            sum += 10;
        }
        else if(cards.get(i).getRank() == 0){
            sum += 11;
        }
        else{
            sum += cards.get(i).getRank() + 1;
        }
    
   }
        return sum;
   
   }
   public void acceptCard(Card c){
       if(c == null){
           throw new IllegalArgumentException("Card cannot be null");
       }
       else{
           cards.add(c);
       }
   }
}