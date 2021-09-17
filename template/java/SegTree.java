import java.util.Arrays;

class SegTree {

    private static final int INF = Integer.MAX_VALUE;

    int n;
    int[] nodes;

    SegTree(int[] array) {
        int len = array.length;
        n = getSize(len);
        initNodes(array, len);
    }

    private int getSize(final int len) {
        int exp = 1;
        while (len > exp) {
            exp *= 2;
        }
        return exp;
    }

    private void initNodes(final int[] array, final int len) {
        nodes = new int[2 * n - 1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            nodes[i + n - 1] = array[i]; // 葉のindexはn-1から2n-2まで
        }
        for (int i = n - 2; i >= 0; i--) {
            updateNode(i);
        }
    }

    private void updateNode(final int i) {
        nodes[i] = Math.min(nodes[leftChildOf(i)], nodes[rightChildOf(i)]);
    }

    /**
     * 元の配列の値を更新する。
     * 親のnodeに遡っての更新もする。
     *
     * @param i     元の配列のindex
     * @param value 更新後の値
     */
    public void updateValue(int i, int value) {
        int index = i + n - 1;
        nodes[index] = value;
        while (index > 0) {
            index = parentOf(index);
            updateNode(index);
        }
    }

    /**
     * 区間の最小値を求める
     * 実装的には、親から子に下りながら見る。
     *
     *
     * @param l 左端（inclusive）
     * @param r 右端（exclusive）
     */
    public int getMin(int l, int r) {
        return doGetMin(Math.min(l, r), Math.max(l, r), 0, 0, n);

    }

    /**
     * 最小値の欲しい範囲が、今調べているnodeと被っていなかったらINFを返す。
     * 最小値の欲しい範囲が広かったら、nodeの値をそのまま返す。
     * 最小値の欲しい範囲が狭かったら、nodeの子に対して再度このメソッドを実行する。
     *
     * @param l 最小値の欲しい範囲の左端（inclusive）
     * @param r 最小値の欲しい範囲の右端（exclusive）
     * @param node 今調べているnode
     * @param leftEdge nodeが表す範囲の左端（inclusive）
     * @param rightEdge nodeが表す範囲の右端（exclusive）
     */
    private int doGetMin(int l, int r, int node, int leftEdge, int rightEdge) {
        if (rightEdge < l || r < leftEdge) { return INF; }
        if (l < leftEdge && rightEdge < r) { return nodes[node]; }
        return Math.min(
            doGetMin(l, r, leftChildOf(node), leftEdge, (leftEdge+rightEdge)/2),
            doGetMin(l, r, rightChildOf(node), (leftEdge+rightEdge)/2, rightEdge)
        );
    }


    private int leftChildOf(int i) {
        return i * 2 + 1;
    }

    private int rightChildOf(int i) {
        return leftChildOf(i) + 1;
    }

    private int parentOf(int i) {
        return (i - 1) / 2;
    }
}
