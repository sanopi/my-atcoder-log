class UnionFind {
    int[] parents; // 親（根）の情報を持つ
    int[] ranks; // 深さの最大値の情報を持つ（複雑度と同じくらいに考えておく。）

    UnionFind(int n) {
        parents = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            ranks[i] = 0;
        }
    }

    private int find(int x) {
        int parent = parents[x];
        if (x == parent) {
            return x;
        }
        parents[x] = find(parent); // 圧縮（木の繋ぎ直し）
        return parents[x];
    }

    private boolean same(int x, int y) {
        return find(x) == find(y);
    }

    private void unite(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            return;
        }

        int xRank = ranks[xParent];
        int yRank = ranks[yParent];
        if (xRank < yRank) {
            parents[xParent] = yParent;
        } else if (yRank < xRank) {
            parents[yParent] = xParent;
        } else { // xRank == yRank
            parents[xParent] = yParent;
            ranks[xParent]++;
        }
    }
}
