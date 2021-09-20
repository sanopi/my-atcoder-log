import java.util.Comparator;
import java.util.List;

public class Functions {

    private static final Comparator<List<? extends Comparable<Object>>> comparator = (l1, l2) -> {
        int min = Math.min(l1.size(), l2.size());
        for (int i = 0; i < min; i++) {
            if (l1.get(i).equals(l2.get(i))) {
                continue;
            }
            return l1.get(i).compareTo(l2.get(i));
        }
        return Integer.compare(l1.size(), l2.size());
    };
}
