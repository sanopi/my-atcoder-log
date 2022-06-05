import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC210E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int c = nextInt();
            pairs[i] = new Pair(a, c);
        }

        Arrays.sort(pairs, Comparator.comparing(p -> p.c));
        long gcd = n;
        long ans = 0;
        for (Pair pair : pairs) {
            long newGcd = gcd(gcd, pair.a);
            if (newGcd == gcd) continue;
            ans += (gcd-newGcd) * pair.c;
            gcd = newGcd;
        }
        out.println(gcd != 1 ? -1 : ans);
        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }

    private static class Pair {
        int a;
        int c;
        public Pair(int a, int c) {
            this.a = a;
            this.c = c;
        }
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