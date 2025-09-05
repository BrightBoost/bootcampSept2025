package com.neueda.exercises.classes;

public class Book {
//    1. **Book Class**
//   Create a `Book` class with properties `title`, `author`, and `numberOfPages`. Make sure to create a constructor to initialize these properties. Add a method called `printInfo()` that prints all of this information to the console. Then, create several Book objects in your main method and call `printInfo()` on them.
//
    private String title;
    private String author;
    private int numberOfPages;

    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void printInfo() {
        System.out.println(this.title + " is written by " + this.author + ". And is " + this.numberOfPages + " pages long.");
    }
}

