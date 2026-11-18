import java.util.*;

public class CashRegister {

    private Robot robot = new Robot();

    HashSet<Item> tilbudVare = Load.makeIteam("Data/tilbud.csv");
    HashSet<Item> alleVare = Load.makeIteam("Data/varer.csv");

    public void reciept() {
        Collection<Item> basket = robot.fyldIKurv(alleVare);


        HashMap<Item, Integer> map = new HashMap<>();


        for (Item a : basket) {
            if(tilbudVare.contains(a)) {
                for (Item b : tilbudVare) {
                    if (b.equals(a)) {
                        System.out.println("Vi er eher");
                        b.setSaved(a.price - b.price);
                        a = b;
                        break;
                    }
                    }
                }
                map.merge(a, 1, Integer::sum);
                }

        double sum = 0;
        for (Item a : map.keySet()) {
            String s = ("Name: " + a.name + " amount: " + a.quanitty + " Price: " + a.price + " x " + map.get(a) + " = " + (a.price * map.get(a)));
            if(a.saved != 0) {
                s +=(" saved " + a.saved);
            }
            System.out.println(s);

            sum += a.price * map.get(a);
        }


        System.out.println("In total: " + sum);
        System.out.println("Kunden har købt" + map.size() + "Unikke vare");


    }






}
