import java.io.PrintWriter;
import java.util.Scanner;

public class Q20_LogInequality_3 {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long factorial = factorial(c, b);
        String ans = (factorial < 0) || (a < factorial) ? "Yes" : "No";
        out.println(ans);
        out.flush();
    }

    static long factorial(long a, long n) {
        if (n == 1) {
            return a;
        }
        return a * factorial(a, n-1);
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