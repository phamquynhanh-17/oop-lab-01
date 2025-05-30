package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    // Getter
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    // Ghi de equals de so sanh 2 track dua tren title va length
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;

        Track other = (Track) obj;

        return this.title != null
                && this.title.equalsIgnoreCase(other.getTitle())
                && this.length == other.getLength();
    }
    // Phuong thuc play co throw PlayerException
    @Override
    public void play() throws PlayerException {
        if (this.length > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
}
