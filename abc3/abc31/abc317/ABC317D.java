import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC317D {

    private static void solve() {
        int n = nextInt();
        int zSum = 0;
        int currentSum = 0;
        List<Ku> kus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            int z = nextInt();
            if (x>y) {
                currentSum+=z;
            } else {
                kus.add(new Ku((x+y+1)/2-x, z));
            }
            zSum+=z;
        }
        int rest = (zSum+1)/2 - currentSum;
        if (rest<=0) {
            System.out.println(0);
            return;
        }
        int m = kus.size();
        long[][] dp = new long[m][rest+1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        dp[0][Math.min(rest, kus.get(0).z)] = kus.get(0).rest;
        for (int i = 1; i < m; i++) {
            Ku ku = kus.get(i);
            int z = ku.z;
            int r = ku.rest;
            for (int j = 0; j < rest + 1; j++) {
                dp[i][j] = dp[i-1][j];
            }
            for (int j = 0; j < rest; j++) {
                int to = Math.min(rest, j + z);
                dp[i][to] = Math.min(dp[i][to], dp[i-1][j]+r);
            }
        }
        out.println(dp[m-1][rest]);
        out.flush();
    }

    private static class Ku {
        int rest;
        int z;
        public Ku(int rest, int z) {
            this.rest = rest;
            this.z = z;
        }
        @Override
        public String toString() {
            return "Ku{" +
                "rest=" + rest +
                ", z=" + z +
                '}';
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> System.exit(1));
        thread.start();
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