package com.java.Assign1;

public class Book {
    private String title;
    private String author;
    private MetaData metadata;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + metadata.getPrice());
        System.out.println("Categories: " + metadata.getCategories());
        System.out.println("ISBN: " + metadata.getIsbn());
        System.out.println("Pages: " + metadata.getPages());
        System.out.println();
    }
}
