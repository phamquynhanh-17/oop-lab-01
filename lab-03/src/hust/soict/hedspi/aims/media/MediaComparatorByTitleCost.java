package hust.soict.hedspi.aims.media;

import java.util.*;
public class MediaComparatorByTitleCost implements Comparator<Media>{

    public int compare (Media a, Media b) {
        if (a.getCost() > b.getCost()) {
            return 1;
        }
        else if (a.getCost() == b.getCost())
        {
            if (a.getTitle().compareTo(b.getTitle()) > 0) {
                return 1;
            }
            if (a.getTitle().compareTo(b.getTitle()) == 0)
                return 0;
            else return -1;
        }
        else
            return -1;
    }
}