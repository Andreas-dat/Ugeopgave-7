import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Load {


    public static HashMap<String, Item> makeDiscountIteam(String path) {
       HashMap<String, Item> h = new HashMap<>();
       ArrayList<String> a =  FileIO.readData(path, true);

       for(String z : a) {
           String[] values = z.split(";");
           String name = values[1];
           double price = Double.parseDouble(values[3]);
           String lastPriceChange = values[2];
           double quanity = Double.parseDouble(values[5]);
           String unit = values[6];
            h.put(values[0], new Item(values[0], name, lastPriceChange, price, quanity, unit));
       }
       return h;

    }

    public static ArrayList<Item> makeList(String path) {
        ArrayList<String> a =  FileIO.readData(path, true);
        ArrayList<Item> list = new ArrayList<>();

        for(String z : a) {
            String[] values = z.split(";");
            String name = values[1];
            double price = Double.parseDouble(values[3]);
            String lastPriceChange = values[2];
            double quanity = Double.parseDouble(values[5]);
            String unit = values[6];
            list.add(new Item(values[0], name, lastPriceChange,price,quanity,unit));
        }
        return list;



    }
}
