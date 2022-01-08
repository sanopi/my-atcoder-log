import java.io.PrintWriter;
import java.util.Scanner;

public class Q52_DiceProduct_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                sum += nextInt();
            }
            aa[i] = sum;
        }
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = (ans * aa[i]) % 1000000007;
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