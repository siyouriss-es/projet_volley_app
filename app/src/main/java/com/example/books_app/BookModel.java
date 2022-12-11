package com.example.books_app;


import java.util.Arrays;

public class BookModel {

    private String title;
    private String subtitle;
    private String[] authors;
    private String publishedDate;
    private String publisher;
    private String description;
    private int pageCount;
    private String imageLink;

    // Constructor :
    public BookModel(String title, String subtitle, String[] authors, String publishedDate, String publisher, String description, int pageCount, String imageLink) {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
        this.description = description;
        this.pageCount = pageCount;
        this.imageLink = imageLink;
    }

    public BookModel() {
        this.title = "Not provided" ;
        this.subtitle = "Not provided";
        this.authors = new String[0];
        this.publishedDate = "Not provided";
        this.publisher = "Not provided";
        this.description = "Not provided";
        this.pageCount = 0;
        this.imageLink = "Not provided";
    }

    // ToString :

    @Override
    public String toString() {
        return "BookModel{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publishedDate='" + publishedDate + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }


    //setters & getters :

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthors() {
        String auths="";
        for(int i=0;i<this.authors.length;i++)
        {
            auths+=authors[i]+", ";
        }
        return auths;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
