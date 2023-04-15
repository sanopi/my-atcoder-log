import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ABC298D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int q = nextInt();
        long[][] diffs = new long[10][q+1];
        for (int i = 1; i < 10; i++) {
            diffs[i][1] = i;
            for (int j = 2; j < q + 1; j++) {
                diffs[i][j] = diffs[i][j-1]*10 % MOD;
            }
        }

        Queue<Integer> s = new ArrayDeque<>();
        s.add(1);
        long sMod = 1;
        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                int x = nextInt();
                s.add(x);
                sMod = ((sMod*10)+x)%MOD;
            } else if (t == 2) {
                int sLen = s.size();
                Integer first = s.poll();
                sMod -= diffs[first][sLen];
                sMod = (sMod%MOD+MOD)%MOD;
            } else {
                out.println(sMod);
            }
        }
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