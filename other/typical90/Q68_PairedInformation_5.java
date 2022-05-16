import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q68_PairedInformation_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        SumSegTree segTree = new SumSegTree(new long[n - 1]);
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int x = nextInt()-1;
            int y = nextInt()-1;
            long v = nextLong();
            if (t == 0) {
                if (unionFind.same(x,y)) continue;
                if (x % 2 == 1) v = -v;
                segTree.addValue(x, v);
                unionFind.unite(x,y);
            } else {
                int l = Math.min(x,y);
                int r = Math.max(x,y);

                if (!unionFind.same(l, r)) {
                    out.println("Ambiguous");
                    continue;
                }

                long value = segTree.query(l, r);

                long ans = 0;
                if (l % 2 == 0 ) {
                    if (r % 2 == 1) {
                        ans = value - v;
                    } else {
                        if (x < y) {
                            ans = - value + v;
                        } else {
                            ans = value + v;
                        }
                    }
                } else {
                    if (r % 2 == 1) {
                        if (x < y) {
                            ans = value + v;
                        } else {
                            ans = - value + v;
                        }
                    } else {
                        ans = - value - v;
                    }
                }
                out.println(ans);
            }
        }


        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

    private static class SumSegTree {

        private static final long UNIT = 0;

        int n;
        long[] tree;
        long[] subTree;

        SumSegTree(long[] array) {
            int len = array.length;
            n = getSize(len);
            tree = new long[2 * n - 1];
            initTree(array, len);
            subTree = new long[2 * n - 1];
            Arrays.fill(subTree, UNIT);
        }

        private int getSize(final int len) {
            int exp = 1;
            while (len > exp) {
                exp *= 2;
            }
            return exp;
        }

        private void initTree(final long[] array, final int len) {
            Arrays.fill(tree, UNIT);
            for (int i = 0; i < len; i++) {
                tree[i + n - 1] = array[i]; // 葉のindexはn-1から2n-2まで
            }
            for (int i = n - 2; i >= 0; i--) {
                updateNode(i);
            }
        }

        private void updateNode(final int i) {
            tree[i] = tree[lChildOf(i)] + tree[rChildOf(i)];
        }

        /**
         * 元の配列に値を更新する。
         * 親のnodeに遡っての更新もする。
         *
         * @param i     元の配列のindex
         * @param value 更新後の値
         */
        public void updateValue(int i, long value) {
            int index = i + n - 1;
            tree[index] = value;
            while (index > 0) {
                index = parentOf(index);
                updateNode(index);
            }
        }

        /**
         * 元の配列に値を足す。
         * 親のnodeに遡っての更新もする。
         *
         * @param i     元の配列のindex
         * @param value 足す値
         */
        public void addValue(int i, long value) {
            int index = i + n - 1;
            tree[index] += value;
            while (index > 0) {
                index = parentOf(index);
                updateNode(index);
            }
        }

        public void updateRange(int l, int r, long value) {
            doUpdateRange(l, r, value, 0, 0, n);
        }

        /**
         * 値を更新する範囲が、今調べている範囲より広い場合はそのまま更新する
         * 値を更新する範囲が、今調べている範囲と一切被らない場合は何もしない
         * そうでない場合は子に対して再度このメソッドを実行する
         *
         * @param l 更新範囲の左端（inclusive）
         * @param r 更新範囲の右端（exclusive）
         * @param value 更新後の値
         * @param node 今更新しようとしているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        public void doUpdateRange(int l, int r, long value, int node, int lEdge, int rEdge) {
            eval(node); // 以前の範囲更新の結果を先に反映させておく。
            if (rEdge <= l || r <= lEdge) { return; }
            if (l <= lEdge && rEdge <= r) {
                subTree[node] = (r-l) + value;
                eval(node);
                return;
            }
            doUpdateRange(l, r, value, lChildOf(node), lEdge, (lEdge+rEdge)/2);
            doUpdateRange(l, r, value, rChildOf(node), (lEdge+rEdge)/2, rEdge);
            tree[node] = tree[lChildOf(node)] + tree[rChildOf(node)];
        }

        public void addRange(int l, int r, long value) {
            doAddRange(l, r, value, 0, 0, n);
        }

        /**
         * 値を更新する範囲が、今調べている範囲より広い場合はそのまま更新する
         * 値を更新する範囲が、今調べている範囲と一切被らない場合は何もしない
         * そうでない場合は子に対して再度このメソッドを実行する
         *
         * @param l 更新範囲の左端（inclusive）
         * @param r 更新範囲の右端（exclusive）
         * @param value 更新後の値
         * @param node 今更新しようとしているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        public void doAddRange(int l, int r, long value, int node, int lEdge, int rEdge) {
            eval(node); // 以前の範囲更新の結果を先に反映させておく。
            if (rEdge <= l || r <= lEdge) { return; }
            if (l <= lEdge && rEdge <= r) {
                subTree[node] += ((r-l) * value);
                eval(node);
                return;
            }
            doAddRange(l, r, value, lChildOf(node), lEdge, (lEdge+rEdge)/2);
            doAddRange(l, r, value, rChildOf(node), (lEdge+rEdge)/2, rEdge);
            tree[node] = tree[lChildOf(node)] + tree[rChildOf(node)];
        }


        /**
         * 区間の和を求める
         * 実装的には、親から子に下りながら見る。
         *
         *
         * @param l 左端（inclusive）
         * @param r 右端（exclusive）
         */
        public long query(int l, int r) {
            return doQuery(Math.min(l, r), Math.max(l, r), 0, 0, n);
        }

        /**
         * 和の欲しい範囲が、今調べているnodeと被っていなかったらINFを返す。
         * 和の欲しい範囲が広かったら、nodeの値をそのまま返す。
         * 和の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
         *
         * @param l 最小値の欲しい範囲の左端（inclusive）
         * @param r 最小値の欲しい範囲の右端（exclusive）
         * @param node 今調べているnode
         * @param lEdge nodeが表す範囲の左端（inclusive）
         * @param rEdge nodeが表す範囲の右端（exclusive）
         */
        private long doQuery(int l, int r, int node, int lEdge, int rEdge) {
            eval(node);
            if (rEdge <= l || r <= lEdge) { return UNIT; }
            if (l <= lEdge && rEdge <= r) { return tree[node]; }
            return doQuery(l, r, lChildOf(node), lEdge, (lEdge+rEdge)/2) +
                doQuery(l, r, rChildOf(node), (lEdge+rEdge)/2, rEdge);
        }

        private void eval(int node) {
            if (subTree[node] == UNIT) { return; }
            if (node < n - 1) { // 葉ではない場合
                subTree[lChildOf(node)] += subTree[node]/2;
                subTree[rChildOf(node)] += subTree[node]/2;
            }
            tree[node] += subTree[node];
            subTree[node] = UNIT;
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
    }

    private static class UnionFind {
        int[] parents; // 親（根）の情報を持つ
        int[] ranks; // 深さの最大値の情報を持つ（複雑度と同じくらいに考えておく。）
        int[] sizes;

        UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
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

        private int size(int x) {
            return sizes[find(x)];
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
                sizes[yParent] += sizes[xParent];
            } else if (yRank < xRank) {
                parents[yParent] = xParent;
                sizes[xParent] += sizes[yParent];
            } else { // xRank == yRank
                parents[xParent] = yParent;
                ranks[xParent]++;
                sizes[yParent] += sizes[xParent];
            }
        }
    }

}