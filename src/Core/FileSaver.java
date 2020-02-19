package Core;

import Cards.Card;

import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {
    private String errorPath = "./badAnswers.txt";
    private FileWriter fw;

    public void saveBadAnswer(Card card1, Card card2, String answer, String goodAnswer){
        try{
            fw = new FileWriter(errorPath, true);
            fw.write(card1.getName() + ";" + card1.getColor() + ";" + card2.getName() + ";" + card2.getColor() + ";" + answer + ";" + goodAnswer + "\r\n");
            fw.close();
        }catch (IOException e){}
    }

    public void clearFile(){
        try{
            fw = new FileWriter(errorPath, false);
            fw.close();
        }catch (IOException e){}
    }
}
