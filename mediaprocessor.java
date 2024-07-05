package projecttest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MediaProcessor<T extends Media> {
    private List<T> mediaItems;

    public MediaProcessor(String jsonFilePath, Type type) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(jsonFilePath)) {
            mediaItems = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllMedia() {
        mediaItems.forEach(media -> System.out.println(media.getTitle() + ": $" + media.getPrice()));
    }

    public void displayMediaByTitle(String title) {
        mediaItems.stream()
                  .filter(media -> media.getTitle().equalsIgnoreCase(title))
                  .forEach(media -> System.out.println("Found: " + media.getTitle() + ", Price: $" + media.getPrice()));
    }

    public void updateMediaPrice(String title, double newPrice) {
        mediaItems.stream()
                  .filter(media -> media.getTitle().equalsIgnoreCase(title))
                  .forEach(media -> media.updatePrice(newPrice));
    }

    public static void main(String[] args) {
        Type bookListType = new TypeToken<List<Book>>() {}.getType();
        MediaProcessor<Book> bookProcessor = new MediaProcessor<>("books.json", bookListType);

        Type movieListType = new TypeToken<List<Movie>>() {}.getType();
        MediaProcessor<Movie> movieProcessor = new MediaProcessor<>("movies.json", movieListType);

        Type magazineListType = new TypeToken<List<Magazine>>() {}.getType();
        MediaProcessor<Magazine> magazineProcessor = new MediaProcessor<>("magazines.json", magazineListType);

        Type audioBookListType = new TypeToken<List<AudioBook>>() {}.getType();
        MediaProcessor<AudioBook> audioBookProcessor = new MediaProcessor<>("audiobooks.json", audioBookListType);

        System.out.println("Books:");
        bookProcessor.displayAllMedia();

        System.out.println("\nMovies:");
        movieProcessor.displayAllMedia();

        System.out.println("\nMagazines:");
        magazineProcessor.displayAllMedia();

        System.out.println("\nAudio Books:");
        audioBookProcessor.displayAllMedia();

      
        bookProcessor.updateMediaPrice("To Kill a Mockingbird", 15.99);
        System.out.println("\nUpdated Price of 'To Kill a Mockingbird':");
        bookProcessor.displayMediaByTitle("To Kill a Mockingbird");
    }
}
