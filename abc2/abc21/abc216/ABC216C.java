import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC216C {

    public static void main(String[] args) {
        long n = nextLong();

        int i = 0;
        List<String> revAns = new ArrayList<>();
        while (true) {
            if ((1L << i) > n) {
                break;
            }
            if ((n & (1L << i)) != 0) {
                revAns.add("A");
            }
            revAns.add("B");
            i++;
        }

        for (int i1 = revAns.size() - 1; i1 >= 0; i1--) {
            out.print(revAns.get(i1));
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