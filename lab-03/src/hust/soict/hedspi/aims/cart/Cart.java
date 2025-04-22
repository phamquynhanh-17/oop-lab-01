package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.hedspi.aims.media.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart quantity has reached the maximum number!");
        } else {
            if (itemsOrdered.contains(media)) {
                System.out.println("Media \"" + media.getTitle() + "\" is already in the cart!");
            } else {
                itemsOrdered.add(media);
                System.out.println("Media \"" + media.getTitle() + "\" has been added to the cart!");
            }
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" has been removed from the cart!");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" not found in the cart!");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
        } else {
            System.out.println("Ordered Items:");
            for (int i = 0; i < itemsOrdered.size(); i++) {
                Media media = itemsOrdered.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
            System.out.println("Total cost: " + totalCost() + "$");
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title containing: " + title);
        }
    }

    public void playMedia(String title) {
        Media media = null;
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)) {
                media = item;
                break;
            }
        }
        if (media == null) {
            System.out.println("No media found with title containing: " + title);
        } else if (!(media instanceof Playable)) {
            System.out.println("Media \"" + media.getTitle() + "\" is not playable (only DVDs and CDs can be played)!");
        } else {
            ((Playable) media).play();
        }
    }

    public void placeOrder() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty! Cannot place an order.");
        } else {
            System.out.println("An order has been created successfully!");
            itemsOrdered.clear();
        }
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}