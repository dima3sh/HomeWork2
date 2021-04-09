package TextUnits;

import TextUnits.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence extends UnitText{
    private String sentenceText;

    public Sentence(String sentence){
        this.sentenceText = sentence;
    }

    public String getSentenceText(){
        return sentenceText;
    }

    /*public int getWordCount(){
        return wordList.size();
    }*/

    /*public List getWords(){
        List<Word> words = new ArrayList<>();
        Pattern p = Pattern.compile("^[\\w[а-яА-Я]]+(?=[,\\?\\!\\.])?");

        for(Word word : wordList){
            Matcher m = p.matcher(word.toString());
            if(m.find()){
                words.add(new Word(m.group()));
            }
        }
        return words;
    }*/

    public String toString(){
        String s = "";
        for(UnitText word: getUnitTextList()){
            s+=word;
            s+=" ";
        }
        return s;
    }

}
