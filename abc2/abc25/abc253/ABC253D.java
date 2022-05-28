import java.io.PrintWriter;
import java.util.Scanner;

public class ABC253D {

    public static void main(String[] args) {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        long ans = (long)n*(n+1)/2;
        long aCount = n / a;
        ans -= a*(aCount*(aCount+1)/2);

        long bCount = n / b;
        ans -= b*(bCount*(bCount+1)/2);

        long ab = lcm(a, b);
        long abCount = n / ab;
        ans += ab*(abCount*(abCount+1)/2);

        out.println(ans);
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