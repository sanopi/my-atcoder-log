import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC218C {

    public static void main(String[] args) {
        int n = nextInt();
        char[][] s = new char[n][n];
        char[][] t = new char[n][n];

        for (int i = 0; i < n; i++) {
            s[i] = next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            t[i] = next().toCharArray();
        }
        List<Integer> linearT = new ArrayList<>();
        linear(n, t, linearT);

        char[][] s1 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s1[i][j] = s[n-j-1][i];
            }
        }

        char[][] s2 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s2[i][j] = s1[n-j-1][i];
            }
        }

        char[][] s3 = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s3[i][j] = s2[n-j-1][i];
            }
        }
        List<Integer> linearS = new ArrayList<>();
        linear(n, s, linearS);
        List<Integer> linearS1 = new ArrayList<>();
        linear(n, s1, linearS1);
        List<Integer> linearS2 = new ArrayList<>();
        linear(n, s2, linearS2);
        List<Integer> linearS3 = new ArrayList<>();
        linear(n, s3, linearS3);

        if (
            linearT.equals(linearS) ||
            linearT.equals(linearS1) ||
            linearT.equals(linearS2) ||
            linearT.equals(linearS3)
        ) {
            out.println("Yes");
        } else {
            out.println("No");
        }

        out.flush();
    }

    private static void linear(final int n, final char[][] t, final List<Integer> linearT) {
        int first = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == '#') {
                    int sel = i * 2 * n  + j;
                    if (first == -1) {
                        first = sel;
                    }
                    linearT.add(sel - first);
                }
            }
        }
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