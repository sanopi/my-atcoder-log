import java.io.PrintWriter;
import java.util.Scanner;

public class ABC261E {

    public static void main(String[] args) {
        int n = nextInt();
        long c = nextInt();
        Op[] ops = new Op[n];
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            int a = nextInt();
            ops[i] = new Op(t, a);
        }

        int[][][] funcs = new int[n][30][2];

        for (int i = 0; i < n; i++) {
            Op op = ops[i];
            int[][] f = funcs[i];
            for (int j = 0; j < 30; j++) {
                int aj = Math.min(1, op.a & (1 << j));
                if (op.t == 1) {
                    // 0の時
                    f[j][0] = (i>0? funcs[i-1][j][0] : 0) & aj;
                    // 1の時
                    f[j][1] = (i>0? funcs[i-1][j][1] : 1) & aj;
                } else if (op.t == 2) {
                    // 0の時
                    f[j][0] = (i>0? funcs[i-1][j][0] : 0) | aj;
                    // 1の時
                    f[j][1] = (i>0? funcs[i-1][j][1] : 1) | aj;
                } else {
                    // 0の時
                    f[j][0] = (i>0? funcs[i-1][j][0] : 0) ^ aj;
                    // 1の時
                    f[j][1] = (i>0? funcs[i-1][j][1] : 1) ^ aj;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            int nextC = 0;
            for (int j = 0; j < 30; j++) {
                int cj = (int)Math.min(1, c & (1<<j));
                nextC += funcs[i][j][cj]<<j;
            }
            c = nextC;
            out.println(c);
        }
        out.flush();
    }

    private static final class Op {
        int t;
        int a;
        public Op(int t, int a) {
            this.t = t;
            this.a = a;
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