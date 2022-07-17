import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC260B {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        int z = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i+1, a[i], b[i]);
        }
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(pairs, Comparator.comparing((Pair p) -> -p.a).thenComparing(p -> p.i));
        for (int i = 0; i < x; i++) {
            ans.add(pairs[i].i);
        }

        pairs = Arrays.copyOfRange(pairs, x, pairs.length);
        Arrays.sort(pairs, Comparator.comparing((Pair p) -> -p.b).thenComparing(p -> p.i));
        for (int i = 0; i < y; i++) {
            ans.add(pairs[i].i);
        }
        pairs = Arrays.copyOfRange(pairs, y, pairs.length);

        Arrays.sort(pairs, Comparator.comparing((Pair p) -> -(p.b+p.a)).thenComparing(p -> p.i));
        for (int i = 0; i < z; i++) {
            ans.add(pairs[i].i);
        }

        ans.sort(Comparator.naturalOrder());
        ans.forEach(out::println);
        out.flush();
    }

    private static final class Pair {
        int i;
        int a;
        int b;
        public Pair(int i, int a, int b) {
            this.i = i;
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