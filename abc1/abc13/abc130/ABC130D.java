import java.io.PrintWriter;
import java.util.Scanner;

public class ABC130D {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        int[] a = nextIntArray(n);
        long[] sum = new long[n+1];
        for (int i = 1; i < n+1; i++) {
            sum[i] = a[i-1]+sum[i-1];
        }
        long ans = 0;
        for (int i = 1; i < n+1; i++) {
            long point = sum[i]-k;
            if (point < 0){
                continue;
            }
            ans += lowerBind(sum, point)+1;
        }
        out.println(ans);
        out.flush();
    }

    private static int lowerBind(long[] sum, long point) {
        int ok = 0;
        int ng = sum.length;
        while (Math.abs(ok-ng) > 1) {
            int next = (ok+ng)/2;
            if (sum[next] <= point) {
                ok = next;
            } else {
                ng = next;
            }
        }
        return ok;
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