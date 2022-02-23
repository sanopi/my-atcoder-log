import java.io.PrintWriter;
import java.util.Scanner;

public class Diverta2019D {

    public static void main(String[] args) {
        long n = nextLong();
        // n = k*m + k = k(m+1) の、mを足し合わせる
        // 0 <= k < m
        // nの約数のうち、大きい方から1を引いた数を足すだけで良い。
        long ans = 0;
        for (long i = 1; i*i < n; i++) {
            if (n%i==0 && i < (n/i)-1) {
                ans+=(n/i)-1;
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