import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B_Frog2 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] h = nextIntArray(n);

        int[] dp = new int[n];
        Arrays.fill(dp, 1000000000);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && j <= i + k; j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(h[j] - h[i]));
            }
        }
        out.println(dp[n-1]);
        out.flush();
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
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}