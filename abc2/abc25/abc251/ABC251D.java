import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC251D {

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 99; i++) {
            ans.add(i);
        }
        for (int i = 100; i <= 9900; i+=100) {
            ans.add(i);
        }
        for (int i = 10000; i <= 990000; i+=10000) {
            ans.add(i);
        }

        out.println(ans.size());
        for (Integer an : ans) {
            out.print(an + " ");
        }
        out.println();
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