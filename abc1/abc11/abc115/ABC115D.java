import java.io.PrintWriter;
import java.util.Scanner;

public class ABC115D {

    private static long[] sizes;
    private static long[] fullPaty;
    public static void main(String[] args) {
        int n = nextInt();
        sizes = new long[n+1];
        fullPaty = new long[n+1];
        sizes[0] = 1;
        fullPaty[0] = 1;
        for (int i = 1; i <= n; i++) {
            sizes[i] = sizes[i-1]*2+3;
            fullPaty[i] = fullPaty[i-1]*2+1;
        }
        long x = nextLong();

        out.println(solve(n, x));
        out.flush();
    }

    private static long solve(int n, long x) {
        if (x==0) return 0;
        if (n==0) return 1;
        long res = 0;
        long half = (sizes[n] - 1) / 2;
        if  (x >= half) {
            res += fullPaty[n-1];
            x-=half;
            if (x>=1) {
                res+=1;
                x-=1;
            }
        } else {
            x-=1;
        }
        res += solve(n-1, x);
        return res;
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