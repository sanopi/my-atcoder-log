import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC289D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int m = nextInt();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < m; i++) {
            b.add(nextInt());
        }
        int x = nextInt();
        boolean[] dp = new boolean[x+1];
        dp[0] = true;
        for (int i = 0; i < x; i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < n; j++) {
                int aj = a[j];
                if (i+aj>x) continue;
                if (b.contains(i+aj)) continue;
                dp[i+aj] = true;
            }
        }
        out.println(dp[x]?"Yes":"No");
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