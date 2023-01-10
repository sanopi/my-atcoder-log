import java.util.ArrayList;
import java.util.List;

public class RollingHash {
    private static final long BASE = 1000000007;

    int n;
    long value;
    long[] baseExp;

    int rollCount = 0;
    List<Long> memo;

    RollingHash(long[] arr) {
        n = arr.length;
        baseExp = initExp(n);
        value = initValue(arr);
        memo = new ArrayList<>(n);
        for (long l : arr) {
            memo.add(l);
        }
    }

    private long[] initExp(int n) {
        long[] exps = new long[n + 1];
        exps[0] = 1;
        for (int i = 1; i <= n; i++) {
            exps[i] = exps[i-1]*BASE;
        }
        return exps;
    }

    private long initValue(long[] arr) {
        long v = 0;
        for (int i = 0; i < n; i++) {
            v += arr[i] * baseExp[n-i-1];
        }
        return v;
    }

    private long roll(long push) {
        long remove = memo.get(rollCount);
        memo.add(push);

        value *= BASE;
        value -= remove * baseExp[n];
        value += push;

        rollCount++;
        return remove;
    }

    private long set(int i, long v) {
        long remove = memo.get(rollCount+i);
        memo.set(rollCount+i, v);

        value -= remove * baseExp[n-i-1];
        value += v * baseExp[n-i-1];

        return remove;
    }

    private List<Long> getCurrent() {
        List<Long> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(memo.get(rollCount+i));
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollingHash that = (RollingHash) o;
        if (this.value != that.value) return false;
        return this.getCurrent().equals(that.getCurrent());
    }
}
