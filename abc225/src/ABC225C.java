import java.io.PrintWriter;
import java.util.Scanner;

public class ABC225C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = nextInt();
            }
        }
        if (!ok(matrix[0])) {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (!ok(matrix[i], matrix[i + 1])) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        out.flush();
    }

    private static boolean ok(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            if (a[i + 1] != a[i] + 1) {
                return false;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 7 == 0) {
                if (i != a.length-1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ok(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] + 7 != b[i]) {
                return false;
            }
        }
        return true;
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