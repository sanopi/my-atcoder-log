import java.io.PrintWriter;
import java.util.Scanner;

public class ABC184D {

    private static double[][][] memo;
    private static int a;
    private static int b;
    private static int c;
    public static void main(String[] args) {
        a = nextInt();
        b = nextInt();
        c = nextInt();
        memo = new double[101][101][101];

        out.println(solve(a, b, c));
        out.flush();
    }

    private static double solve(int a, int b, int c) {
        if (a==100||b==100||c==100) {
            return 0;
        }
        if (memo[a][b][c] > 0) {
            return memo[a][b][c];
        }
        double res = 0;
        res += (solve(a+1, b, c) + 1) *  ((double)a /(a+b+c));
        res += (solve(a, b+1, c) + 1) *  ((double)b /(a+b+c));
        res += (solve(a, b, c+1) + 1) *  ((double)c /(a+b+c));
        return memo[a][b][c] = res;
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