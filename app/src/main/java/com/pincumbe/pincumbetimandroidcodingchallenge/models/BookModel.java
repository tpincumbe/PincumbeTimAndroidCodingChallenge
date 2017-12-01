package com.pincumbe.pincumbetimandroidcodingchallenge.models;

/**
 * Data model representation of a book
 */

public class BookModel {
    private String title;
    private String author;
    private String imageURL;

    /**
     * Default constructor
     */
    public BookModel() {
    }

    /**
     * Main constructor
     * @param title - Title of the book
     * @param author - Author of the book
     * @param imageURL - URL for the book thumbnail
     */
    public BookModel(String title, String author, String imageURL) {
        this.title = title;
        this.author = author;
        this.imageURL = imageURL;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return author + ": " + title + ": " + imageURL + "\n";
    }
}
