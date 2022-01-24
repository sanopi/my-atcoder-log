import java.io.PrintWriter;
import java.util.Scanner;

public class ABC116C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] hs = nextIntArray(n);

        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < 100; i++) {
            boolean continuous = false;
            for (int j = 0; j < n; j++) {
                if (result[j] < hs[j]) {
                    result[j]++;
                    if (!continuous) {
                        continuous = true;
                        count++;
                    }
                } else {
                    continuous = false;
                }
            }
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
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}