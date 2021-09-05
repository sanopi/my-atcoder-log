import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class ABC217B {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("ABC");
        set.add("ARC");
        set.add("AGC");
        set.add("AHC");
        for (int i = 0; i < 3; i++) {
            set.remove(next());
        }
        for (String o : set) {
            out.println(o);
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