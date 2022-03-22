import java.io.PrintWriter;
import java.util.Scanner;

public class ABC244C {

    public static void main(String[] args) {
        int n = nextInt();
        int max = 2*n+1;
        boolean[] done = new boolean[max];
        int t = 0;
        for (int i = 0; i < n + 1; i++) {
            while (t < max && done[t]) {
                t++;
            }

            System.out.println(t+1);
            done[t] = true;
            int res = nextInt()-1;
            if (res < 0) {
                return;
            }
            done[res] = true;
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