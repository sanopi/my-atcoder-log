import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC153E {

    public static void main(String[] args) {
        int h = nextInt();
        int n = nextInt();
        Magic[] magics = new Magic[n];
        for (int i = 0; i < n; i++) {
            magics[i] = new Magic(nextInt(), nextInt());
        }

        int[] dp = new int[h+1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        for (int i = 0; i < n; i++) {
            Magic magic = magics[i];
            for (int j = 0; j <= h; j++) {
                int point = Math.min(h, j + magic.damage);
                dp[point] = Math.min(dp[point], (point+magic.damage-1)/magic.damage*magic.mp);
                dp[point] = Math.min(dp[point], dp[j] + magic.mp);
            }
        }
        out.println(dp[h]);
        out.flush();
    }

    private static class Magic {
        int damage;
        int mp;
        public Magic(int damage, int mp) {
            this.damage = damage;
            this.mp = mp;
        }
        @Override
        public String toString() {
            return "Magic{" +
                "damage=" + damage +
                ", mp=" + mp +
                '}';
        }
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