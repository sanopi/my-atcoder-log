import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q48_IWillNotDropOut_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        Integer[] p = new Integer[n*2];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            p[i*2] = b;
            p[i*2+1] = a-b;
        }
        Arrays.sort(p, Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += p[i];
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}