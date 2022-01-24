import java.io.PrintWriter;
import java.util.Scanner;

public class ABC122C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        String s = next();
        int[] acCounts = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.substring(i - 1, i + 1).equals("AC")) {
                acCounts[i]++;
            }
            acCounts[i]+=acCounts[i-1];
        }
        for (int i = 0; i < q; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            out.println(acCounts[r]-acCounts[l]);
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