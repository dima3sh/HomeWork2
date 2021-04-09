package TextUnits;

import TextUnits.Sentence;
import TextUnits.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Paragraph extends UnitText {
    String paragraphText;
    public Paragraph(String paragraphText){
        this.paragraphText = paragraphText;
    }

    public String getParagraphText(){
        return paragraphText;
    }


   /* public List<UnitText> getWords(){
        List<Word> words= new ArrayList<>();
        for(Sentence sentence : sentenceList){
            words.addAll(sentence.getWords());
        }
        return words;
    }*/

    public String toString(){
        String s = "";
        for(UnitText sentence: getUnitTextList()){
            s +=sentence;
        }
        return s;
    }
}
