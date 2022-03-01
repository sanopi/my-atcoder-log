import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Panasonic2020D {

    public static void main(String[] args) {
        int n = nextInt();
        solve("a", 0, n).forEach(out::println);
        out.flush();
    }

    private static List<String> solve(String s, int max, int n) {
        if (n==1) {
            return List.of(s);
        }
        return IntStream.range(0, max+2)
            .mapToObj(i -> solve(s + Character.toString((char) i + 'a'), Math.max(max, i),n - 1))
            .flatMap(List::stream)
            .collect(Collectors.toList());
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