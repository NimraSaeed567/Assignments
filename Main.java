package com.java.Assign1;

public class MainApp {
    public static void main(String[] args) {
   
        String jsonFilePath = "src/main/resources/book.json";
        
        BookProcessor bookProcessor = new BookProcessor(jsonFilePath);
        
       
        bookProcessor.displayAllBooks();
        bookProcessor.displayBooksByAuthor("William Shakespeare");
        bookProcessor.displayAveragePrice();
        bookProcessor.displayTitleOfMostExpensiveBook();
        bookProcessor.displayBooksByCategory("fantasy");
    }
}
