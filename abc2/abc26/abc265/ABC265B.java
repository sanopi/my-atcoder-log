import java.io.PrintWriter;
import java.util.Scanner;

public class ABC265B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long t = nextInt();
        int[] a = nextIntArray(n-1);
        int[] bonus = new int[n];
        for (int i = 0; i < m; i++) {
            bonus[nextInt()-1] = nextInt();
        }

        int index = -1;
        while (index<n-2 && t > 0) {
            index++;
            t+=bonus[index];
            t-=a[index];
        }
        if (t>0&&index==n-2) {
            out.println("Yes");
        } else {
            out.println("No");
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