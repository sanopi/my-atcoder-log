import java.io.PrintWriter;
import java.util.Scanner;

public class APC001B {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        long[] b = nextLongArray(n);

        long bAddCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= b[i]) continue;
            long diff = b[i] - a[i];
            a[i] += (diff +1)/2*2;
            b[i] += (diff) %2;
            bAddCount += (diff) /2;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) continue;
            long bAdd = a[i] - b[i];
            bAddCount-= bAdd;
            b[i]+= bAdd;
        }
        out.println(bAddCount>=0?"Yes":"No");
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