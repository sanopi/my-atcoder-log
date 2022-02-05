import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC238B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int[] cuts = new int[n+1];
        cuts[0]=0;
        for (int i = 0; i < n; i++) {
            cuts[i+1]=(cuts[i]+a[i])%360;
        }
        Arrays.sort(cuts);
        int ans = 360-cuts[n];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, cuts[i+1]-cuts[i]);
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