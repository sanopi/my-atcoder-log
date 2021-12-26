import java.io.PrintWriter;
import java.util.Scanner;

public class ARC132B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] ps = nextIntArray(n);
        int onePosition = -1;
        int nPosition = -1;
        for (int i = 0; i < n; i++) {
            if (ps[i] == 1) {
                onePosition = i;
            }
            if (ps[i] == n) {
                nPosition = i;
            }
        }

        if (onePosition == n-1 && nPosition == 1) {
            System.out.println(1);
            return;
        }
        if (onePosition == 0 && nPosition == n-1) {
            System.out.println(0);
            return;
        }

        int ans = Integer.MAX_VALUE;
        if (onePosition < nPosition) { // 逆順
            ans = Math.min(ans, pullOneToEnd(onePosition) + 1);
            ans = Math.min(ans, 1+pullOneToTop(n-1-onePosition));
        } else { // 正しい順序
            ans = Math.min(ans, pullOneToTop(onePosition));
            ans = Math.min(ans, 1+pullOneToEnd(n-1-onePosition)+1);
        }
        out.println(ans);
        out.flush();
    }

    private static int pullOneToTop(int index) {
        return index;
    }

    private static int pullOneToEnd(int index) {
        return index+1;
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