import java.util.*;

public class CashRegister {

    private Robot robot = new Robot();

    HashMap<String, Item> tilbudVare = Load.makeDiscountIteam("Data/tilbud.csv");
    ArrayList<Item> alleVare = Load.makeList("Data/varer.csv");

    public void reciept() {
        Collection<Item> basket = robot.fyldIKurv(alleVare);

        HashMap<Item, Integer> map = new HashMap<>();

        for(Item a : basket){
            Item item = tilbudVare.get(a.ID);
            if(item != null) {
                item.setSaved(a.price-item.price);
                a = item;
            }
            map.merge(a, 1, Integer::sum);
        }

        double sum = 0;
        double sumSaved = 0;
        for (Item a : map.keySet()) {
            String s = ("Name: " + a.name + " amount: " + a.quanitty + " Price: " + a.price + " x " + map.get(a) + " = " + (a.price * map.get(a)));
            System.out.println(s);
            if(a.saved != 0) {
                sumSaved += a.saved;
                System.out.println("Saved on " + a.name + " -" + a.saved);
            }


            sum += (a.price - a.saved) * map.get(a);
        }
        System.out.println("In total: " + sum);
        System.out.println("Saved in total" + sumSaved);
        System.out.println("Costumer bought " + map.size() + " unique iteams");


    }






}
