package com.kyron.automation.socialbook.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.kyron.automation.socialbook.client.BooksClient;
import com.kyron.automation.socialbook.client.model.Book;

public class Application {

    public static void main(String[] args) {
        BooksClient client = new BooksClient("http://localhost:8080", "usuario", "123456");

        List<Book> booksList = client.list();

        for (Book book : booksList) {
            System.out.println("Book: " + book.getName());
        }

        Book book = new Book();
        book.setName("Book 1");
        book.setPublisher("Publisher 1");
        SimpleDateFormat publication = new SimpleDateFormat("dd/MM/yyyy");
        try {
            book.setPublication(publication.parse("01/01/2000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book.setSummary("Summary");

        String locally = client.save(book);

        System.out.println("URI saved book: " + locally);

        Book searchedBook = client.getBook(locally);

        System.out.println("Searched book: " + searchedBook.getName());
    }

}
