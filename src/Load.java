import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Load {


    public static HashSet<Item> makeIteam(String path) {
       HashSet<Item> h = new HashSet<>();
       ArrayList<String> a =  FileIO.readData(path, true);

       for(String z : a) {
           String[] values = z.split(";");
           String name = values[1];
           double price = Double.parseDouble(values[3]);
           String lastPriceChange = values[2];
           double quanity = Double.parseDouble(values[5]);
           String unit = values[6];
            h.add(new Item(values[0], name, lastPriceChange, price, quanity, unit));
       }
       return h;




    }
}
