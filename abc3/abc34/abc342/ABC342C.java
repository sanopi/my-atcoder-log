import java.io.PrintWriter;
import java.util.Scanner;

public class ABC342C {

    private static void solve() {
        int n = nextInt();
        char[] s = next().toCharArray();
        int[] chars = new int[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = i;
        }
        int q = nextInt();
        while (q --> 0) {
            int c = next().toCharArray()[0] - 'a';
            int d = next().toCharArray()[0] - 'a';
            for (int i = 0; i < 26; i++) {
                if (chars[i] == c) {
                    chars[i] = d;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int si = s[i] - 'a';
            s[i] = (char) (chars[si]+'a');
        }

        out.println(String.valueOf(s));
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