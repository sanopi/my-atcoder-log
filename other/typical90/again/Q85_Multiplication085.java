package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q85_Multiplication085 {

    public static void main(String[] args) {
        long k = nextLong();
        long ans = 0;
        for (long i = 1; i*i*i <= k; i++) {
            if (k%i!=0) continue;
            for (long j = i; i*j*j <= k; j++) {
                if ((k/i)%j!=0) continue;
                ans++;
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