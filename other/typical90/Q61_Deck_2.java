import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q61_Deck_2 {

    public static void main(String[] args) {
        int q = nextInt();
        List<Integer> f = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int x = nextInt();
            if (t == 1) {
                b.add(x);
            } else if (t == 2) {
                f.add(x);
            } else {
                int bSize = b.size();
                if (bSize >= x) {
                    out.println(b.get(bSize-x));
                } else {
                    out.println(f.get(x-bSize-1));
                }
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}