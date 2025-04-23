package hust.soict.hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public boolean equals(Track b) {
        return (this.title == b.title && this.length == b.length);
    }

    public Track (String title, int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }
    public String getTitle() {
        return this.title;
    }

    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Tracks length: " + this.getLength());
    }
}