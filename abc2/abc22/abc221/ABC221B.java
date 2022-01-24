import java.io.PrintWriter;
import java.util.Scanner;

public class ABC221B {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        char[] t = next().toCharArray();
        boolean ok = true;
        int count = 0;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == t[i]) {
                continue;
            }
            if (s[i] == t[i+1] && s[i+1] == t[i]) {
                i++;
                count++;
                continue;
            }
            ok = false;
            break;
        }

        if (ok && count<=1) {
            out.println("Yes");
        } else {
            out.println("No");
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