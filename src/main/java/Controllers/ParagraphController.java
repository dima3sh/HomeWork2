package Controllers;

import TextUnits.Paragraph;
import TextUnits.Sentence;
import TextUnits.Text;
import TextUnits.UnitText;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphController implements TextUnitControl {
    private Paragraph paragraph;

    public ParagraphController(Paragraph paragraph){
        this.paragraph = paragraph;
        createUnitTextList();
    }

    @Override
    public void createUnitTextList() {
        List<UnitText> sentenceList = new ArrayList<>();
        Pattern p = Pattern.compile("(?<=[\\.!\\?])?.+?(\\.\\W)?[\\.!\\?]");
        //Pattern p = Pattern.compile(".?");
        Matcher m = p.matcher(paragraph.getParagraphText());
        SentenceController sentenceController;

        while(m.find()) {
            //System.out.println(m.group());
            Sentence sentence = new Sentence(m.group());
            sentenceController = new SentenceController(sentence);
            sentenceList.add(sentence);
        }
        paragraph.setUnitTextList(sentenceList);
    }

}
