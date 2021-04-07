import java.util.List;

public class Service implements ServiceControl {
    private Text text;
    public Service(Text  text){
        this.text = text;
    }

    //task number 2
    public String sortSize() {
        List<Sentence>  listSentences = text.getSentences();
        listSentences.sort((Sentence sentence1, Sentence sentence2)->{
            return (sentence1.getWordCount() -sentence2.getWordCount());
        });
        String string = "";
        for(Sentence sentence : listSentences){
            string += sentence.toString();
        }
        return string;
    }
    //task3
    public String findFirstSingleWord(){
        List<Word> words= text.getWords();
        List <Sentence> sens= text.getSentences();
        Sentence sentence = sens.get(0);
        List<Word> firstSentWords = sentence.getWords();

        int count = 0;

        for(Word word : firstSentWords){
            count = 0;
            for(Word w : words){
                if(word.toString().equals(w.toString())) count++;
                if(count > 1) break;
            }
            if(count == 1) return word.toString();
        }
        return "";
    }

}
