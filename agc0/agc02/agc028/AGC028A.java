import java.io.PrintWriter;
import java.util.Scanner;

public class AGC028A {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        String s = next();
        String t = next();
        long gcd = gcd(n, m);
        int sStep = (int) (n /gcd);
        int tStep = (int) (m /gcd);
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int si = 0;
        int ti = 0;
        while (si<n && ti<m) {
            if (sChar[si] != tChar[ti]) {
                System.out.println(-1);
                return;
            }
            si+=sStep;
            ti+=tStep;
        }

        out.println(n/gcd*m);

        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
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