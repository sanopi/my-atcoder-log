import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC228C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = nextInt() + nextInt() + nextInt();
        }
        List<Integer> ranking = Arrays.stream(p).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Integer t = ranking.get(k - 1);
        for (int i = 0; i < n; i++) {
            int point = p[i];
            if (point+300 >= t) {
                out.println("Yes");
            } else {
                out.println("No");
            }
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