import java.io.PrintWriter;
import java.util.Scanner;

public class ABC349C {

    private static void solve() {
        String s = next().toUpperCase();
        String t = next();
        char t1 = t.charAt(0);
        int indexOf1 = s.indexOf(t1);
        if (indexOf1 == -1) {
            System.out.println("No");
            return;
        }
        char t2 = t.charAt(1);
        int indexOf2 = s.indexOf(t2, indexOf1 + 1);
        if (indexOf2 == -1) {
            System.out.println("No");
            return;
        }
        char t3 = t.charAt(2);
        if (t3 != 'X') {
            int indexOf3 = s.indexOf(t3, indexOf2 + 1);
            if (indexOf3 == -1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        out.flush();
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