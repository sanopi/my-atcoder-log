import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC089C {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Character, Integer> initialCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = next();
            initialCount.put(s.charAt(0), initialCount.getOrDefault(s.charAt(0), 0)+1);
        }
        long m = initialCount.getOrDefault('M', 0);
        long a = initialCount.getOrDefault('A', 0);
        long r = initialCount.getOrDefault('R', 0);
        long c = initialCount.getOrDefault('C', 0);
        long h = initialCount.getOrDefault('H', 0);
        long ans = m * (a*(r+c+h) + r*(c+h) + c*h) + a * (r*(c+h) + c*h) + r*c*h;
        System.out.println(ans);
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