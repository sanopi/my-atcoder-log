import java.io.PrintWriter;
import java.util.Scanner;

public class ABC051C {

    public static void main(String[] args) {
        int sx = nextInt();
        int sy = nextInt();
        int tx = nextInt();
        int ty = nextInt();
        String fx;
        String bx;
        if (sx < tx) {
            fx = "R";
            bx = "L";
        } else {
            fx = "L";
            bx = "R";
        }
        String fy;
        String by;
        if (sy < ty) {
            fy = "U";
            by = "D";
        } else {
            fy = "D";
            by = "U";
        }

        int diffx = Math.abs(sx - tx);
        int diffy = Math.abs(sy - ty);
        String ans = new StringBuilder()
            .append(fx.repeat(diffx)).append(fy.repeat(diffy))
            .append(bx.repeat(diffx)).append(by.repeat(diffy))
            .append(by).append(fx.repeat(diffx + 1)).append(fy.repeat(diffy + 1)).append(bx)
            .append(fy).append(bx.repeat(diffx + 1)).append(by.repeat(diffy + 1)).append(fx)
            .toString();
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