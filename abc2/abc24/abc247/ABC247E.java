import java.io.PrintWriter;
import java.util.Scanner;

public class ABC247E {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        int[] a = nextIntArray(n);

        int left = 0;
        int right = 0;
        int yi = -1;
        int xi = -1;
        long ans = 0;
        while (right<n && left<n) {
            if (a[right] < y || x < a[right]) {
                right++;
                left=right;
                yi=-1;
                xi=-1;
                continue;
            }
            if (a[right] == x) {
                xi = right;
            }
            if (a[right] == y) {
                yi = right;
            }

            if (xi>=0&&yi>=0) {
                ans+=Math.min(xi, yi)-left+1;
            }

            right++;
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