import java.io.PrintWriter;
import java.util.Scanner;

public class ABC312B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        char[][] s = new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i] = next().toCharArray();
        }
        for (int i = 0; i < n - 8; i++) {
            for (int j = 0; j < m - 8; j++) {
                boolean ok = true;
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        ok &= s[ii][jj] == '#';
                    }
                }
                for (int ii = i+6; ii < i + 9; ii++) {
                    for (int jj = j+6; jj < j + 9; jj++) {
                        ok &= s[ii][jj] == '#';
                    }
                }
                for (int ii = i; ii < i + 4; ii++) {
                    ok &= s[ii][j+3] == '.';
                }
                for (int jj = j; jj < j + 4; jj++) {
                    ok &= s[i+3][jj] == '.';
                }
                for (int ii = i+5; ii < i + 9; ii++) {
                    ok &= s[ii][j+5] == '.';
                }
                for (int jj = j+5; jj < j + 9; jj++) {
                    ok &= s[i+5][jj] == '.';
                }
                if (ok) {
                    out.println((i+1) + " " + (j+1) );
                }
            }
        }

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