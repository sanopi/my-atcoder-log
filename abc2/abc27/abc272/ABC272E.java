import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC272E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);

        // i 回目の操作の後にとりうる値（0<= j <= n）
        Set<Integer>[] memo = new Set[m+1];
        for (int i = 0; i < m+1; i++) {
            memo[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            int ai = a[i];
            // 何回目で非負になるか
            int add = i + 1;
            int mi;
            if (ai < 0) {
                mi = (-ai + (add-1))/ (add);
            } else {
                mi = 0;
            }

            for (int j = mi; j <= m && ai + add*j <= n; j++) {
                memo[j].add(ai + add*j);
            }
        }

        for (int i = 1; i <= m; i++) {
            Set<Integer> s = memo[i];
            for (int j = 0; j <= n; j++) {
                if (s.contains(j)) continue;
                out.println(j);
                break;
            }
        }
        out.flush();
    }

    private static class Some {
        int mi;
        int diff;
        public Some(int mi, int diff) {
            this.mi = mi;
            this.diff = diff;
        }
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