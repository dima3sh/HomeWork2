package TextUnits;

import TextUnits.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends UnitText{
    String wordText;

    public Word(String word){
        this.wordText = word;
    }

    public String getWordText(){
        return wordText;
    }

    public String toString(){
        String s = "";
        for(UnitText symbol: getUnitTextList()){
            s+=symbol;
        }
        return s;
    }
}
