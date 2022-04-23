import java.io.PrintWriter;
import java.util.Scanner;

public class ABC249C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }

        int ans = 0;
        for (int i = 1; i < 1 << n; i++) {
            int[] count = new int[26];
            int tmpAns = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1<<j) != 0) {
                    String s = ss[j];
                    for (char c : s.toCharArray()) {
                        count[c-'a']++;
                    }
                }
            }
            for (int j = 0; j < 26; j++) {
                if (count[j]==k) {
                    tmpAns++;
                }
            }
            ans = Math.max(ans, tmpAns);
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