package ru.wenn.springcourse.models;

public class Book {
    private int id;

    private String title;

    private String author;

    private int yearOfPublication;

    public Book(){

    }

    public Book(String author, int id, String title, int yearOfPublication) {
        this.author = author;
        this.id = id;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
