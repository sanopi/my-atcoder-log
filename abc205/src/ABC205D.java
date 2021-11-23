import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ABC205D {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();

        long[] a = nextLongArray(n);
        Arrays.sort(a);

        long[] b = new long[n];
        b[0] = a[0] - 1;
        for (int i = 1; i < n; i++) {
            b[i] = a[i] - a[i - 1] - 1;
            b[i] += b[i - 1];
        }

        for (int i = 0; i < q; i++) {
            long k = nextLong();
            if (b[n-1] < k) {
                out.println(a[n-1] + (k - b[n-1]));
            } else if (k < b[0]) {
                out.println(k);
            } else {
                int target = binarySearch(-1, n-1, j -> b[j] >= k);
                out.println(a[target] + (k - b[target]) - 1);
            }
        }

        out.flush();
    }

    private static int binarySearch(int ng, int ok, Predicate<Integer> condition) {
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;
            if (condition.test(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return condition.test(ok) ? ok : ng;
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
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}