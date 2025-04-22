package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, director);
        this.artist = artist;
        this.tracks = new ArrayList<Track>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD!");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD!");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" not found in the CD!");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        setLength(totalLength); // Cập nhật length của Disc
        return totalLength;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("The CD \"" + getTitle() + "\" cannot be played because its length is 0 or negative!");
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        System.out.println("Artist: " + artist);
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getDirector() + " - " + getLength() + " minutes: " + getCost() + "$";
    }
}