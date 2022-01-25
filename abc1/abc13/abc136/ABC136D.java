import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC136D {

    private static char[] g;
    private static int[][] memo;

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        g = s.toCharArray();
        memo = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[memoRec(0, i)]++;
        }
        for (int a : ans) {
            out.print(a + " ");
        }
        out.flush();
    }

    private static int memoRec(int parity, int current) {
        if (memo[parity][current] >= 0) {
            return memo[parity][current];
        }
        int next = getNext(current);
        int nextNext = getNext(next);
        if (current == nextNext) {
            memo[0][current] = current;
            memo[1][current] = next;
            return memo[parity][current];
        }
        int res = memoRec(1-parity, next);
        memo[parity][current] = res;
        return res;
    }

    private static int getNext(int current) {
        return current + (g[current] == 'R' ? 1 : -1);
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