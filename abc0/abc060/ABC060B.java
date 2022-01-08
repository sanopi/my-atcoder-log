import java.io.PrintWriter;
import java.util.Scanner;

public class ABC060B {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        a = a%b;
        if (a == 0) {
            System.out.println("NO");
            return;
        }
        int aa = a;
        boolean ok = c%aa==0;
        while (aa != 0) {
            ok |= c%aa==0;
            aa = (aa + a) % b;
        }
        out.println(ok?"YES":"NO");
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