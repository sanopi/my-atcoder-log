import java.io.PrintWriter;
import java.util.Scanner;

public class AGC048A {

    public static void main(String[] args) {
        int t = nextInt();
        while (t --> 0) {
            String s = next();
            int ans = s.compareTo("atcoder")>0?0:Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                char si = s.charAt(i);
                if (si == 'a') continue;
                if ('t' < si) {
                    ans = Math.min(ans, Math.max(0, i-1));
                } else {
                    ans = Math.min(ans, i);
                }
            }
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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