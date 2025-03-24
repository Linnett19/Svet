package net.tehword.books.api;

import net.tehword.books.book.BookData;
import net.tehword.books.book.BookRegistry;

public class BookAPI {
    public static void registerBook(BookData bookData) {
        BookRegistry.register(bookData);
    }
}