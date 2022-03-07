import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Nikkei2019QualC {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] input = new Pair[n];
        for (int i = 0; i < n; i++) {
            input[i] = new Pair(nextInt(), nextInt(), i);
        }
        Arrays.sort(input, Comparator.comparing(pair -> -(pair.a+pair.b)));
        long ta = 0;
        long ao = 0;
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                ta += input[i].a;
            } else {
                ao += input[i].b;
            }
        }
        out.println(ta-ao);
        out.flush();
    }

    private static class Pair {
        int a;
        int b;
        int i;
        public Pair(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i = i;
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