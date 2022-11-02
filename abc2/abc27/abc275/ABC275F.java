import java.io.PrintWriter;
import java.util.Scanner;

public class ABC275F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        Pair[][] dp = new Pair[n+1][m+1];
        dp[0][0] = new Pair(0, -1);
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            // aiを選ばない
            for (int j = 0; j <= m; j++) {
                dp[i+1][j] = dp[i][j];
            }
            // aiを選ぶ
            for (int j = 0; j <= m; j++) {
                if (j+ai > m) continue;
                Pair pij = dp[i][j];
                if (pij == null) continue;
                int nc = pij.deleteCount + (pij.lastIndex+1 == i ? 0 : 1);
                Pair np = Pair.min(dp[i+1][j+ai], new Pair(nc, i));
                dp[i+1][j+ai] = np;
            }
        }

        for (int i = 1; i <= m; i++) {
            Pair ans = dp[n][i];
            if (ans == null) {
                out.println(-1);
            } else {
                out.println(ans.getResult(n));
            }
        }
        out.flush();
    }

    private static class Pair {
        int deleteCount;
        int lastIndex;
        public Pair(int deleteCount, int lastIndex) {
            this.deleteCount = deleteCount;
            this.lastIndex = lastIndex;
        }
        private static Pair min(Pair a, Pair b) {
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            if (a.deleteCount < b.deleteCount) {
                return a;
            }
            if (b.deleteCount < a.deleteCount) {
                return b;
            }
            if (a.lastIndex < b.lastIndex) {
                return b;
            }
            return a;
        }
        private int getResult(int n) {
            if (lastIndex == n-1) {
                return deleteCount;
            } else {
                return deleteCount+1;
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                "deleteCount=" + deleteCount +
                ", lastIndex=" + lastIndex +
                '}';
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