package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    // Them mot track vao danh sach neu chua co
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Xoa mot track khoi danh sach neu co
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Tinh tong do dai cua tat ca cac track
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Phat tat ca cac track, neu tong do dai <= 0 thi nem PlayerException
    // Neu track co do dai <= 0 thi bat ngoai le, in ra loi nhung tiep tuc phat cac track con lai
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                System.err.println("Cannot play track: " + track.getTitle() + ". Reason: " + e.getMessage());
            }
        }
    }

    // Ghi de equals de so sanh theo title (khong phan biet hoa thuong)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CompactDisc)) return false;

        CompactDisc other = (CompactDisc) obj;
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(other.getTitle());
    }

    // Ghi de toString de hien thi thong tin CD day du
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector()
                + " - " + getLength() + ": " + getCost() + " $";
    }
}
