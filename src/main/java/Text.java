import lombok.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.*;

@Data
public class Text{
    private List<Paragraph> paragraphList = new ArrayList<>();
    private String text;
    private String fileName;

    Text(String fileName) throws IOException{
        this.fileName = fileName;
        //createList(string);
    }

    public String getFileName(){
        return fileName;
    }

    public List<Word> getWords(){
        List<Word> words= new ArrayList<>();
        for(Paragraph paragraph : paragraphList){
            words.addAll(paragraph.getWords());
        }
        return words;
    }

    public String toString(){
        String s = "";
        for(Paragraph paragraph: paragraphList){
            s+=paragraph;
            s+="\n";
        }

        return s;
    }
}
