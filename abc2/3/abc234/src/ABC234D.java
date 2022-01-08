import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC234D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] p = nextIntArray(n);
        TreeSet<Integer> set = new TreeSet<>();

        int ans = n;
        for (int i = 0; i < k; i++) {
            set.add(p[i]);
            ans = Math.min(ans, p[i]);
        }
        out.println(ans);

        for (int i = k; i < n; i++) {
            set.add(p[i]);
            if (p[i] > ans) {
                ans = set.higher(ans);
            }
            out.println(ans);
        }

        out.flush();
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