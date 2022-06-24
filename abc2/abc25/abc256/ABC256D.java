import java.io.PrintWriter;
import java.util.Scanner;

public class ABC256D {

    public static void main(String[] args) {
        int n = nextInt();
        int max = 200000;
        int[] ll = new int[max+1];
        int[] rr = new int[max+1];
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            ll[l]++;
            rr[r]++;
        }
        int count = 0;
        int l = 0;
        for (int i = 1; i < max + 1; i++) {
            if (ll[i] != 0) {
                count+=ll[i];
                if (l == 0) l = i;
            }
            if (rr[i] != 0) {
                count-=rr[i];
                if (count == 0) {
                    out.println(l + " " + i);
                    l = 0;
                }
            }
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