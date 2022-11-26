import java.io.PrintWriter;
import java.util.Scanner;

public class ABC278F {

    private static Boolean[][] memo;
    private static String[] s;
    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }
        memo = new Boolean[1<< n][n];
        boolean first = false;
        for (int i = 0; i < n; i++) {
            // 後手に負けが一つでもあれば先手の勝ち
            first |= !dfs(1<<i, i);
        }
        out.println(first?"First":"Second");
        out.flush();
    }

    // i, j の時に勝つか
    private static boolean dfs(int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res = false;
        for (int k = 0; k < n; k++) {
            if (((1<<k) & i) != 0) continue;
            if (s[j].charAt(s[j].length()-1) == s[k].charAt(0)) {
                res |= !dfs((1<<k) | i, k);
            }
        }
        return memo[i][j] = res;
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