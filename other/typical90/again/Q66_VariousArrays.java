package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q66_VariousArrays {

    public static void main(String[] args) {
        int n = nextInt();
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = nextInt();
            R[i] = nextInt();
        }

        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int allCount = (R[i]-L[i]+1)*(R[j]-L[j]+1);
                int invertCount = 0;
                for (int k = L[i]; k <= R[i]; k++) {
                    invertCount+= Math.max(0, Math.min(R[j]-L[j]+1, k-L[j]));
                }
                ans += (double)invertCount/allCount;
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