package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {
    private static int nbDigitalVideoDiscs = 0;

    // Constructor chi co title
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0, null, 0);
    }

    // Constructor co title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
    }

    // Constructor co title, category, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, 0);
    }

    // Constructor day du
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }

    public static int getTotalDVDs() {
        return nbDigitalVideoDiscs;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength()
                + ": " + getCost() + " $";
    }
}
