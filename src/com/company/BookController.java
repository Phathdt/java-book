package com.company;
import java.util.Scanner;
import java.util.*;

public class BookController {

    private final static Scanner scanner = new Scanner(System.in);
    private final List<Book> bookList;

    public BookController(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void menu() {

        Scanner scanner = new Scanner(System.in);
        boolean isContinuing = true;

        while (isContinuing) {
            System.out.println("======MENU======");
            System.out.println("1. To add new book");
            System.out.println("2. To retrieve book info");
            System.out.println("3. To print book list");
            System.out.println("0. Exit");

            int userOption = scanner.nextInt();
            switch (userOption) {
                case 0:
                    isContinuing = false;
                    System.out.println("Thank you!");
                    break;
                case 1:
                    addNewBook();
                    break;
                case 2:
                    retrieveBookInfo();
                    break;
                case 3:
                    printListBook();
                    break;
                default:
                    System.out.println("Wrong option!");

            }
        }
    }

    private void printListBook() {
        for (Book book : this.bookList){
            System.out.println(book);
        }
    }

    private void retrieveBookInfo() {
        System.out.println("Enter bookISBN: ");
        String ISBN = scanner.nextLine();

        if (isExistBook(ISBN)) {
            Book retrieveBook = findBookByISBN(ISBN);
            System.out.println(retrieveBook);
        } else {
            System.out.println("This book isn't exit!");
        }
    }

    private void addNewBook() {
        System.out.println("Book ISBN: ");
        String bookISBN = scanner.nextLine();

        System.out.println("Book title: ");
        String bookTitle = scanner.nextLine();

        System.out.println("Book author: ");
        String authorName = scanner.nextLine();

        addNewBookToList(bookISBN, bookTitle, authorName);

    }

    private void addNewBookToList(String bookISBN, String bookTitle, String authorName) {
        Book newBook = new Book.BookBuilder().bookISBN(bookISBN).bookTitle(bookTitle).authorName(authorName).build();
        if (isExistBook(newBook.getBookISBN())){
            System.out.println("This book is already exist!");
        } else {
            this.bookList.add(newBook);
            System.out.println("The book has added successfully!");
        }
    }

    private boolean isExistBook(String bookISBN) {
        for (Book book : this.bookList) {
            if (book.getBookISBN().equals(bookISBN)) {
                return true;
            }
        }
        return false;
    }

    private Book findBookByISBN(String ISBN) {
        for (Book book : this.bookList) {
            if (book.getBookISBN().equals(ISBN)){
                return book;
            }
        }

        return null;
    }
}