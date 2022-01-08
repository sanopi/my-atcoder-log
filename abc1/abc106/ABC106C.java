import java.io.PrintWriter;
import java.util.Scanner;

public class ABC106C {

    public static void main(String[] args) {
        String s = next();
        long k = nextLong();
        char[] chars = s.toCharArray();
        int oneLen = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                oneLen++;
            } else {
                break;
            }
        }
        if (oneLen >= k) {
            System.out.println(1);
        } else {
            System.out.println(chars[oneLen]);
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