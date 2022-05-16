package dataStructure;

class BIT {
    int n;
    long[] tree;
    BIT(int n) {
        this.n=n;
        tree = new long[n+1];
    }
    private void add(int i, long v) {
        for (int index = i+1; index <= n; index += (index & -index)) {
            tree[index]+=v;
        }
    }
    private long sum(int i) {
        if (i<0) return 0;
        long res = 0;
        for (int index = i+1; index > 0; index -= (index & -index)) {
            res += tree[index];
        }
        return res;
    }
}

