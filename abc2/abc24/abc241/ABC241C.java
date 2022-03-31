import java.io.PrintWriter;
import java.util.Scanner;

public class ABC241C {

    private static int[] down = {0, 1, 1, 1};
    private static int[] right = {1, 0, 1, -1};

    public static void main(String[] args) {
        int n = nextInt();
        char[][] g = new char[n][n];
        for (int i = 0; i < n; i++) {
            g[i] = next().toCharArray();
        }

        boolean ok = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int count = 0;
                    for (int l = 0; l < 6; l++) {
                        int ni = i + down[k]*l;
                        int nj = j + right[k]*l;
                        if (!(ni>=0&&ni<n && nj>=0&&nj<n)) {
                            count = -1000;
                            break;
                        }
                        if (g[ni][nj] == '#') count++;
                    }
                    if (count >= 4) ok = true;
                }
            }
        }
        out.println(ok ? "Yes" : "No");
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