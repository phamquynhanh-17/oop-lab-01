package AimsProject.src.hust.soict.hedspi.aims.store;

import OtherProjects.Lab03.AimsProject.src.hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    // Khai bao so luong toi da cac media trong store
    public static final int MAX_NUMBERS = 100;
    // Su dung ArrayList de luu cac doi tuong Media (co the la DVD, Book, CD, ...)
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    // Phuong thuc them media vao store
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_NUMBERS) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("Store is full! Cannot add more items.");
        }
    }
    // Phuong thuc xoa media khoi store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("Item not found in the store.");
        }
    }
    // Phuong thuc in danh sach media trong store
    public void print() {
        System.out.println("********************************STORE********************************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("********************************************************************");
    }
    // Getter cho danh sach media neu can dung tu ben ngoai
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void showMediaDetails(String title)
    {
    	for(int i = 0; i < itemsInStore.size(); i++)
    	{
    		if(itemsInStore.get(i).getTitle().equalsIgnoreCase(title))
    		{
    			System.out.println("Details: " + itemsInStore.get(i).toString());
    		}
    	}
    	
    }
}
