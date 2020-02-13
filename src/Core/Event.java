package Core;

public class Event {
    private String card1;
    private String card2;
    private String correctChoose;
    private boolean isSame;

    public Event(String date){
        String result[] = date.split(";");
        if(result.length == 4){
            card1 = result[0];
            card2 = result[1];
            isSame = result[2].equals("s");
            correctChoose = result[3];
        }
    }

    public String getCard1() {
        return card1;
    }

    public String getCard2() {
        return card2;
    }

    public String getCorrectChoose() {
        return correctChoose;
    }

    public boolean isSame() {
        return isSame;
    }

    public boolean checkDecision(String decision){
        return correctChoose.equals(decision);
    }
}
