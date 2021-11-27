import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC229C {

    public static void main(String[] args) {
        int n = nextInt();
        int w = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        Comparator<Pair> comparing = Comparator.comparing(p -> p.a);
        Arrays.sort(pairs, comparing.reversed());
        int i = 0;
        long ans = 0;
        while (i < n && w > 0) {
            Pair pair = pairs[i];
            int amount = Math.min(pair.b, w);
            ans += ((long) pair.a * amount);
            w-=amount;
            i++;
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int a;
        int b;
        public Pair(final int a, final int b) {
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