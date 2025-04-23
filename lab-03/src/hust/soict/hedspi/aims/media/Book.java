package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author \"" + authorName + "\" is already in the list!");
        } else {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added to the book!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Author \"" + authorName + "\" has been removed from the book!");
        } else {
            System.out.println("Author \"" + authorName + "\" not found in the list!");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors.toString() + " - " + getCost() + "$";
    }
}