import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Paragraph implements TextUnitControl {
    private List<Sentence> sentenceList = new ArrayList<>();

    Paragraph(String paragraph){
        createList(paragraph);
    }

    @Override
    public void createList(String text) {
        Pattern p = Pattern.compile("(?<=[\\.!\\?])?.+?(\\.\\W)?[\\.!\\?]");// скомпилировали регулярное выражение в представление
        Matcher m = p.matcher(text);
        while(m.find()) {
            //System.out.println(m.group());
            sentenceList.add(new Sentence(m.group()));
        }
    }

    public List<Word> getWords(){
        List<Word> words= new ArrayList<>();
        for(Sentence sentence : sentenceList){
            words.addAll(sentence.getWords());
        }
        return words;
    }

    public String toString(){
        String s = "";
        for(Sentence sentence: sentenceList){
            s +=sentence;
        }
        return s;
    }
}
