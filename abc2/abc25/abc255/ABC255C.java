import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ABC255C {

    public static void main(String[] args) {
        long x = nextLong();
        long a = nextLong();
        long d = nextLong();
        long n = nextLong();
        if (d == 0) {
            System.out.println(Math.abs(x-a));
            return;
        }
        if (x==a) {
            System.out.println(0);
            return;
        }

        if (x>a) {
            if (d<0) {
                System.out.println(x-a);
                return;
            }
            long maxN = a + d * (n-1);
            long p = a + d * ((x-a)/d);
            long ans = List.of(p - d, p, p + d)
                .stream()
                .mapToLong(l -> Math.min(l, maxN))
                .map(l -> Math.abs(x - l))
                .min()
                .getAsLong();
            System.out.println(ans);
            return;
        }

        if (x<a) {
            if (d>0) {
                System.out.println(Math.abs(a-x));
                return;
            }
            long minN = a + d * (n-1);
            long p = a + d * ((a-x)/-d);
            long ans = List.of(p - d, p, p + d)
                .stream()
                .mapToLong(l -> Math.max(l, minN))
                .map(l -> Math.abs(x - l))
                .min()
                .getAsLong();
            System.out.println(ans);
            return;
        }

        out.flush();
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