package com.example.books_app;

public class BookCard {
    private String book_image;
    private String book_title;
    private String book_subtitle;
    private String book_authors;
    private String book_published_date;
    private String book_publisher;
    private String book_page_count;
    private String book_description;

    public BookCard(String book_image, String book_title, String book_subtitle, String book_authors, String book_published_date, String book_publisher, String book_page_count, String book_description) {
        this.book_image = book_image;
        this.book_title = book_title;
        this.book_subtitle = book_subtitle;
        this.book_authors = book_authors;
        this.book_published_date = book_published_date;
        this.book_publisher = book_publisher;
        this.book_page_count = book_page_count;
        this.book_description = book_description;
    }
    public BookCard()
    {

    }
    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_subtitle() {
        return book_subtitle;
    }

    public void setBook_subtitle(String book_subtitle) {
        this.book_subtitle = book_subtitle;
    }

    public String getBook_authors() {
        return book_authors;
    }

    public void setBook_authors(String book_authors) {
        this.book_authors = book_authors;
    }

    public String getBook_published_date() {
        return book_published_date;
    }

    public void setBook_published_date(String book_published_date) {
        this.book_published_date = book_published_date;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public String getBook_page_count() {
        return book_page_count;
    }

    public void setBook_page_count(String book_page_count) {
        this.book_page_count = book_page_count;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }
}
