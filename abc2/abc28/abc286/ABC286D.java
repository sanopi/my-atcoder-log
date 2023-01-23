import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC286D {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        boolean[] ok = new boolean[x+1];
        ok[0] = true;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            for (int j = 0; j < b; j++) {
                boolean[] next = Arrays.copyOf(ok, ok.length);
                for (int k = 0; k < x + 1; k++) {
                    if (!ok[k]) continue;
                    if (k+a > x) continue;
                    next[k+a] = true;
                }
                ok = next;
            }
        }
        out.println(ok[x]? "Yes" : "No");
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