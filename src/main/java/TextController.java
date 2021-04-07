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
public class TextController {
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
            sb.append(str+"\n");
        in.close();
        return sb.toString();
    }

    public List getParagraphs() {
        List<Paragraph> paragraphList = new ArrayList<>();
        Pattern p = Pattern.compile("(?<=\\|)(.+?)(?=\\|)");
        Matcher m = p.matcher(text.toString());

        while(m.find()) {
            paragraphList.add(new Paragraph(m.group()));
        }
        return paragraphList;
    }

    public List getSentences (){
        List<Sentence>  sentenceList= new ArrayList<>();
        List<Paragraph> paragraphs = getParagraphs();
        for(Paragraph paragraph: paragraphs){
            for(Sentence sentence : paragraph.getSentenceList()){
                sentenceList.add(sentence);
            }
        }
        return sentenceList;
    }
}
