package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor chính với đầy đủ tham số
    public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost); // Gọi constructor của Media với 4 tham số
        this.director = director;
        this.length = 0; // Khởi tạo mặc định, có thể cập nhật sau
    }

    // Constructor với đầy đủ tham số bao gồm length
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}