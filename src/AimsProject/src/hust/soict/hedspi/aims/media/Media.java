package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    // Getter va Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    // Constructor co tham so
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Kiem tra ten co giong khong (khong phan biet hoa thuong)
    public boolean isMatch(String title) {
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(title);
    }

    // Override equals de so sanh theo title va cost
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // cung doi tuong
        if (o == null) return false; // doi tuong so sanh null
        if (!(o instanceof Media)) return false; // khong cung kieu

        Media media = (Media) o;

        // So sanh title, kiem tra null
        if (this.title == null) {
            if (media.title != null) return false;
        } else if (!this.title.equalsIgnoreCase(media.title)) {
            return false;
        }

        // So sanh cost
        return this.cost == media.cost;
    }

    // Override compareTo de sap xep theo title roi den cost (tang dan)
    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Khong the so sanh voi Media null");
        }

        // So sanh title
        if (this.title == null && other.title != null) {
            return -1;
        }
        if (this.title != null && other.title == null) {
            return 1;
        }
        if (this.title != null && other.title != null) {
            int titleCompare = this.title.compareToIgnoreCase(other.title);
            if (titleCompare != 0) {
                return titleCompare;
            }
        }
        // Neu title giong nhau thi so sanh cost
        return Float.compare(this.cost, other.cost);
    }

    // Comparator de sap xep theo tieu de, roi den gia (giam dan)
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int titleComparison = m1.getTitle().compareTo(m2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(m2.getCost(), m1.getCost()); // Sap xep giam dan
        }
    };

    // Comparator de sap xep theo gia tri, roi den tieu de
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int costComparison = Float.compare(m2.getCost(), m1.getCost()); // Sap xep giam dan
            if (costComparison != 0) {
                return costComparison;
            }
            return m1.getTitle().compareTo(m2.getTitle());
        }
    };
}
