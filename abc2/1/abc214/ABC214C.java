import java.io.PrintWriter;
import java.util.Scanner;

public class ABC214C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] s = nextIntArray(n);
        int[] t = nextIntArray(n);

        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] < t[minIndex]) {
                minIndex = i;
            }
        }


        for (int i = minIndex+1; i < n; i++) {
            int pre = i == 0 ? n-1 : i-1;
            if (t[pre] + s[pre] < t[i]) {
                t[i] = t[pre] + s[pre];
            }
        }
        for (int i = 0; i < minIndex; i++) {
            int pre = i == 0 ? n-1 : i-1;
            if (t[pre] + s[pre] < t[i]) {
                t[i] = t[pre] + s[pre];
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(t[i]);
        }


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