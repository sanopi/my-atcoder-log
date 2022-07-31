import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC195E {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        String x = next();
        int[] rest = new int[n];
        rest[0] = 1;
        for (int i = 1; i < n; i++) {
            rest[i] = (10*rest[i-1] % 7);
        }

        boolean[][] ans = new boolean[n+1][7];
        ans[0][0] = true;
        for (int i = 0; i < n; i++) {
            int si = s.charAt(n -1 - i)-'0';
            char xi = x.charAt(n-1 - i);
            if (xi == 'T') {
                for (int j = 0; j < 7; j++) {
                    if (ans[i][j]) {
                        ans[i+1][j] = true;
                        ans[i+1][(j+rest[i]*si)%7] = true;
                    }
                }
            } else {
                for (int j = 0; j < 7; j++) {
                    if (ans[i][j] && ans[i][(j+rest[i]*si)%7]) {
                        ans[i+1][(j+rest[i]*si)%7] = true;
                    }
                }
            }
        }
        out.println(ans[n][0] ? "Takahashi" : "Aoki");
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