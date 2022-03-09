import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC071D {

    private static final int MOD = 1000000007;
    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        char[][] s = new char[2][n];
        s[0] = next().toCharArray();
        s[1] = next().toCharArray();

        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[0][i] == s[1][i]) {
                patterns.add("|");
            } else {
                patterns.add("-");
                i++;
            }
        }
        int size = patterns.size();
        long ans = patterns.get(0).equals("|") ? 3 : 6;
        for (int i = 1; i < size; i++) {
            String prev = patterns.get(i - 1);
            String current = patterns.get(i);
            if (prev.equals("|")) {
                if (current.equals("|")) ans *= 2;
                else ans *= 2;
            } else {
                if (current.equals("|")) ans *= 1;
                else ans *= 3;
            }
            ans %= MOD;
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