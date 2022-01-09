import java.io.PrintWriter;
import java.util.Scanner;

public class AGC015B {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        char[] chars = s.toCharArray();

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'U') {
                ans += n-1 - i;
                ans += (i)*2;
            } else {
                // D
                ans += (n-1 - i)*2;
                ans += i;
            }
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