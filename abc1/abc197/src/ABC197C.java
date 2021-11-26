import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC197C {
    public static void main(String[] args) {
        int n = nextInt();
        if (n == 1) {
            System.out.println(nextInt());
            return;
        }

        int[] a = nextIntArray(n);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << (n-1); i++) {
            List<Integer> ranges = new ArrayList<>();
            for (int j = 0; j < n-1; j++) {
                if ((i&(1<<j)) == 0) {
                    ranges.add(j+1);
                }
            }
            if (ranges.isEmpty()) {
                continue;
            }
            ranges.add(n);
            int tmp = 0;
            int left = 0;
            for (final Integer right : ranges) {
                int[] current = Arrays.copyOfRange(a, left, right);
                int reduce = Arrays.stream(current).reduce(0, (l, r) -> l | r);
                tmp ^= reduce;
                left = right;
            }
            ans = Math.min(ans, tmp);
        }

        out.println(ans);
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