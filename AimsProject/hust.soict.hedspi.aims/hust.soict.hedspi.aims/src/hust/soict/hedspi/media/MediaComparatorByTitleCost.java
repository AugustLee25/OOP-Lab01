package hust.soict.hedspi.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh title trước (tăng dần, alphabetically)
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Nếu title giống nhau, so sánh cost (giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}