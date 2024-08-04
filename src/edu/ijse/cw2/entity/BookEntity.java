package edu.ijse.cw2.entity;

public class BookEntity {
    String bookID; 
    String title; 
    String author; 
    String iSBN; 
    String publisher; 
    String categoryID ;
   
    public BookEntity() {
    }

    public BookEntity(String bookID, String title, String author, String iSBN, String publisher, String categoryID) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.iSBN = iSBN;
        this.publisher = publisher;
        this.categoryID = categoryID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "BookEntity [bookID=" + bookID + ", title=" + title + ", author=" + author + ", iSBN=" + iSBN
                + ", publisher=" + publisher + ", categoryID=" + categoryID + "]";
    }

    
    
}
