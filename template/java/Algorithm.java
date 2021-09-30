import java.util.function.Predicate;

public class Algorithm {

    private static long binarySearch(long ng, long ok, Predicate<Long> condition) {
        while (Math.abs(ok - ng) > 1) {
            long mid = (ok + ng) / 2;
            if (condition.test(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return condition.test(ok) ? ok : ng;
    }

    private static int binarySearch(int ng, int ok, Predicate<Integer> condition) {
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;
            if (condition.test(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return condition.test(ok) ? ok : ng;
    }
}
