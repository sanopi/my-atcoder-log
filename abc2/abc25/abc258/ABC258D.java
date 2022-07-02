import java.io.PrintWriter;
import java.util.Scanner;

public class ABC258D {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            pairs[i] = new Pair(a, b);
        }

        long abSum = 0;
        long bMin = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long a = pairs[i].a;
            long b = pairs[i].b;
            abSum += (a+b);
            bMin = Math.min(bMin, b);

            if (x <= i+1) {
                ans = Math.min(ans, abSum);
                break;
            }
            int rest = x - (i + 1);
            ans = Math.min(ans, abSum + rest*bMin);
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        long a;
        long b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
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