import java.util.Arrays;

class MergeSortTree {
    int n;
    Inner[] tree;

    private static class Inner {
        long[] sorted;
        long[] sortedSum;
        public Inner(long[] sorted, long[] sortedSum) {
            this.sorted = sorted;
            this.sortedSum = sortedSum;
        }

        private Inner merge(Inner other) {
            if (other == null) return this;
            long[] a = this.sorted;
            long[] b = other.sorted;
            long[] merged = new long[a.length+b.length];
            int ai = 0;
            int bi = 0;
            while (ai < a.length && bi < b.length) {
                if (a[ai] < b[bi]) {
                    merged[ai+bi] = a[ai++];
                } else {
                    merged[ai+bi] = b[bi++];
                }
            }
            for (int i = ai; i < a.length; i++) {
                merged[i+bi] = a[i];
            }
            for (int i = bi; i < b.length; i++) {
                merged[ai+i] = b[i];
            }
            long[] sum = new long[merged.length+1];
            for (int i = 0; i < merged.length; i++) {
                sum[i+1] = sum[i] + merged[i];
            }
            return new Inner(merged, sum);
        }
    }

    MergeSortTree(long[] array) {
        int len = array.length;
        n = getSize(len);
        tree = new Inner[2 * n - 1];
        initTree(array, len);
    }

    private int getSize(final int len) {
        int exp = 1;
        while (len > exp) {
            exp *= 2;
        }
        return exp;
    }

    private void initTree(final long[] array, final int len) {
        Arrays.fill(tree, null);
        for (int i = 0; i < len; i++) {
            tree[i + n - 1] = new Inner(
                new long[] { array[i] },
                new long[] { 0, array[i] }
            ); // 葉のindexはn-1から2n-2まで
        }
        for (int i = n - 2; i >= 0; i--) {
            updateNode(i);
        }
    }

    private void updateNode(final int i) {
        tree[i] = tree[lChildOf(i)] != null
            ? tree[lChildOf(i)].merge(tree[rChildOf(i)])
            : tree[rChildOf(i)];
    }

    /**
     * 区間の値を求める
     * 実装的には、親から子に下りながら見る。
     *
     * @param l 左端（inclusive）
     * @param r 右端（exclusive）
     */
    public long query(int l, int r, long value) {
        return doQuery(Math.min(l, r), Math.max(l, r), value, 0, 0, n);
    }

    /**
     * 値の欲しい範囲が、今調べているnodeと被っていなかったらunitを返す。
     * 値の欲しい範囲が広かったら、nodeの値をそのまま返す。
     * 値の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
     *
     * @param l     値の欲しい範囲の左端（inclusive）
     * @param r     値の欲しい範囲の右端（exclusive）
     * @param node  今調べているnode
     * @param lEdge nodeが表す範囲の左端（inclusive）
     * @param rEdge nodeが表す範囲の右端（exclusive）
     */
    private long doQuery(int l, int r, long value, int node, int lEdge, int rEdge) {
        if (rEdge <= l || r <= lEdge) {
            return 0;
        }
        if (l <= lEdge && rEdge <= r) {
            int index = upperBound(tree[node].sorted, value);
            return tree[node].sortedSum[index];
        }
        return doQuery(l, r, value, lChildOf(node), lEdge, (lEdge + rEdge) / 2)
            + doQuery(l, r, value, rChildOf(node), (lEdge + rEdge) / 2, rEdge)
        ;
    }

    private int lChildOf(int i) {
        return i * 2 + 1;
    }

    private int rChildOf(int i) {
        return lChildOf(i) + 1;
    }

    private int parentOf(int i) {
        return (i - 1) / 2;
    }

    private static int upperBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }
}