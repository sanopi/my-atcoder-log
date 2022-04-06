import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class O_Matching {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = nextIntArray(n);
        }

        int k = 1<<n;

        long[] dp = new long[k];
        dp[0]=1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (int wi = 0; wi < n; wi++) {
                int woman = 1<<wi;
                if ((current & woman) == 0) {
                    int next = current|woman;
                    int mi = Integer.bitCount(next)-1;
                    if (a[mi][wi] == 1) {
                        if (dp[next] == 0) {
                            q.add(next);
                        }
                        dp[next]+=dp[current];
                        dp[next]%=MOD;
                    }
                }
            }
        }

        out.println(dp[k-1]);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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