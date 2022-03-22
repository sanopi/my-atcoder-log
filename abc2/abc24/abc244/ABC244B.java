import java.io.PrintWriter;
import java.util.Scanner;

public class ABC244B {

    private static final int[] X = {1, 0, -1, 0};
    private static final int[] Y = {0, -1, 0, 1};

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int dir = 0;

        int n = nextInt();
        String t = next();
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == 'R') {
                dir = (dir+1)%4;
            } else {
                x += X[dir];
                y += Y[dir];
            }
        }
        out.println(x + " " + y);
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