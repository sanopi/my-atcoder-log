import java.io.PrintWriter;
import java.util.Scanner;

public class Q66_VariousArrays_5 {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            a[i] = new Pair(l,r);
        }
        double ans = 0.0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                double tmp = a[i].inverseCount(a[j]) / (a[i].count() * a[j].count());
                ans += tmp;
            }
        }

        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int l;
        int r;
        Pair(final int l, final int r) {
            this.l = l;
            this.r = r;
        }
        private double count() {
            return r - l + 1;
        }

        private double inverseCount(Pair next) {
            int count = 0;
            for (int i = l; i <= r; i++) {
                int max = Math.min(i-1, next.r);
                count += Math.max(max - next.l, -1) + 1;
            }
            return count;
        }
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