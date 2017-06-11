public class IntegerComparator implements Comparator {

    public int compare(Object first, Object second) {
        int f = (Integer) first;
        int d = (Integer) second;
        return f > d? 1: f == d? 0: -1;
    }
}
