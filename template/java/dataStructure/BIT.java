import java.util.Arrays;

class BIT {
    int n;
    long[] tree;
    BIT(int n) {
        this.n=n;
        tree = new long[n+1];
    }
    public void add(int i, long v) {
        for (int index = i+1; index <= n; index += (index & -index)) {
            tree[index]+=v;
        }
    }
    public long sum(int i) {
        if (i<0) return 0;
        long res = 0;
        for (int index = i+1; index > 0; index -= (index & -index)) {
            res += tree[index];
        }
        return res;
    }

    public static long calcInvCount(int[] array) {
        int len = array.length;
        int max = Arrays.stream(array).max().getAsInt();
        BIT bit = new BIT(max);
        long count = 0;
        for (int i = 0; i < len; i++) {
            bit.add(array[i], 1);
            count += (i+1-bit.sum(array[i]));
        }
        return count;
    }
}

