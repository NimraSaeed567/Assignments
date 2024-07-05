package projecttest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class BookProcessor {
    private List<Book> books;

    
    public BookProcessor(String jsonFilePath) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type listType = new TypeToken<List<Book>>() {}.getType();
            books = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  
    public void displayAllBooks() {
        books.forEach(Book::displayBookInfo);
    }

    
    public void displayBooksByAuthor(String authorName) {
        books.stream()
             .filter(book -> book.getAuthor().equalsIgnoreCase(authorName))
             .forEach(Book::displayBookInfo);
    }

    
    public void displayAveragePrice() {
        double averagePrice = books.stream()
                                   .mapToDouble(book -> book.getMetadata().getPrice())
                                   .average()
                                   .orElse(0);
        System.out.println("Average price of all books: $" + averagePrice);
    }

    
    public void displayTitleOfMostExpensiveBook() {
        Book mostExpensiveBook = books.stream()
                                     .max((book1, book2) -> Double.compare(book1.getMetadata().getPrice(),
                                                                         book2.getMetadata().getPrice()))
                                     .orElse(null);
        if (mostExpensiveBook != null) {
            System.out.println("Title of the most expensive book: " + mostExpensiveBook.getTitle());
        } else {
            System.out.println("No books found.");
        }
    }

    
    public void displayBooksByCategory(String category) {
        books.stream()
             .filter(book -> book.getMetadata().getCategories().contains(category))
             .forEach(Book::displayBookInfo);
    }
}
