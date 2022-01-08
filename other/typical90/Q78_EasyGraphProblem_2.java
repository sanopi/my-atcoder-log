import java.io.PrintWriter;
import java.util.Scanner;

public class Q78_EasyGraphProblem_2 {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] counts = new int[n];
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            counts[Math.max(a, b)] += 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += counts[i] == 1 ? 1 : 0;
        }
        out.println(count);
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