import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC327C {

    private static final int[] CORRECT = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    private static void solve() {
        int[][] a = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j] = nextInt();
            }
        }
        if (row(a) && col(a) && grid(a)) {
            System.out.println("Yes");
        }else {
            System.out.println("No");

        }
        out.flush();
    }

    private static boolean row(int[][] g) {
        for (int i = 0; i < 9; i++) {
            int[] count = new int[10];
            for (int j = 0; j < 9; j++) {
                count[g[i][j]]++;
            }
            if (!Arrays.equals(count, CORRECT)) {
                return false;
            }
        }
        return true;
    }

    private static boolean col(int[][] g) {
        for (int j = 0; j < 9; j++) {
            int[] count = new int[10];
            for (int i = 0; i < 9; i++) {
                count[g[i][j]]++;
            }
            if (!Arrays.equals(count, CORRECT)) {
                return false;
            }
        }
        return true;
    }

    private static boolean grid(int[][] g) {
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] count = new int[10];
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        count[g[i+ii][j+jj]]++;
                    }
                }
                if (!Arrays.equals(count, CORRECT)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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