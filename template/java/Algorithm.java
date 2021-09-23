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
        return ok;
    }
}
