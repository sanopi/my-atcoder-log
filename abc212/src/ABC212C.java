import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC212C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = nextInt();
        }
        Arrays.sort(b);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            int index = Arrays.binarySearch(b, ai);
            if (index < 0) {
                index = -(index + 1);
            }
            int diff1 = Integer.MAX_VALUE;
            int diff2 = Integer.MAX_VALUE;
            if (index < m) { diff1 = Math.abs(ai - b[index]); }
            if (index > 0) { diff2 = Math.abs(ai - b[index-1]); }
            int diff = Math.min(diff1, diff2);
            if (diff < min) {
                min = diff;
            }
        }

        out.println(min);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}