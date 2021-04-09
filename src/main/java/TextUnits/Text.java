package TextUnits;

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

public class Text extends UnitText{
    private String text;
    private String fileName;

    public Text(String fileName) throws IOException{
        this.fileName = fileName;
        //createList(string);
    }

    public String getFileName(){
        return fileName;
    }

    public String toString(){
        String s = "";
        for(UnitText paragraph: getUnitTextList()){
            s+=paragraph;
            s+="\n";
        }
        return s;
    }
}
