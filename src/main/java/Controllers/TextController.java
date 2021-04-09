package Controllers;

import TextUnits.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Cпросить мол если наш файл не может быть открыт, что нужно сделать
public class TextController{
    private Text text;

    public TextController(Text text){
        this.text = text;
    }

    public String readFile() throws IOException{

        String fileName = text.getFileName();
        BufferedReader in = null;
        final Logger LOGGER = LoggerFactory.getLogger(Text.class);

        try {
            in = new BufferedReader(new FileReader((fileName)));
        }catch(FileNotFoundException e){
            LOGGER.warn("Could not open " + fileName);
            throw e;
        }catch(Exception e){
            try{
                in.close();
                LOGGER.info("File(" + fileName + ") is closed ");
            }catch(IOException e2){
                LOGGER.warn("Could not close " + fileName);
                throw e2;
            }
            throw e;
        }

        LOGGER.info("File(" + fileName + ") is open");

        String str;
        StringBuilder sb = new StringBuilder();
        while((str = in.readLine()) != null)
            sb.append(str);
        in.close();
        return sb.toString();
    }

    /*public List getParagraphs() {
        List<UnitText> paragraphList = new ArrayList<>();
        Pattern p = Pattern.compile("(?<=\\|)(.+?)(?=\\|)");
        Matcher m = p.matcher(text.toString());

        while(m.find()) {
            paragraphList.add(new Paragraph(m.group()));
        }
        return paragraphList;
    }

    public List getSentences (){
        List<UnitText>  sentenceList= new ArrayList<>();
        List<UnitText> paragraphs = getParagraphs();
        for(UnitText paragraph: paragraphs){
            for(UnitText sentence : paragraph.getUnitTextList()){
                sentenceList.add(sentence);
            }
        }
        return sentenceList;
    }

    /*public List getWords(){
        List<UnitText> words= new ArrayList<>();
        List<Paragraph> paragraphs = getParagraphs();
        for(Paragraph paragraph :  paragraphs){
            words.addAll(paragraph.getWords());
        }
        return words;
    }*/


    public void createUnitTextList(String textStr) {
        List<UnitText> paragraphList = new ArrayList<>();
        Pattern p = Pattern.compile("\\|\\|?(.+?)\\|");
        Matcher m = p.matcher(textStr);
        ParagraphController paragraphController;

        while(m.find()) {
            //System.out.println(m.group(1));
            Paragraph paragraph = new Paragraph(m.group(1));
            paragraphController = new ParagraphController(paragraph);
            paragraphList.add(paragraph);
        }

        text.setUnitTextList(paragraphList);
    }
}
