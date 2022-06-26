import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC184F {

    public static void main(String[] args) {
        int n = nextInt();
        long t = nextInt();
        int[] a = nextIntArray(n);
        List<Long> list = new ArrayList<>();
        int m = n/2;
        for (int i = 0; i < 1 << m; i++) {
            long p = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1<<j)) != 0) {
                    p += a[j];
                }
            }
            list.add(p);
        }
        list.sort(Comparator.naturalOrder());

        int k = n-m;
        long ans = 0;
        for (int i = 0; i < 1 << k; i++) {
            long p = 0;
            for (int j = 0; j < k; j++) {
                if ((i & (1<<j)) != 0) {
                    p += a[j+m];
                }
            }

            if (t-p < 0) continue;
            int found = upperBound(list, t - p+1);
            Long add = found == 0 ? 0 : list.get(found-1);
            if (add+p > t) {
                continue;
            }
            ans = Math.max(ans, p+add);
        }
        out.println(ans);
        out.flush();
    }

    private static int upperBound(List<Long> a, long key) {
        int ok = a.size();
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a.get(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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