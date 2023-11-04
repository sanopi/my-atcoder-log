import java.io.PrintWriter;
import java.util.Scanner;

public class ABC324E {

    private static void solve() {
        int n = nextInt();
        String t = next();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }
        int len = t.length();
        int[] counts = new int[len+1];
        String revT = new StringBuilder().append(t).reverse().toString();
        for (String s : ss) {
            String revS = new StringBuilder().append(s).reverse().toString();
            counts[count(revT, revS)]++;
        }
        for (int i = len - 1; i >= 0; i--) {
            counts[i] += counts[i+1];
        }
        long ans = 0;
        for (String s : ss) {
            int count = count(t, s);
            ans += counts[len-count];
        }
        out.println(ans);
        out.flush();
    }

    private static int count(String target, String base) {
        int index = 0;
        for (char c : base.toCharArray()) {
            if (index < target.length() && target.charAt(index) == c) {
                index++;
            }
        }
        return index;
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