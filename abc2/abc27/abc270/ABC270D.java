import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC270D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(k);

        // 0 == t, 1 == a;
        Pair[][] dp = new Pair[n+1][2];
        for (Pair[] pairs : dp) {
            Arrays.fill(pairs, new Pair(0, 0));
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k; j++) {
                int aj = a[j];
                if (i + aj > n) continue;
                {
                    // 青木が i+aj個 -> 高橋がi個
                    Pair to = dp[i][0];
                    Pair from = dp[i + aj][1];
                    Pair newPair;
                    if (from.a < to.a + aj) {
                        newPair = new Pair(to.t, to.a + aj);
                    } else {
                        newPair = from;
                    }
                    dp[i + aj][1] = newPair;
                }

                {
                    // 高橋が i+aj個 -> 青木がi個
                    Pair to = dp[i][1];
                    Pair from = dp[i + aj][0];
                    Pair newAPair;
                    if (from.t < to.t + aj) {
                        newAPair = new Pair(to.t + aj, to.a);
                    } else {
                        newAPair = from;
                    }
                    dp[i + aj][0] = newAPair;
                }
            }
        }


        out.println(dp[n][0].t);
        out.flush();
    }

    private static class Pair {
        long t;
        long a;
        public Pair(long t, long a) {
            this.t = t;
            this.a = a;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "t=" + t +
                ", a=" + a +
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