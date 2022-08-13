import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC264F {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[] r = nextIntArray(h);
        int[] c = nextIntArray(w);
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        long[][][] ans = new long[8][h][w];
        for (long[][] an : ans) {
            for (long[] longs : an) {
                Arrays.fill(longs, Long.MAX_VALUE);
            }
        }
        if (g[0][0] == '0') {
            ans[0][0][0] = 0;
            ans[5][0][0] = r[0];
            ans[3][0][0] = c[0];
            ans[6][0][0] = r[0]+c[0];
        } else {
            ans[1][0][0] = 0;
            ans[4][0][0] = r[0];
            ans[2][0][0] = c[0];
            ans[7][0][0] = r[0]+c[0];
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int row = 0; row < 2; row++) {
                    for (int column = 0; column < 2; column++) {
                        for (int wb = 0; wb < 2; wb++) {
                            long cost = ans[row*4+column*2+wb][i][j];
                            if (cost == Long.MAX_VALUE) continue;
                            // 右移動
                            if (j < w-1) {
                                int ni = i;
                                int nj = j+1;
                                if (((g[ni][nj]-'0') ^ row) == wb) {
                                    if (ans[row*4+wb][ni][nj] > cost) {
                                        ans[row*4+wb][ni][nj] = cost;
                                    }
                                } else {
                                    if (ans[row*4+2+wb][ni][nj] > cost + c[nj]) {
                                        ans[row*4+2+wb][ni][nj] = cost + c[nj];
                                    }
                                }
                            }
                            // 下移動
                            if (i < h-1) {
                                int ni = i+1;
                                int nj = j;
                                if (((g[ni][nj]-'0') ^ column) == wb) {
                                    if (ans[column*2+wb][ni][nj] > cost) {
                                        ans[column*2+wb][ni][nj] = cost;
                                    }
                                } else {
                                    if (ans[4+column*2+wb][ni][nj] > cost + r[ni]) {
                                        ans[4+column*2+wb][ni][nj] = cost + r[ni];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long result = Long.MAX_VALUE;
        for (long[][] l : ans) {
                    result = Math.min(result, l[h - 1][w - 1]);
        }
        out.println(result);
        out.flush();
    }

    private static class P {
        int i;
        int j;
        int row;
        int column;
        int wb;
        long cost;
        public P(int i, int j, int row, int column, int wb, long cost) {
            this.i = i;
            this.j = j;
            this.row = row;
            this.column = column;
            this.wb = wb;
            this.cost = cost;
        }
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

}