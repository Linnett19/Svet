package net.tehword.books.book;

import java.util.HashMap;
import java.util.Map;

public class BookRegistry {
    private static final Map<String, BookData> BOOKS = new HashMap<>();

    public static void register(BookData bookData) {
        BOOKS.put(bookData.getId(), bookData);
    }

    public static BookData getBook(String id) {
        return BOOKS.get(id);
    }
}