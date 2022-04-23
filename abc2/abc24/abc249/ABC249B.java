import java.io.PrintWriter;
import java.util.Scanner;

public class ABC249B {

    public static void main(String[] args) {
        String s = next();
        int[] count = new int[10000];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean hasDuplicate = false;
        for (int i : count) {
            if (i>1) {
                hasDuplicate=true;
            }
        }

        if (!s.equals(s.toUpperCase()) && !s.equals(s.toLowerCase()) && !hasDuplicate) {
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