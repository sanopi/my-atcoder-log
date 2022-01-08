import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC217D {

    public static void main(String[] args) {
        int l = nextInt();
        int q = nextInt();

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        ts.add(l);

        for (int i = 0; i < q; i++) {
            int c = nextInt();
            if (c == 1) {
                ts.add(nextInt());
            } else {
                int x = nextInt();
                out.println(ts.higher(x) - ts.lower(x));
            }
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
