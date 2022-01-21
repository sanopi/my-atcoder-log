import java.io.PrintWriter;
import java.util.Scanner;

public class AGC031A {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i)-'a']++;
        }
        long ans = 1;
        for (int i = 0; i < 26; i++) {
            ans *= counts[i]+1;
            ans %= MOD;
        }
        out.println(ans-1);
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