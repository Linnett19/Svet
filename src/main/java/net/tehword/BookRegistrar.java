package net.tehword;

import net.tehword.books.api.BookAPI;
import net.tehword.books.book.BookData;

public class BookRegistrar {
    public static void registerBooks() {
        BookAPI.registerBook(new BookData("yourbook", "Your Book", "Welcome to your book!"));
        // Добавьте другие книги здесь
    }
}