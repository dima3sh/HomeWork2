
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args)throws IOException {

        /*try(FileReader reader = new FileReader("notes1.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/
        Text text = new Text("notes1.txt");
        // text.read();
        //System.out.println(text);
        //System.out.println(new Service().sortSize(text));
        System.out.println(new Service(text).findFirstSingleWord());
    }
}
