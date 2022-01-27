import java.io.PrintWriter;
import java.util.Scanner;

public class ABC054B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        char[][] a = new char[n][n];
        char[][] b = new char[m][m];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        for (int i = 0; i < m; i++) {
            b[i] = next().toCharArray();
        }

        boolean ok = true;
        out.println(isOk(n, m, a, b)?"Yes":"No");

        out.flush();
    }
    private static boolean isOk(int n, int m, char[][] a, char[][] b) {
        boolean ok = false;
        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < n - m + 1; j++) {
                ok = ok | isOk2(m, a, b, i, j);
            }
        }
        return ok;
    }

    private static boolean isOk2(int m, char[][] a, char[][] b, int i, int j) {
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < m; l++) {
                if (a[i +k][j +l] != b[k][l]) {
                    return false;
                }
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