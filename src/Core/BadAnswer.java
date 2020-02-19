package Core;

import Cards.Card;

public class BadAnswer {
    private Card card1;
    private Card card2;
    private String answer;
    private String goodAnswer;

    public BadAnswer(String date){
        String result[] = date.split(";");
        if(result.length == 6){
            card1 = new Card(result[0], result[1]);
            card2 = new Card(result[2], result[3]);
            answer = result[4];
            goodAnswer = result[5];
        }
    }

    public Card getCard1(){
        return card1;
    }

    public Card getCard2(){
        return card2;
    }

    public String getAnswer(){
        return answer;
    }

    public String getGoodAnswer(){
        return goodAnswer;
    }

}
