import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements TextUnitControl {
    private List<Symbol> symbolList = new ArrayList<>();

    Word(String word){
        createList(word);
    }

    @Override
    public void createList(String text) {
        Pattern p = Pattern.compile(".?");// скомпилировали регулярное выражение в представление
        Matcher m = p.matcher(text);
        while(m.find()) {
            //System.out.println(m.group());
            symbolList.add(new Symbol(m.group()));
        }
    }
    public String toString(){
        String s = "";
        for(Symbol symbol: symbolList){
            s+=symbol;
        }
        return s;
    }
}
