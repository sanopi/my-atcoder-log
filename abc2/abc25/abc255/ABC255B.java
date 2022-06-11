import java.io.PrintWriter;
import java.util.Scanner;

public class ABC255B {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = nextInt()-1;
        }
        int[] xx = new int[n];
        int[] yy = new int[n];
        for (int i = 0; i < n; i++) {
            xx[i] = nextInt();
            yy[i] = nextInt();
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            double tmp = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                int aj = a[j];
                long xi = xx[i];
                long xj = xx[aj];
                long yi = yy[i];
                long yj = yy[aj];
                tmp = Math.min(tmp, Math.sqrt((xi-xj)*(xi-xj)+(yi-yj)*(yi-yj)));
            }
            ans = Math.max(ans, tmp);
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int i;
        double dist;
        public Pair(int i, double dist) {
            this.i = i;
            this.dist = dist;
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