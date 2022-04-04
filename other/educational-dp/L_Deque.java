import java.io.PrintWriter;
import java.util.Scanner;

public class L_Deque {

    private static long[][] memo;
    private static int[] a;

    public static void main(String[] args) {
        int n = nextInt();
        memo = new long[n][n];
        a = nextIntArray(n);
        out.println(solve(0, n-1));

        out.flush();
    }

    private static long solve(int l, int r) {
        if (l>r) return 0;
        if (memo[l][r]>0) return memo[l][r];

        long ans;
        ans = Math.max(a[l]-solve(l+1, r), a[r]-solve(l, r-1));
        return memo[l][r] = ans;
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