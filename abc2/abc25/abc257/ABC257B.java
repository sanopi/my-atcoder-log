import java.io.PrintWriter;
import java.util.Scanner;

public class ABC257B {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int q = nextInt();
        boolean[] koma = new boolean[n];
        for (int i = 0; i < k; i++) {
            koma[nextInt()-1] = true;
        }
        while (q-->0) {
            int l = nextInt();
            int count = 0;
            int index = -1;
            while (count != l) {
                index++;
                if (koma[index]) {
                    count++;
                }
            }
            if (index == n-1) continue;
            if (koma[index+1]) continue;
            if (koma[index]) {
                koma[index+1] = true;
                koma[index] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (koma[i]) {
                out.print((i+1) + " ");
            }
        }
        out.println();
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