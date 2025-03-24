package net.tehword.books.book;

public class BookData {
    private final String id;
    private final String name;
    private final String landingText;

    public BookData(String id, String name, String landingText) {
        this.id = id;
        this.name = name;
        this.landingText = landingText;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLandingText() {
        return landingText;
    }
}