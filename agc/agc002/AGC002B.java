import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC002B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] c = new int[n];
        boolean[] p = new boolean[n];
        p[0] = true;
        Arrays.fill(c, 1);
        for (int i = 0; i < m; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            c[x]--;
            c[y]++;
            p[y] = p[y] || p[x];
            if (c[x] == 0) p[x] = false;
        }
        int ans = 0;
        for (boolean b : p) {
            if (b) ans++;
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