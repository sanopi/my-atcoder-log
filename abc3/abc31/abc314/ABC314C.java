import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC314C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        String s = next();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = nextInt()-1;
        }
        char[] ans = new char[n];
        Arrays.fill(ans, ' ');
        int[] memo = new int[m];
        Arrays.fill(memo, -1);
        for (int i = 0; i < n; i++) {
            int ci = colors[i];
            if (memo[ci] != -1) {
                ans[i] = s.charAt(memo[ci]);
            }
            memo[ci] = i;
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == ' ') {
                ans[i] = s.charAt(memo[colors[i]]);
            }
        }

        out.println(new String(ans));
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