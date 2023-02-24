import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC151A {

    public static void main(String[] args) {
        int n = nextInt();
        char[] s = next().toCharArray();
        char[] t = next().toCharArray();
        int s1count = 0;
        int t1count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') s1count++;
            if (t[i] == '1') t1count++;
        }

        int diff = Math.abs(s1count - t1count);
        if (diff%2 != 0) {
            System.out.println(-1);
            return;
        }
        diff /= 2;

        char[] ans = new char[n];
        Arrays.fill(ans, '0');

        for (int i = n - 1; i >= 0 && diff > 0; i--) {
            if (s[i] == t[i]) continue;
            if (s1count > t1count && t[i] == '1') continue;
            if (s1count < t1count && s[i] == '1') continue;
            ans[i] = '1';
            diff--;
        }

        out.println(String.valueOf(ans));
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