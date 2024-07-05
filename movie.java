package projecttest;
import java.util.List;

public class Movie implements Media {
    private String title;
    private String director;
    private double price;

    
    public Movie(String title, String director, double price) {
        this.title = title;
        this.director = director;
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
