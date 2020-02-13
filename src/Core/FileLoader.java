package Core;

import Cards.Card;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public List<Event> loadFile(String filePath){
        List<Event> list = new ArrayList<>();
        filePath = "./charts/" + filePath;
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            String s;
            s = fileReader.readLine();
            do{
                list.add(new Event(s));
                s = fileReader.readLine();
            }while(s != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try{
                    fileReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
