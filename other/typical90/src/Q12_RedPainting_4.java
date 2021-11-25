import java.io.PrintWriter;
import java.util.Scanner;

public class Q12_RedPainting_4 {

    static int h;
    static int w;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        int q = nextInt();

        boolean[][] table = new boolean[h][w];

        UnionFind unionFind = new UnionFind(h * w);

        int[] rNext = {1, 0, -1, 0};
        int[] cNext = {0, 1, 0, -1};

        for (int i = 0; i < q; i++) {
            int t = nextInt();
            if (t == 1) {
                int r = nextInt()-1;
                int c = nextInt()-1;
                table[r][c] = true;
                for (int j = 0; j < 4; j++) {
                    int nextR = r + rNext[j];
                    int nextC = c + cNext[j];
                    if (valid(nextR, nextC)) {
                        if (table[nextR][nextC]) {
                            unionFind.unite(r*w + c, nextR*w + nextC);
                        }
                    }
                }
            } else {
                int ra = nextInt()-1;
                int ca = nextInt()-1;
                int rb = nextInt()-1;
                int cb = nextInt()-1;
                boolean yes = (table[ra][ca] && table[rb][cb])
                    && unionFind.same(ra * w + ca, rb * w + cb);
                out.println(yes ? "Yes" : "No");
            }
        }
        out.flush();
    }

    private static boolean valid(int r, int c) {
        return (r >= 0) && (r < h) && (c >= 0) && (c < w);
    }

    private static class UnionFind {
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


    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
}