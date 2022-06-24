import java.io.PrintWriter;
import java.util.Scanner;

public class ABC256C {

    public static void main(String[] args) {
        int h1 = nextInt();
        int h2 = nextInt();
        int h3 = nextInt();
        int w1 = nextInt();
        int w2 = nextInt();
        int w3 = nextInt();

        int count = 0;
        for (int i11 = 1; i11 < 30; i11++) {
            for (int i12 = 1; i12 < 30; i12++) {
                for (int i21 = 1; i21 < 30; i21++) {
                    for (int i22 = 1; i22 < 30; i22++) {
                        int i13 = h1-i11-i12;
                        int i23 = h2-i21-i22;
                        int i31 = w1-i11-i21;
                        int i32 = w2-i12-i22;
                        int i33a = h3-i31-i32;
                        int i33b = w3-i13-i23;
                        if (i13>0 && i23>0 && i31>0 && i32>0 && i33a==i33b && i33a>0) {
                            count++;
                        }
                    }
                }
            }
        }
        out.println(count);
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