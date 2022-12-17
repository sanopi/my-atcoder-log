import java.io.PrintWriter;
import java.util.Scanner;

public class ABC282B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String si = ss[i];
            for (int j = i+1; j < n; j++) {
                String sj = ss[j];
                boolean ok = true;
                for (int k = 0; k < m; k++) {
                    ok &= si.charAt(k) == 'o' || sj.charAt(k) == 'o';
                }
                if (ok) ans ++;
            }
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