import java.io.PrintWriter;
import java.util.Scanner;

public class Q24_SelectOne_2 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = nextInt();
        }

        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += Math.abs(a[i] - b[i]);
        }
        int tmp = k - diff;
        String ans = (tmp >= 0) && (tmp % 2 == 0) ? "Yes" : "No";
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