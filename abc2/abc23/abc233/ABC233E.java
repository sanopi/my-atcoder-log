import java.io.PrintWriter;
import java.util.Scanner;

public class ABC233E {

    public static void main(String[] args) {
        String x = next();
        int len = x.length();
        int[] sum = new int[len];
        sum[0] = x.charAt(0)-'0';

        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + (x.charAt(i)-'0');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i > 0; i--) {
            int si = sum[i];
            sb.append(si % 10);
            sum[i-1] += si/10;
        }
        out.println(sb.reverse().insert(0, sum[0]));
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