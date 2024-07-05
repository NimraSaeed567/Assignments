package projecttest;
import java.util.List;

public class Magazine implements Media {
    private String title;
    private double price;

    // Constructor, getters, setters
 // Constructor
    public Magazine(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

  
}
