import java.io.PrintWriter;
import java.util.Scanner;

public class Q44_ShiftAndSwapping_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        int t2Count = 0;
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int x = nextInt()-1;
            int y = nextInt()-1;
            if (t == 1) {
                int xx = (((x - t2Count) % n) + n) % n;
                int yy = ((y - t2Count) % n + n) % n;
                int tmp = a[xx];
                a[xx] = a[yy];
                a[yy] = tmp;
            } else if (t == 2) {
                t2Count += 1;
            } else {
                int xx = ((x - t2Count) % n + n) % n;
                out.println(a[xx]);
            }
        }
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
}