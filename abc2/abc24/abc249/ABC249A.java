import java.io.PrintWriter;
import java.util.Scanner;

public class ABC249A {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();
        int e = nextInt();
        int f = nextInt();
        int x = nextInt();
        int taka = 0;
        int aoki = 0;

        taka += x/(a+c)*(a*b);
        taka += Math.min(x%(a+c), a)*b;

        aoki += x/(d+f)*(d*e);
        aoki += Math.min(x%(d+f), d)*e;

        if (taka == aoki) {
            out.println("Draw");
        } else if (taka > aoki) {
            out.println("Takahashi");
        } else {
            out.println("Aoki");
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