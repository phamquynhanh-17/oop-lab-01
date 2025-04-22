package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 1;
        Cart userCart = new Cart();
        Store store = new Store();

        // Thêm một số media mẫu vào store để thử nghiệm
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Sci-Fi", 19.99f, "Wachowski");
        dvd1.setLength(136);
        CompactDisc cd1 = new CompactDisc(2, "Abbey Road", "Rock", 14.99f, "George Martin", "The Beatles");
        Track track1 = new Track("Come Together", 4);
        Track track2 = new Track("Something", 3);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        Book book1 = new Book(3, "1984", "Dystopia", 9.99f);
        book1.addAuthor("George Orwell");

        store.addMedia(dvd1);
        store.addMedia(cd1);
        store.addMedia(book1);

        do {
            showMenu();
            option = input.nextInt();
            input.nextLine(); // Xóa bộ đệm

            switch (option) {
                case 1: // View store
                    int opt = 1;
                    do {
                        storeMenu();
                        opt = input.nextInt();
                        input.nextLine(); // Xóa bộ đệm
                        switch (opt) {
                            case 1: // See a media’s details
                                System.out.print("Enter media ID: ");
                                int id = input.nextInt();
                                Media mediaDetails = store.searchById(id);
                                if (mediaDetails != null) {
                                    System.out.println(mediaDetails.toString());
                                } else {
                                    System.out.println("Media with ID " + id + " not found in store!");
                                }
                                break;

                            case 2: // Add a media to cart
                                System.out.print("Enter media ID: ");
                                id = input.nextInt();
                                Media mediaToAdd = store.searchById(id);
                                if (mediaToAdd != null) {
                                    userCart.addMedia(mediaToAdd);
                                } else {
                                    System.out.println("Media with ID " + id + " not found in store!");
                                }
                                break;

                            case 3: // Play a media
                                System.out.print("Enter media title: ");
                                String titleToPlay = input.nextLine();
                                Media mediaToPlay = store.searchByTitle(titleToPlay);
                                if (mediaToPlay == null) {
                                    System.out.println("Media with title containing \"" + titleToPlay + "\" not found in store!");
                                } else if (!(mediaToPlay instanceof Playable)) {
                                    System.out.println("Media \"" + mediaToPlay.getTitle() + "\" is not playable (only DVDs and CDs can be played)!");
                                } else {
                                    ((Playable) mediaToPlay).play();
                                }
                                break;

                            case 4: // See current cart
                                userCart.displayCart();
                                break;

                            case 0: // Back
                                break;

                            default:
                                System.out.println("Invalid option! Please choose again.");
                        }
                    } while (opt != 0);
                    break;

                case 2: // Update store
                    System.out.println("Options: ");
                    System.out.println("--------------------------------");
                    System.out.println("1. Add a media to store");
                    System.out.println("2. Remove a media from store");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.println("Please choose a number: 0-1-2");
                    int updateOpt = input.nextInt();
                    input.nextLine(); // Xóa bộ đệm

                    switch (updateOpt) {
                        case 1: // Add a media to store
                            System.out.println("Enter media type (1: DVD, 2: CD, 3: Book): ");
                            int type = input.nextInt();
                            input.nextLine(); // Xóa bộ đệm
                            System.out.print("Enter ID: ");
                            int id = input.nextInt();
                            input.nextLine();
                            System.out.print("Enter title: ");
                            String title = input.nextLine();
                            System.out.print("Enter category: ");
                            String category = input.nextLine();
                            System.out.print("Enter cost: ");
                            float cost = input.nextFloat();
                            input.nextLine();

                            if (type == 1) { // DVD
                                System.out.print("Enter director: ");
                                String director = input.nextLine();
                                System.out.print("Enter length: ");
                                int length = input.nextInt();
                                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director);
                                dvd.setLength(length);
                                store.addMedia(dvd);
                            } else if (type == 2) { // CD
                                System.out.print("Enter director: ");
                                String director = input.nextLine();
                                System.out.print("Enter artist: ");
                                String artist = input.nextLine();
                                CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
                                store.addMedia(cd);
                            } else if (type == 3) { // Book
                                Book book = new Book(id, title, category, cost);
                                System.out.print("Enter author: ");
                                String author = input.nextLine();
                                book.addAuthor(author);
                                store.addMedia(book);
                            }
                            break;

                        case 2: // Remove a media from store
                            System.out.print("Enter media ID to remove: ");
                            id = input.nextInt();
                            Media mediaToRemove = store.searchById(id);
                            if (mediaToRemove != null) {
                                store.removeMedia(mediaToRemove);
                            } else {
                                System.out.println("Media with ID " + id + " not found in store!");
                            }
                            break;

                        case 0: // Back
                            break;

                        default:
                            System.out.println("Invalid option! Please choose again.");
                    }
                    break;

                case 3: // See current cart
                    int op = 1;
                    do {
                        cartMenu();
                        op = input.nextInt();
                        input.nextLine(); // Xóa bộ đệm
                        switch (op) {
                            case 1: // Filter media in cart
                                System.out.println("Filter by: ");
                                System.out.println("1. ID");
                                System.out.println("2. Title");
                                int filterOpt = input.nextInt();
                                input.nextLine();
                                if (filterOpt == 1) {
                                    System.out.print("Enter ID: ");
                                    int idFilter = input.nextInt();
                                    userCart.searchById(idFilter);
                                } else if (filterOpt == 2) {
                                    System.out.print("Enter title: ");
                                    String titleFilter = input.nextLine();
                                    userCart.searchByTitle(titleFilter);
                                } else {
                                    System.out.println("Invalid filter option!");
                                }
                                break;

                            case 2: // Sort media in cart
                                System.out.println("Sort by: ");
                                System.out.println("1. Title then Cost");
                                System.out.println("2. Cost then Title");
                                int sortOpt = input.nextInt();
                                if (sortOpt == 1) {
                                    userCart.sortByTitleCost();
                                    userCart.displayCart();
                                } else if (sortOpt == 2) {
                                    userCart.sortByCostTitle();
                                    userCart.displayCart();
                                } else {
                                    System.out.println("Invalid sort option!");
                                }
                                break;

                            case 3: // Remove media from cart
                                System.out.print("Enter media ID to remove: ");
                                int idRemove = input.nextInt();
                                Media mediaToRemoveCart = null;
                                for (Media m : userCart.getItemsOrdered()) {
                                    if (m.getId() == idRemove) {
                                        mediaToRemoveCart = m;
                                        break;
                                    }
                                }
                                if (mediaToRemoveCart != null) {
                                    userCart.removeMedia(mediaToRemoveCart);
                                } else {
                                    System.out.println("Media with ID " + idRemove + " not found in cart!");
                                }
                                break;

                            case 4: // Play a media
                                System.out.print("Enter media title to play: ");
                                String titlePlay = input.nextLine();
                                userCart.playMedia(titlePlay);
                                break;

                            case 5: // Place order
                                userCart.placeOrder();
                                break;

                            case 0: // Back
                                break;

                            default:
                                System.out.println("Invalid option! Please choose again.");
                                break;
                        }
                    } while (op != 0);
                    break;

                case 0: // Exit
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        } while (option != 0);

        input.close();
    }
}