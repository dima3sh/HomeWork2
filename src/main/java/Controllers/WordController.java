package Controllers;

import TextUnits.Paragraph;
import TextUnits.Symbol;
import TextUnits.UnitText;
import TextUnits.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordController implements TextUnitControl{
   private Word word;

    public WordController(Word word){
        this.word = word;
        createUnitTextList();
    }

    @Override
    public void createUnitTextList() {
        List<UnitText> symbolList = new ArrayList<>();
        Pattern p = Pattern.compile(".");
        Matcher m = p.matcher(word.getWordText());
        while(m.find()) {
            //System.out.println(m.group());
            symbolList.add(new Symbol(m.group()));
        }
        word.setUnitTextList(symbolList);
    }
}
