package OtherProjects.Lab04.AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
        int costCompare = Float.compare(m2.getCost(), m1.getCost()); // decreasing cost
        if (costCompare != 0) {
            return costCompare;
        }
        return m1.getTitle().compareToIgnoreCase(m2.getTitle()); // alphabetical by title
    }
}
