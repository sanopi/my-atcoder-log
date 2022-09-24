import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC175D {

    public static void main(String[] args) {
        final int n = nextInt();
        final int k = nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = nextInt()-1;
        }
        int[] c = nextIntArray(n);
        long ans = Long.MIN_VALUE;
        boolean[] done = new boolean[n];
        for (int initial = 0; initial < n; initial++) {
            int current = initial;
            int restCount = k;
            long score = 0;
            long maxScore = Long.MIN_VALUE;
            Arrays.fill(done, false);
            while (!done[current] && restCount > 0) {
                done[current] = true;
                current = p[current];
                restCount--;
                score += c[current];
                maxScore = Math.max(maxScore, score);
            }
            if (score > 0 && restCount > 0) {
                int count = k-restCount;
                score = score * (k/count - 1);
                maxScore = Math.max(maxScore, score);
                int finalCount = k % count + count;
                for (int i = 0; i < finalCount; i++) {
                    current = p[current];
                    score += c[current];
                    maxScore = Math.max(maxScore, score);
                }
            }
            ans = Math.max(ans, maxScore);
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