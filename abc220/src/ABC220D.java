import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ABC220D {

    private static int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int[][] dp = new int[n][10];
        dp[0][a[0]] = 1;

        ArrayList<Integer>[][] plus = new ArrayList[10][10];
        ArrayList<Integer>[][] kakeru = new ArrayList[10][10];


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plus[i][j] = new ArrayList<>();
                kakeru[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int k = (i + j) % 10;
                plus[j][k].add(i);

                int k2 = (i * j) % 10;
                kakeru[j][k2].add(i);
            }
        }

        for (int i = 1; i < n; i++) {
            int ai = a[i];
            for (int j = 0; j < 10; j++) {
                for (final Integer integer : plus[ai][j]) {
                    dp[i][j] = ((dp[i][j] + dp[i - 1][integer]) % MOD);
                }
                for (final Integer integer : kakeru[ai][j]) {
                    dp[i][j] = ((dp[i][j] + dp[i - 1][integer]) % MOD);
                }
            }
        }

        for (final int i : dp[n-1]) {
            out.println(i);
        }
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