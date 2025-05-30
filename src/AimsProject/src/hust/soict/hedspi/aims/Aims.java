package AimsProject.src.hust.soict.hedspi.aims;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.LimitExceededException;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Book;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Media;
import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Aims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store();
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Media book = new Book(1, "Java Programming", "Education", 15.5f);
        Media dvd = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 19.99f);
        Media anotherDvd = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 21.99f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(anotherDvd);

        Cart cart = new Cart();

        int mainChoice;
        do {
            showPrepareMenu();
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    int menuChoice;
                    do {
                        showMenu();
                        menuChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (menuChoice) {
                            case 1:
                                store.print();
                                storeMenu(scanner, store, cart);
                                break;
                            case 2:
                                updateStore(scanner, store);
                                break;
                            case 3:
                                cartMenu(scanner, cart);
                                break;
                            case 0:
                                System.out.println("Quay lai menu chuan bi...");
                                break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                        }
                    } while (menuChoice != 0);
                    break;
                case 2:
                    System.out.println("Thoat chuong trinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (mainChoice != 2);
    }

    public static void showPrepareMenu() {
        System.out.println("Options: ");
        System.out.println("1: Show Menu");
        System.out.println("2: Exit");
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem store");
        System.out.println("2. Cap nhat store");
        System.out.println("3. Xem gio hang");
        System.out.println("0. Thoat");
        System.out.println("--------------------------------");
        System.out.println("Vui long chon so: 0-1-2-3");
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        int choice;
        do {
            System.out.println("Tuy chon: ");
            System.out.println("--------------------------------");
            System.out.println("1. Xem chi tiet media");
            System.out.println("2. Them media vao gio hang");
            System.out.println("3. Phat media");
            System.out.println("4. Xem gio hang");
            System.out.println("0. Quay lai");
            System.out.println("--------------------------------");
            System.out.println("Vui long chon so: 0-1-2-3-4");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner, store);
                    break;
                case 2:
                    addMediaToCart(scanner, store, cart);
                    break;
                case 3:
                    playMediaInStore(scanner, store);
                    break;
                case 4:
                    cartMenu(scanner, cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        } while (choice != 0);
    }

    public static void seeMediaDetails(Scanner scanner, Store store) {
        System.out.print("Nhap ten media de xem chi tiet: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store.getItemsInStore()) {
            if (media.isMatch(title)) {
                System.out.println("Chi tiet cua " + media.getTitle() + ": " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void addMediaToCart(Scanner scanner, Store store, Cart cart) {
        store.print();
        System.out.print("Nhap ten media de them vao gio: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store.getItemsInStore()) {
            if (media.isMatch(title)) {
                try {
                    cart.addMedia(media);
                } catch (LimitExceededException e) {
                    System.out.println("Khong the them media: " + e.getMessage());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void playMediaInStore(Scanner scanner, Store store) {
        System.out.print("Nhap ten media de phat: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store.getItemsInStore()) {
            if (media.isMatch(title)) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    System.out.println("Dang phat: " + dvd.getTitle());
                    try {
                        dvd.play(); 
                    } catch (PlayerException e) {
                        System.err.println("PlayerException: " + e.getMessage());
                        System.err.println(e.toString());
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
                    }
                    found = true;
                } else {
                    System.out.println("Media nay khong the phat.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void updateStore(Scanner scanner, Store store) {
        int choice;
        do {
            System.out.println("Tuy chon cap nhat store: ");
            System.out.println("--------------------------------");
            System.out.println("1. Them media vao store");
            System.out.println("2. Xoa media khoi store");
            System.out.println("0. Quay lai");
            System.out.println("--------------------------------");
            System.out.println("Vui long chon so: 0-1-2");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMediaToStore(scanner, store);
                    break;
                case 2:
                    removeMediaFromStore(scanner, store);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        } while (choice != 0);
    }

    public static void addMediaToStore(Scanner scanner, Store store) {
        System.out.print("Nhap ten media de them vao store: ");
        String title = scanner.nextLine();
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd);
    }

    public static void removeMediaFromStore(Scanner scanner, Store store) {
        System.out.print("Nhap ten media de xoa khoi store: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store.getItemsInStore()) {
            if (media.isMatch(title)) {
                store.removeMedia(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        int choice;
        do {
            System.out.println("Tuy chon: ");
            System.out.println("--------------------------------");
            System.out.println("1. Loc media trong gio");
            System.out.println("2. Sap xep media trong gio");
            System.out.println("3. Xoa media khoi gio");
            System.out.println("4. Phat media");
            System.out.println("5. Dat hang");
            System.out.println("0. Quay lai");
            System.out.println("--------------------------------");
            System.out.println("Vui long chon so: 0-1-2-3-4-5");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMediaInCart(scanner, cart);
                    break;
                case 2:
                    sortMediaInCart(scanner, cart);
                    break;
                case 3:
                    removeMediaFromCart(scanner, cart);
                    break;
                case 4:
                    playMediaInCart(scanner, cart);
                    break;
                case 5:
                    placeOrder(cart);
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        } while (choice != 0);
    }

    public static void filterMediaInCart(Scanner scanner, Cart cart) {
        System.out.println("Loc theo: ");
        System.out.println("1. ID");
        System.out.println("2. Tieu de");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhap ID media: ");
                int id = scanner.nextInt();
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Nhap tieu de media: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }

    public static void playMediaInCart(Scanner scanner, Cart cart) {
        System.out.print("Nhap ten media de phat: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : cart.getItemsOrdered()) {
            if (media.isMatch(title)) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    System.out.println("Dang phat: " + dvd.getTitle());
                    try {
                        dvd.play();
                    } catch (PlayerException e) {
                        System.err.println("PlayerException: " + e.getMessage());
                        System.err.println(e.toString());
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
                    }
                    found = true;
                } else {
                    System.out.println("Media nay khong the phat.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void sortMediaInCart(Scanner scanner, Cart cart) {
        System.out.println("Sap xep theo: ");
        System.out.println("1. Tieu de va gia ");
        System.out.println("2. Gia va tieu de");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                cart.sortByTitleAndCost();
                break;
            case 2:
                cart.sortByCostAndTitle();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                break;
        }
    }

    public static void removeMediaFromCart(Scanner scanner, Cart cart) {
        System.out.print("Nhap ten media de xoa khoi gio: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : cart.getItemsOrdered()) {
            if (media.isMatch(title)) {
                cart.removeMedia(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ten: " + title);
        }
    }

    public static void placeOrder(Cart cart) {
        System.out.println("Dang dat hang...");
        System.out.println("Tong chi phi: " + cart.totalCost() + "$");
        cart.print();
        cart = new Cart(); // Reset gio hang
    }
}
