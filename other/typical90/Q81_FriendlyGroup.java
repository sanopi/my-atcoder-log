import java.io.PrintWriter;
import java.util.Scanner;

public class Q81_FriendlyGroup {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();

        // どの値に何人いるかプロットして、 +k した範囲内に何人いるか算出する
        int[][] counts = new int[5001][5001];
        for (int i = 0; i < n; i++) {
            counts[nextInt()][nextInt()]++;
        }

        // 人数を数える手間を省くために累積和を用いる
        for (int i = 0; i < 5001; i++) {
            for (int j = 0; j < 5000; j++) {
                counts[i][j+1] += counts[i][j];
            }
        }
        for (int i = 0; i < 5001; i++) {
            for (int j = 0; j < 5000; j++) {
                counts[j+1][i] += counts[j][i];
            }
        }

        int ans = 0;
        for (int i = 1; i < 5001-k; i++) {
            for (int j = 1; j < 5001-k; j++) {
                ans = Math.max(ans, counts[i+k][j+k]-counts[i+k][j-1]-counts[i-1][j+k]+counts[i-1][j-1]);
            }
        }
        out.println(ans);
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