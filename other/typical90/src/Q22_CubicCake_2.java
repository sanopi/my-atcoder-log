import java.io.PrintWriter;
import java.util.Scanner;

public class Q22_CubicCake_2 {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long gcd = gcd(a, gcd(b, c));
        out.println((a/gcd) - 1 + (b/gcd) - 1 + (c/gcd) - 1);
        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}