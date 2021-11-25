import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Predicate;

import static java.lang.Math.max;
import static java.util.Arrays.fill;

public class Q60_Chimera_5 {

    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        int[] a = nextIntArray(n);

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        fill(dp1, Integer.MAX_VALUE);
        fill(dp2, Integer.MAX_VALUE);

        int[] l = new int[n];
        int[] r = new int[n];

        int dp1Index = -1;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            int index = binarySearch(-1, ++dp1Index, j -> ai <= dp1[j]);
            index = max(index, 0);
            dp1[index] = ai;
            l[i] = index+1;
        }

        int dp2Index = -1;
        for (int i = 0; i < n; i++) {
            int ai = a[invert(i)];
            int index = binarySearch(-1, ++dp2Index, j -> ai <= dp2[j]);
            index = max(index, 0);
            dp2[index] = ai;
            r[invert(i)] = index+1;
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            max = max(max, l[i] + r[i] -1);
        }

        out.println(max);
        out.flush();
    }

    private static int binarySearch(int ng, int ok, Predicate<Integer> condition) {
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;
            if (condition.test(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return condition.test(ok) ? ok : ng;
    }

    private static int invert(int i) {
        return n-1 - i;
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