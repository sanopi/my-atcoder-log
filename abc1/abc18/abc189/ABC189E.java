import java.io.PrintWriter;
import java.util.Scanner;

public class ABC189E {

    private static final long[][] ROTATE_90 = {{0,1,0},{-1,0,0},{0,0,1}};
    private static final long[][] ROTATE_270 = {{0,-1,0},{1,0,0},{0,0,1}};
    private static final long[][] INVERSE_X(long p) { return new long[][]{{-1,0,2*p},{0,1,0},{0,0,1}};}
    private static final long[][] INVERSE_Y(long p) { return new long[][]{{1,0,0},{0,-1,2*p},{0,0,1}};}

    /**
     * Memo
     * 1: (x, y) -> (y, -x)
     * 2: (x, y) -> (-y, x)
     * 3: (x, y) -> (2p-x, y)
     * 4: (x, y) -> (x, 2p-y)
     */
    public static void main(String[] args) {
        int n = nextInt();
        Koma[] komas = new Koma[n];
        for (int i = 0; i < n; i++) {
            long x = nextLong();
            long y = nextLong();
            komas[i] = new Koma(x, y, i);
        }
        int m = nextInt();
        Op[] ops = new Op[m];
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            if (t <= 2) {
                ops[i] = new Op(t, 0, i);
            } else {
                ops[i] = new Op(t, nextInt(), i);
            }
        }

        long[][][] f = new long[m+1][3][3];
        f[0] = new long[][]{{1,0,0},{0,1,0},{0,0,1}};
        for (int i = 1; i <= m; i++) {
            f[i] = apply(f[i-1], ops[i-1]);
        }

        int q = nextInt();
        while (q --> 0) {
            int a = nextInt();
            int b = nextInt()-1;
            long[][] ans = multiply(f[a], new long[][]{{komas[b].x}, {komas[b].y},  {1}});
            out.println(ans[0][0] + " " + ans[1][0]);
        }
        out.flush();
    }

    private static class Koma {
        long x;
        long y;
        int i;
        public Koma(long x, long y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

    private static class Op {
        int t;
        long p;
        int i;
        public Op(int t, long p, int i) {
            this.t = t;
            this.p = p;
            this.i = i;
        }
        private long[][] getM() {
            switch (t) {
                case 1: return ROTATE_90;
                case 2: return ROTATE_270;
                case 3: return INVERSE_X(p);
                default: return INVERSE_Y(p);
            }
        }
    }

    private static long[][] apply(long[][] base, Op op) {
        return multiply(op.getM(), base);
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        int ar = a.length;
        int ac = a[0].length;
        int bc = b[0].length;
        long[][] res = new long[ar][bc];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                for (int k = 0; k < ac; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
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