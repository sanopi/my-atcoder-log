import java.io.PrintWriter;
import java.util.Scanner;

public class Q38_LargeLCM_3 {

    public static void main(String[] args) {
        long pow18 = 1_000_000_000_000_000_000L;

        long a = nextLong();
        long b = nextLong();
        long gcd = gcd(a, b);


        if (pow18 / a < (b / gcd)) {
            out.println("Large");
        } else {
            out.println(a * (b / gcd));
        }

        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
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