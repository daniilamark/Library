package model;

public class Book {

    private int book_id;
    private String name;
    private String author;
    private String date_publish;
    private String date_issue;
    private String date_receiving;
    private int number_copies;

    public Book(int book_id, String name, String author, String date_publish, String date_issue, String date_receiving, int number_copies) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.date_publish = date_publish;
        this.date_issue = date_issue;
        this.date_receiving = date_receiving;
        this.number_copies = number_copies;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate_publish() {
        return date_publish;
    }

    public String getDate_issue() {
        return date_issue;
    }

    public String getDate_receiving() {
        return date_receiving;
    }

    public int getNumber_copies() {
        return number_copies;
    }
}
