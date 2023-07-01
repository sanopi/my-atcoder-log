import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC308B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        String[] c = new String[n];
        for (int i = 0; i < n; i++) {
            c[i] = next();
        }
        String[] d = new String[m];
        for (int i = 0; i < m; i++) {
            d[i] = next();
        }
        int[] p = nextIntArray(m+1);
        Map<String, Integer> price = new HashMap<>();
        for (int i = 0; i < m; i++) {
            price.put(d[i], p[i+1]);
        }
        int def = p[0];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += price.getOrDefault(c[i], def);
        }
        out.println(ans);
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