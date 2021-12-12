import java.io.PrintWriter;
import java.util.Scanner;

public class ABC231E {

    private static long[] a;
    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        long x = nextLong();
        a = nextLongArray(n);

        out.println(dfs(x, 0));
        out.flush();
    }

    private static long dfs(long x, int i) {
        if (i==n-1) {
            return x/a[i];
        }
        if (x == 0) {
            return 0L;
        }

        long current = a[i];
        long next = a[i+1];

        // ぴったり払う
        long l = dfs(x-x%next, i+1) + (x%next/current);
        // xもnextもcurrentの倍数なので、 x%next/current は割り切れる。

        // お釣りを貰う
        long ll = dfs(x-x%next+next, i+1) + ((-x%next+next)/current);
        return Math.min(l, ll);
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