import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ARC143A {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        List<Long> collect = Stream.of(a, b, c).sorted().collect(Collectors.toList());
        Long min = collect.get(0);
        Long mid = collect.get(1);
        Long max = collect.get(2);
        if (min+mid < max) {
            System.out.println(-1);
            return;
        }
        System.out.println(max);
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