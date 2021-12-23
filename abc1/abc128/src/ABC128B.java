import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC128B {

    public static void main(String[] args) {
        int n = nextInt();
        List<Fixture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = next();
            int p = nextInt();
            list.add(new Fixture(i+1, s, p));
        }
        list.sort(Comparator.comparing((Fixture f) -> f.s).thenComparing(f -> -f.p));
        for (final Fixture fixture : list) {
            out.println(fixture.num);
        }
        out.flush();
    }

    private static class Fixture {
        int num;
        String s;
        int p;
        public Fixture(final int num, final String s, final int p) {
            this.num = num;
            this.s = s;
            this.p = p;
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