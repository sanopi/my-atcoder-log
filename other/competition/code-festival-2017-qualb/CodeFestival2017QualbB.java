import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeFestival2017QualbB {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, Integer> diffCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int d = nextInt();
            diffCount.put(d, diffCount.getOrDefault(d, 0)+1);
        }

        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            Integer count = diffCount.get(t);
            if (count == null || count.equals(0)) {
                System.out.println("NO");
                return;
            }
            diffCount.put(t, count-1);
        }
        System.out.println("YES");
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