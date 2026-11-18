import java.util.Objects;

public class Item {
     String ID;
     String name;
     String priceDate;
     double price;
     double quanitty;
     String unit;
     double saved;

    public Item(String ID, String name, String priceDate, double price, double quanitty, String unit) {
        this.ID = ID;
        this.name = name;
        this.priceDate = priceDate;
        this.price = price;
        this.quanitty = quanitty;
        this.unit = unit;
        this.saved = 0;
    }

    public void setSaved(double saved) {
        this.saved = saved;
    }
    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    public boolean equals(Object other) {
        if(!(other instanceof Item)) {
            return false;
        }
        Item anden = (Item) other;
        return ID.equals(((Item) other).ID);
    }








}
