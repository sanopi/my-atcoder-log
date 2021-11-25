import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q14_WeUsedToSingASongTogether {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) { a[i] = nextInt(); }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) { b[i] = nextInt(); }

        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(a[i]-b[i]);
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
}