import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC181E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] h = nextIntArray(n);
        int[] w = nextIntArray(m);

        Arrays.sort(h);

        long tmp = 0;
        for (int i = 1; i < n-1; i+=2) {
            tmp += h[i+1] - h[i];
        }
        Arrays.sort(w);
        long ans = Long.MAX_VALUE;
        int hi = 0;
        for (int wi = 0; wi < m; wi++) {
            while (hi < n-2 && h[hi+1] < w[wi]) {
                tmp -= h[hi+2]-h[hi+1];
                tmp += h[hi+1]-h[hi];
                hi+=2;
            }
            ans = Math.min(ans, tmp + Math.abs(w[wi]-h[hi]));
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