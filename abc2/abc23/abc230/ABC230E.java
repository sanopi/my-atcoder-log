import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC230E {

    public static void main(String[] args) {
//        for (int i = 1; i <= 100; i++) {
//            System.out.print(100/i + " ");
//        }
        long n = nextLong();

        long sum = 0;
        int i = 2;
        List<Long> counts = new ArrayList<>();
        while (sum != n) {
            long s = n/i;
            long t = n/(i-1);
            long add = Math.max(1, t - s);
            counts.add(add);
            sum+= add;
            i++;
        }

        long k = 1;
        long ans = 0;
        for (int j = 0; j < counts.size(); j++) {
            Long count = counts.get(counts.size() - 1 - j);
//            System.out.println("count " + count + " n/k " + (n/k));
            ans += count * (n/k);
            k += count;
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