import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC216E {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        Integer[] a = nextIntArray(n);

        Arrays.sort(a, Comparator.reverseOrder());

        long[] aCount = new long[n];
        for (int i = 0; i < n; i++) {
            int ai1 = i == n-1 ? 0 : a[i+1];
            int diff = a[i] - ai1;

            long cnt = (long) diff * (i + 1);
            if (cnt <= k) {
                aCount[i] = diff;
                k -= cnt;
                continue;
            }

            int cc = k / (i + 1);
            aCount[i] = cc;

            k %= (i + 1);
            break;
        }

        for (int i = n-2; i >= 0 ; i--) {
            aCount[i] += aCount[i+1];
        }

        if (aCount[n-1] != a[n-1]) {
            for (int i = 0; i < k; i++) {
                aCount[i] += 1L;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long max = (long)a[i];
            long min = max - (aCount[i] - 1) - 1;
            long l = (max * (max + 1)) / 2;
            long l1 = (min * (min + 1)) / 2;
            ans += (l - l1);
        }
        out.println(ans);

        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
    static double nextDouble() { return Double.parseDouble(next()); }
    static Integer[] nextIntArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}