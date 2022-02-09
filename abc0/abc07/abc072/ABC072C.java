import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ABC072C {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            IntStream.range(-1, 2)
                .forEach(j -> count.put(a+j, count.getOrDefault(a+j, 0)+1));
        }

        System.out.println(count.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue());
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