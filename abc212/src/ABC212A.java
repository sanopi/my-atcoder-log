import java.io.PrintWriter;
import java.util.Scanner;

public class ABC212A {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();

        String ans;
        if (0 < a && b == 0) {
            ans = "Gold";
        } else if (a == 0 && 0 < b) {
            ans = "Silver";
        } else {
            ans = "Alloy";
        }
        out.println(ans);
        out.flush();
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