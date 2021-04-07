import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements TextUnitControl{
    private List<Word> wordList = new ArrayList<>();

    Sentence(String sentence){
        createList(sentence);
    }

    @Override
    public void createList(String text) {
        Pattern p = Pattern.compile(".+?\\)?(\\..+?)?[\\.\\?!(?=\\s)]");
        Matcher m = p.matcher(text);
        while(m.find()) {
            //System.out.println(m.group());
            String word = m.group();
            word = word.trim();
            wordList.add(new Word(word));
        }
    }

    public int getWordCount(){
        return wordList.size();
    }

    public List getWords(){
        List<Word> words = new ArrayList<>();
        Pattern p = Pattern.compile("^[\\w[а-яА-Я]]+(?=[,\\?\\!\\.])?");

        for(Word word : wordList){
            Matcher m = p.matcher(word.toString());
            if(m.find()){
                words.add(new Word(m.group()));
            }
        }
        return words;
    }

    public String toString(){
        String s = "";
        for(Word word: wordList){
            s+=word;
            s+=" ";
        }
        return s;
    }

}
