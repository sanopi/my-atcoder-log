import java.io.PrintWriter;
import java.util.Scanner;

public class Q33_NotTooBright_2 {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        if (h == 1 || w == 1) {
            out.println(h*w);
        } else {
            out.println((h/2 + h%2) * (w/2 + w%2));
        }
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