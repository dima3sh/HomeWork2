package TextUnits;

import java.util.ArrayList;
import java.util.List;

public class Listing extends UnitText {
    List<UnitText> unitTextlist = new ArrayList<>();

    public String toString(){
        String s = "";
        for(UnitText symbol: getUnitTextList()){
            s+=symbol;
        }
        return s;
    }
}
