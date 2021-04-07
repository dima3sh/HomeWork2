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
public class Text implements TextUnitControl{
    private List<Paragraph> paragraphList = new ArrayList<>();
    private String text;
    private String fileName;

    Text(String fileName) throws IOException{
        this.fileName = fileName;
        BufferedReader in = null;
        final  Logger LOGGER = LoggerFactory.getLogger(Text.class);

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
            sb.append(str+"\n");
        in.close();
        String string = sb.toString();
        createList(string);
    }

    @Override
    public void createList(String text) {
        Pattern p = Pattern.compile("(?<=\\|)(.+?)(?=\\|)");
        Matcher m = p.matcher(text);
        while(m.find()) {
            //System.out.println(m.group());
            paragraphList.add(new Paragraph(m.group()));
        }
    }

    public List getSentences (){
        List<Sentence>  sentenceList= new ArrayList<>();

        for(Paragraph paragraph: paragraphList){
            for(Sentence sentence : paragraph.getSentenceList()){
                sentenceList.add(sentence);
            }
        }
        return sentenceList;
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
        //s += "|";
        return s;
    }
}
