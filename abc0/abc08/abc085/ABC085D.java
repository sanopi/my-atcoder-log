import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC085D {

    public static void main(String[] args) {
        int n = nextInt();
        int h = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int maxA = a[n-1];
        int index = bSearch(b, maxA);

        int count = 0;
        for (int i = n - 1; i >= index && h>0; i--) {
            h-=b[i];
            count++;
        }
        if (h>0) {
            count += (h+maxA-1)/maxA;
        }

        out.println(count);
        out.flush();
    }

    private static int bSearch(int[] array, int x) {
        if (array[array.length-1] < x) return array.length;
        if (x <= array[0]) return 0;

        int ok = array.length-1;
        int ng = -1;
        while (Math.abs(ok-ng)>1) {
            int p = (ok+ng)/2;
            if (x <= array[p]) {
                ok = p;
            } else {
                ng = p;
            }
        }
        return ok;
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