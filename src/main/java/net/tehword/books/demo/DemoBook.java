package net.tehword.books.demo;

import net.tehword.books.api.BookAPI;
import net.tehword.books.book.BookData;

public class DemoBook {
    public static void register() {
        BookAPI.registerBook(new BookData("demo", "Demo Book", "Welcome to the demo book!"));
    }
}