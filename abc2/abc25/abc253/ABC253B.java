import java.io.PrintWriter;
import java.util.Scanner;

public class ABC253B {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int fx = -1;
        int fy = -1;
        int ans = -1;
        for (int i = 0; i < h; i++) {
            String s = next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < w; j++) {
                if (chars[j] == 'o') {
                    if (fx<0) {
                        fx = i;
                        fy = j;
                    } else {
                        ans = Math.abs(fx-i)+Math.abs(fy-j);
                    }
                }
            }
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