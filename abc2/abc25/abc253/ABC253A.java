import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC253A {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        if (List.of(a, b, c).stream().sorted().collect(Collectors.toList()).get(1) == b) {
            out.println("Yes");
        } else {
            out.println("No");
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