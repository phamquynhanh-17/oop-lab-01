package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle()); // alphabetical
		if (titleCompare != 0) {
			return titleCompare;
		}
		return Float.compare(m2.getCost(), m1.getCost()); // decreasing cost
	    }
}
