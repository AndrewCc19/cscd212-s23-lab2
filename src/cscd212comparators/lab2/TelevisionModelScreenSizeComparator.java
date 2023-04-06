package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator<Television> {
    public int compare(Television t1, Television t2) {
        if(t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionModelScreenSizeComparator");

        int modelComp = t1.getModel().compareTo(t2.getModel());
        if (modelComp != 0) {
            return modelComp;
        } else {
            return t1.getScreenSize() - t2.getScreenSize();
        }
    }
}
