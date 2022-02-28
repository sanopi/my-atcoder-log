import java.io.PrintWriter;
import java.util.Scanner;

public class ABC053D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }
        int over1Count = 0;
        int evenCount = 0;
        for (int i : count) {
            if (i >= 1) over1Count++;
            if (i >= 1 && i%2 == 0) evenCount++;
        }
        out.println(over1Count - evenCount%2);
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