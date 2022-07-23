import java.io.PrintWriter;
import java.util.Scanner;

public class ABC261B {

    public static void main(String[] args) {
        int n = nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char s = a[i][j];
                char t = a[j][i];
                if ((s == 'W' && t != 'L') ||
                    (s == 'D' && t != 'D') ||
                    (s == 'L' && t != 'W')
                ) {
                    ok = false;
                    break;
                }
            }
        }
        out.println(ok ? "correct" : "incorrect");
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
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}