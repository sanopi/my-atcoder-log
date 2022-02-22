import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC112D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer> divs = new ArrayList<>();
        for (int i = 1; (long) i *i <= m; i++) {
            if (m%i==0) {
                divs.add(i);
                divs.add(m/i);
            }
        }
        out.println(divs.stream().filter(d -> m / d >= n).max(Comparator.naturalOrder()).get());
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