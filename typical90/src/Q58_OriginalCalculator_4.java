import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q58_OriginalCalculator_4 {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        long[] save = new long[100000];
        for (int i = 0; i < 100000; i++) {
            save[i] = -1;
        }

        long rest = 0;
        for (long i = 0; i < k; i++) {
            long l = save[n];
            if (l == -1) {
                save[n] = i;
                int sum = getSum(n);
                n = (n + sum) % 100000;
            } else {
                long cycle = i - l;
                rest = (k - i) % cycle;
                break;
            }
        }

        for (int i = 0; i < rest; i++) {
            int sum = getSum(n);
            n = (n + sum) % 100000;
        }
        out.println(n);
        out.flush();
    }

    private static int getSum(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
            .map(Integer::valueOf)
            .reduce((i1, i2) -> i1 + i2)
            .get();
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