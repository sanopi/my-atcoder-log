import java.io.PrintWriter;
import java.util.Scanner;

public class ABC063C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] s = nextIntArray(n);
        boolean[] dp = new boolean[10001];
        dp[0] = true;
        for (int i = 0; i < s.length; i++) {
            for (int j = dp.length-1-s[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j+s[i]] = true;
                }
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if (i % 10 != 0 && dp[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
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