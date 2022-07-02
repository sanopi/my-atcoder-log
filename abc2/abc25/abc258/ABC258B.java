import java.io.PrintWriter;
import java.util.Scanner;

public class ABC258B {

    private static final int[] X = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] Y = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) {
        int n = nextInt();
        char[][] a = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = next();
            a[i] = s.toCharArray();
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    StringBuilder sb = new StringBuilder();
                    int x = X[k];
                    int y = Y[k];
                    for (int l = 0; l < n; l++) {
                        int ii = ((i + l * x) + n) % n;
                        int jj = ((j + l * y) + n) % n;
                        sb.append(a[ii][jj]);
                    }
                    long candidate = Long.parseLong(sb.toString());
                    ans = Math.max(ans, candidate);
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