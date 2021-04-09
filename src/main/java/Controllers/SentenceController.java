package Controllers;

import TextUnits.Paragraph;
import TextUnits.Sentence;
import TextUnits.UnitText;
import TextUnits.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceController implements TextUnitControl {
    private Sentence sentence;

    public SentenceController(Sentence sentence){
        this.sentence = sentence;
        createUnitTextList();
    }

    @Override
    public void createUnitTextList() {
        List<UnitText> wordList = new ArrayList<>();
        Pattern p = Pattern.compile(".+?\\)?(\\..+?)?[\\.\\?!(?=\\s)]");
        Matcher m = p.matcher(sentence.getSentenceText());
        WordController wordController;
        while(m.find()) {
            //System.out.println(m.group());
            String wordText = m.group();
            wordText = wordText.trim();
            Word word = new Word(wordText);
            wordController = new WordController(word);
            wordList.add(word);
        }
        sentence.setUnitTextList(wordList);
    }
}
