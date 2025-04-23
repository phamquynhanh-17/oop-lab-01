package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Thêm media vào cửa hàng
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("Media \"" + media.getTitle() + "\" has been added to the store!");
        }
    }

    // Xóa media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media \"" + media.getTitle() + "\" has been removed from the store!");
        } else {
            System.out.println("Media \"" + media.getTitle() + "\" not found in the store!");
        }
    }

    // Hiển thị toàn bộ media trong cửa hàng
    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("Items in Store:");
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
        }
    }

    // Tìm kiếm media theo ID
    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    // Tìm kiếm media theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }
}