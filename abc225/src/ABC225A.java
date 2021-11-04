import java.io.PrintWriter;
import java.util.Scanner;

public class ABC225A {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        if (s[0] == s[1] && s[1] == s[2]) {
            System.out.println(1);
        } else if(s[0] == s[1] || s[1] == s[2] || s[0] == s[2]) {
            System.out.println(3);
        } else {
            System.out.println(6);
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