import java.io.PrintWriter;
import java.util.Scanner;

public class ABC345C {

    private static void solve() {
        String s = next();
        int n = s.length();
        int[] charCount = new int[26];
        for (int i = 0; i < n; i++) {
            charCount[s.charAt(i)-'a']++;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] >= 2) {
                ans++;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            int si = s.charAt(i) - 'a';
            charCount[si]--;
            for (int j = 0; j < 26; j++) {
                if (si == j) continue;
                ans += charCount[j];
            }
        }
        out.println(ans);
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