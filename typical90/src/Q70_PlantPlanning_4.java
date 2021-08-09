import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q70_PlantPlanning_4 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];
        for (int i = 0; i < n; i++) {
            xx[i] = nextInt();
            yy[i] = nextInt();
        }

        Arrays.sort(xx);
        Arrays.sort(yy);

        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans = ans + (xx[n-1-i]-xx[i]);
            ans = ans + (yy[n-1-i]-yy[i]);
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}