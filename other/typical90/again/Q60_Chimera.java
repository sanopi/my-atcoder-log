package again;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q60_Chimera {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int[] l = new int[n];
        int[] lisL = new int[n];
        Arrays.fill(lisL, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int found = Arrays.binarySearch(lisL, a[i]);
            if (found<0) {
                found = ~found;
                lisL[found] = a[i];
            }
            l[i] = found+1;
        }

        int[] r = new int[n];
        int[] lisR = new int[n];
        Arrays.fill(lisR, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int ai = a[n-1-i];
            int found = Arrays.binarySearch(lisR, ai);
            if (found<0) {
                found = ~found;
                lisR[found] = ai;
            }
            r[i] = found+1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, l[i] + r[n-1-i]-1);
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