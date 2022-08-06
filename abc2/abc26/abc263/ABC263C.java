import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC263C {

    private static int n;
    private static int m;
    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();
        solve(new ArrayList<>());
        out.flush();
    }

    private static void solve(List<Integer> result) {
        if (result.size() == n) {
            for (Integer i : result) {
                out.print(i + " ");
            }
            out.println();
        }
        Integer last = result.isEmpty() ? 0 : result.get(result.size() - 1);
        for (int i = last+1; i <= m; i++) {
            result.add(i);
            solve(result);
            result.remove((Integer) i);
        }
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