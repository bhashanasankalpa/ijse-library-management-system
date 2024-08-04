package edu.ijse.cw2.dto;


public class BookDto {
   
    String bookID; 
    String title; 
    String author; 
    String bookISBn; 
    String publisher; 
    String categoryID ;
    
    public BookDto() {
    }
    public BookDto(String bookID, String title, String author, String bookISBn, String publisher, String categoryID) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.bookISBn = bookISBn;
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
    public String getBookISBn() {
        return bookISBn;
    }
    public void setBookISBn(String bookISBn) {
        this.bookISBn = bookISBn;
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
        return "BookDto [bookID=" + bookID + ", title=" + title + ", author=" + author + ", bookISBn=" + bookISBn
                + ", publisher=" + publisher + ", categoryID=" + categoryID + "]";
    }

    
    

    
}
