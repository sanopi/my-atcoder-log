import java.io.PrintWriter;
import java.util.Scanner;

public class ABC252C {

    public static void main(String[] args) {
        int n = nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) { // 0-9まで
            int t = 0;
            int count = 0;
            boolean[] done = new boolean[n];
            while (count < n) {
                for (int j = 0; j < n; j++) {
                    if (done[j]) {
                        continue;
                    }
                    String s = ss[j];
                    if (s.charAt(t%10)-'0' == i) {
                        count++;
                        done[j] = true;
                        break;
                    }
                }
                t++;
            }
            ans = Math.min(ans, t-1);
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