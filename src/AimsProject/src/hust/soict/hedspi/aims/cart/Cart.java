package AimsProject.src.hust.soict.hedspi.aims.cart;

import java.util.Collections;

import AimsProject.src.hust.soict.hedspi.aims.exception.LimitExceededException;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Them media vao gio hang, neu full se nem ngoai le
    public void addMedia(Media media) throws LimitExceededException {
        if (media == null) {
            throw new IllegalArgumentException("Media khong duoc null");
        }
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: So luong media da dat toi da");
        }
        itemsOrdered.add(media);
        System.out.println("Da them: " + media.getTitle());
    }

    // Xoa media khoi gio hang, neu khong ton tai thi nem ngoai le
    public void removeMedia(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media khong duoc null");
        }
        boolean removed = itemsOrdered.remove(media);
        if (!removed) {
            throw new IllegalArgumentException("Media khong ton tai trong gio hang");
        }
        System.out.println("Da xoa: " + media.getTitle());
    }

    // Hien thi cac muc trong gio hang
    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Gio hang dang trong");
        } else {
            System.out.println("Cac phan tu trong gio hang:");
            for (Media media : itemsOrdered) {
                System.out.println(media.getTitle() + " - " + media.getCost() + "$");
            }
        }
    }

    // Tinh tong chi phi cua gio hang
    public float totalCost() {
        float res = 0;
        for (Media m : itemsOrdered) {
            res += m.getCost();
        }
        return res;
    }

    // In thong tin gio hang
    public void print() {
        System.out.println("*******************************GIO HANG*******************************");
        System.out.println("Danh sach phan tu da dat:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Tong chi phi: " + totalCost() + "$");
        System.out.println("*********************************************************************");
    }

    // Tim kiem media theo ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tim thay: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi ID: " + id);
        }
    }

    // Tim kiem media theo title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Tim thay: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay media voi title: " + title);
        }
    }

    // Sap xep gio hang theo tieu de va gia (giam dan)
    public void sortByTitleAndCost() {
        System.out.println("Sap xep gio hang theo tieu de va gia:");
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        displayCart();
    }

    // Sap xep gio hang theo gia va tieu de
    public void sortByCostAndTitle() {
        System.out.println("Sap xep gio hang theo gia va tieu de:");
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        displayCart();
    }

    // Getter cho danh sach media neu can dung tu ben ngoai
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
