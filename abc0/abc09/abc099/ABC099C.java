import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC099C {

    public static void main(String[] args) {
        int n = nextInt();
        List<Integer> kingaku = new ArrayList<>();
        kingaku.add(1);
        int i = 6;
        while (i<=n) { kingaku.add(i);i*=6; }
        i=9;
        while (i<=n) { kingaku.add(i);i*=9; }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (Integer money : kingaku) {
            for (int j = 1; j <= n; j++) {
                int prev = j - money;
                dp[j] = Math.min(dp[j], prev>=0?dp[prev]+1:Integer.MAX_VALUE);
            }
        }
        out.println(dp[n]);
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