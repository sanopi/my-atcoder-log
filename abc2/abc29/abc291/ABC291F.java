import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class ABC291F {

    private static final int INF = Integer.MAX_VALUE/3;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        char[][] s = new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i] = next().toCharArray();
        }

        int[] dp_f = new int[n];
        Arrays.fill(dp_f, INF);
        dp_f[0]=0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m && i+j+1<n; j++) {
                if (s[i][j] == '1') {
                    dp_f[i+j+1] = Math.min(dp_f[i+j+1], dp_f[i] +1);
                }
            }
        }

        int[] dp_b = new int[n];
        Arrays.fill(dp_b, INF);
        dp_b[n-1]=0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m && i+j+1<n; j++) {
                if (s[i][j] == '1') {
                    dp_b[i] = Math.min(dp_b[i], dp_b[i+j+1] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(dp_f));
//        System.out.println(Arrays.toString(dp_b));

        for (int i = 1; i <= n-2; i++) {
            int ans = INF;
            // 左側
            for (int j = Math.max(0, i-m+1); j < i; j++) {
                // 右側
                for (int k = i+1; k <= i+m-1 && k < n; k++) {
//                    System.out.println(i + " " + j + " " + k);
                    if (k-j > m) break;
                    if (s[j][k-j-1] == '0') continue;
                    ans = Math.min(ans, dp_f[j] + dp_b[k] + 1);
                }
            }
            out.print((ans == INF ? -1 : ans) +" ");
        }
        out.flush();
    }

    private static class Point {
        int i;
        Set<Integer> set;
        public Point(int i, Set<Integer> set) {
            this.i = i;
            this.set = set;
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