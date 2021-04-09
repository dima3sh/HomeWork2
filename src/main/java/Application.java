
import Controllers.TextController;
import TextUnits.*;

import java.io.*;

public class Application {
    public static void main(String[] args)throws IOException {
        //спросить может лучше объект создавать внутри контроллера, а имя файла передавать в параметрах
        Text text = new Text("notes1.txt");
        TextController controller = new TextController(text);
        controller.createUnitTextList(controller.readFile());
        //System.out.println(controller.readFile());
        // text.read();
        System.out.println(text);
        //System.out.println(new Service(text).sortSize());
       // System.out.println(new Service(text).findFirstSingleWord());
    }
}
