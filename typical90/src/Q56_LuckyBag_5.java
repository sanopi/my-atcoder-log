import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q56_LuckyBag_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int s = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
        }

        boolean[][] dp = new boolean[n+1][s+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                if (!dp[i][j]) { continue; }
                if (j+a[i] <= s) {
                    dp[i+1][j+a[i]] = true;
                }
                if (j+b[i] <= s) {
                    dp[i+1][j+b[i]] = true;
                }
            }
        }

        if (!dp[n][s]) {
            System.out.println("Impossible");
            return;
        }

        int yen = s;
        List<String> ansRev = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            if (yen-a[i] >= 0) {
                if (dp[i][yen-a[i]]) {
                    yen = yen-a[i];
                    ansRev.add("A");
                    continue;
                }
            }
            if (yen-b[i] >= 0) {
                if (dp[i][yen-b[i]]) {
                    yen = yen-b[i];
                    ansRev.add("B");
                    continue;
                }
            }
            System.out.println("Impossible");
            return;
        }

        Collections.reverse(ansRev);
        out.println(String.join("", ansRev));
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

}