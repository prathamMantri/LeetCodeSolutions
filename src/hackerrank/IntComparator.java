package hackerrank;

import java.util.Comparator;

public class IntComparator {
    public boolean compare(Object a, Object b) {
        Comparator res = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int a = (int) o1;
                int b = (int) o2;
                if (a == b) {
                    return 0;
                } else if (a > b) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        int result = res.compare(a, b);

        return result == 0;
    }
}
