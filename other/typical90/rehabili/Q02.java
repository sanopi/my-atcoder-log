import java.io.PrintWriter;
import java.util.Scanner;

public class Q02 {

    private static void solve() {
        int n = nextInt();
        for (int i = 0; i < 1 << n; i++) {
            char[] chars = new char[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) ==0) {
                    chars[n-1-j] = '(';
                } else {
                    chars[n-1-j] = ')';
                }
            }
            if (isOk(chars)) {
                out.println(String.valueOf(chars));
            }
        }
        out.flush();
    }

    private static boolean isOk(char[] chars) {
        int n = chars.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
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