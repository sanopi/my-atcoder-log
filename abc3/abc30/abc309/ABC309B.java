import java.io.PrintWriter;
import java.util.Scanner;

public class ABC309B {

    public static void main(String[] args) {
        int n = nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        out.print(a[1][0]);
        for (int i = 1; i < n; i++) {
            out.print(a[0][i-1]);
        }
        out.println();
        for (int i = 1; i < n-1; i++) {
            out.print(a[i+1][0]);
            for (int j = 1; j < n-1; j++) {
                out.print(a[i][j]);
            }
            out.print(a[i-1][n-1]);
            out.println();
        }
        for (int i = 1; i < n; i++) {
            out.print(a[n-1][i]);
        }
        out.print(a[n-2][n-1]);
        out.println();

        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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