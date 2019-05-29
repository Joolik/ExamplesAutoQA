package aircrafts.comparators;

import aircrafts.Aircraft;

import java.util.Comparator;

public class LoadComparator implements Comparator<Aircraft> {

    public int compare(Aircraft craft1, Aircraft craft2) {
        return  (int) (craft1.getMaxLoad() - craft2.getMaxLoad());
    }
}