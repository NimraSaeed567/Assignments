package projecttest;

import java.util.List;

public class AudioBook implements Media {
    private String title;
    private String author;
    private String narrator;
    private double price;

    
    public AudioBook(String title, String author, String narrator, double price) {
        this.title = title;
        this.author = author;
        this.narrator=narrator;
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
