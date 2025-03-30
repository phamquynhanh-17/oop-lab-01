package aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full! Cannot add more discs.");
            return 0;
        }
        itemsOrdered[qtyOrdered++] = disc;
        System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
        return 1;
    }

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Your cart is empty right now!");
            return 0;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) { // Thêm kiểm tra null
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("Removed DVD \"" + disc.getTitle() + "\" successfully!");
                return 1;
            }
        }
        System.out.println("No matching DVD found!");
        return 0;
    }

    public float totalCost() {
        float sum = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int addedCount = 0;
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full! Cannot add more discs.");
                break;
            }
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
            addedCount++;
        }
        return addedCount;
    }

    public int DigitalVideoDisc(DigitalVideoDisc... dvdArray) {
        int addedCount = 0;
        for (DigitalVideoDisc disc : dvdArray) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full! Cannot add more discs.");
                break;
            }
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
            addedCount++;
        }
        return addedCount;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart does not have enough space for two more discs.");
            return 0;
        }
        itemsOrdered[qtyOrdered++] = dvd1;
        System.out.println("The DVD \"" + dvd1.getTitle() + "\" has been added!");
        itemsOrdered[qtyOrdered++] = dvd2;
        System.out.println("The DVD \"" + dvd2.getTitle() + "\" has been added!");
        return 2;
    }
}
