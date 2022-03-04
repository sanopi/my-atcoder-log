import java.io.PrintWriter;
import java.util.Scanner;

public class ABC090D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        long ans = 0;
        for (int b = k+1; b <= n; b++) {
            // k ~ b-1 が n/b 回
            ans += (long) n/b * (b-k);
            // k ~ n%b が 1 回
            ans += Math.max(0, n%b-k+1);
            // k==0の時、上記のコードでa==0が一回カウントされる。
            ans -= k==0?1:0;
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