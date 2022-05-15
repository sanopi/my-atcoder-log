import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC251B {

    public static void main(String[] args) {
        int n = nextInt();
        int w = nextInt();
        int[] a = nextIntArray(n);

        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i]<=w) {
                ans.add(a[i]);

            }
            for (int j = i+1; j < n; j++) {
                if (a[j]<=w) {
                    ans.add(a[j]);
                }
                if (a[i]+a[j] <= w) {
                    ans.add(a[i]+a[j]);
                }
                for (int k = j+1; k < n; k++) {
                    if (a[k] <= w) {
                        ans.add(a[k]);
                    }
                    if (a[i]+a[k] <=w) {
                        ans.add(a[i]+a[k]);
                    }
                    if (a[k]+a[j] <= w) {
                        ans.add(a[k]+a[j]);
                    }
                    if (a[i]+a[k]+a[j] <= w) {
                        ans.add(a[i]+a[k]+a[j]);
                    }
                }
            }
        }
        out.println(ans.size());
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