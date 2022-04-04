import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class K_Stones {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

//        solve1(n, k, a);
        solve2(n, k, a);
        out.flush();
    }

    private static void solve2(int n, int k, int[] a) {
        int[] grundy = new int[k+1];
        Arrays.fill(grundy, -1);
        grundy[0] = 0;
        for (int i = 0; i <= k; i++) {
            boolean[] appears = new boolean[n+1];
            for (int j = 0; j < n; j++) {
                if (i-a[j] < 0) continue;
                appears[grundy[i-a[j]]] = true;
            }
            for (int j = 0; j < n+1; j++) {
                if (!appears[j]) {
                    grundy[i] = j;
                    break;
                }
            }
        }
        out.println(grundy[k]!=0?"First":"Second");
    }

    private static void solve1(int n, int k, int[] a) {
        boolean[] dp = new boolean[k +1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (!dp[i] && i+ a[j]<= k) {
                    dp[i+ a[j]] = true;
                }
            }
        }
        out.println(dp[k]?"First":"Second");
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