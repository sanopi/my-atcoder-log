import java.io.PrintWriter;
import java.util.Scanner;

public class Q87_ChokudaisDemand_5 {

    private static int[][] a;
    private static int p;
    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        p = nextInt();
        int k = nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }

        long min;
        {
            long ok = 0;
            long ng = Long.MAX_VALUE/2;
            while (ng-ok>1) {
                long mid = (ok+ng)/2;
                long[][] costs = getMinCosts(mid);
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        if (costs[i][j] <= p) count++;
                    }
                }
                if (count > k) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            min = ok+1;
        }

        long max;
        {
            long ok = Long.MAX_VALUE/2;
            long ng = 0;
            while (ok-ng>1) {
                long mid = (ok+ng)/2;
                long[][] costs = getMinCosts(mid);
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = i+1; j < n; j++) {
                        if (costs[i][j] <= p) count++;
                    }
                }
                if (count < k) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            max = ok-1;
        }

        if (min > Integer.MAX_VALUE && max > Integer.MAX_VALUE) {
            out.println(0);
        } else if (max > Integer.MAX_VALUE) {
            out.println("Infinity");
        } else {
            out.println(max - min + 1);
        }
        out.flush();
    }

    private static long[][] getMinCosts(long mid) {
        long[][] costs = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = a[i][j]>=0 ? a[i][j] : mid;
            }
        }
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][l] + costs[l][j]);
                }
            }
        }
        return costs;
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