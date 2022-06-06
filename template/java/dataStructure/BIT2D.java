package dataStructure;

class BIT2D {
    int h;
    int w;
    long[][] tree;
    BIT2D(int h, int w) {
        this.h=h;
        this.w=w;
        tree = new long[h+1][w+1];
    }
    private void add(int h, int w, long v) {
        for (int hi = h+1; hi <= this.h; hi += (hi & -hi)) {
            for (int wi = w+1; wi <= this.w; wi += (wi & -wi)) {
                tree[hi][wi]+=v;
            }
        }
    }
    private long sum(int h, int w) {
        if (h<0 || w < 0) return 0;
        long res = 0;
        for (int hi = h+1; hi > 0; hi -= (hi & -hi)) {
            for (int wi = w+1; wi > 0; wi -= (wi & -wi)) {
                res += tree[hi][wi];
            }
        }
        return res;
    }

    private long query(int h1, int w1, int h2, int w2) {
        return sum(h2, w2) - sum(h2, w1 - 1) - sum(h1 - 1, w2) + sum(h1 - 1, w1 - 1);
    }
}

