package com.company;

public class Book {
    private final String bookISBN;
    private final String bookTitle;
    private final String authorName;

    private Book(BookBuilder bookBuilder){
        this.bookISBN = bookBuilder.bookISBN;
        this.bookTitle = bookBuilder.bookTitle;
        this.authorName = bookBuilder.authorName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    @Override
    public String toString() {
        return "The book is {" +
                "bookISBN='" + bookISBN + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    // Inner class
    public static class BookBuilder {
        private String bookISBN;
        private String bookTitle;
        private String authorName;

        public BookBuilder() {
        }

        public BookBuilder bookISBN(String bookISBN) {
            this.bookISBN = bookISBN;
            return this;
        }

        public BookBuilder bookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
            return this;
        }

        public BookBuilder authorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Book build(){
            return new Book(this);
        }

    }
}
