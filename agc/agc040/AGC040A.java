import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC040A {

    public static void main(String[] args) {
        char[] chars = next().toCharArray();
        int n = chars.length;

        long[] ans = new long[n+1];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '<') {
                ans[i+1] = Math.max(ans[i+1], ans[i]+1);
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (chars[i] == '>') {
                ans[i] = Math.max(ans[i], ans[i+1]+1);
            }
        }
        System.out.println(Arrays.stream(ans).sum());
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