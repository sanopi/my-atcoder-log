import java.io.PrintWriter;
import java.util.Scanner;

public class AGC034A {

    public static void main(String[] args) {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();
        String s = next();
        char[] chars = s.toCharArray();

        if (c<d) {
            System.out.println(s.substring(a - 1, c).contains("##") || s.substring(b - 1, d).contains("##") ? "No" : "Yes");
        } else {
            System.out.println(s.substring(b - 2, d + 1).contains("...") ? "Yes" : "No");
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