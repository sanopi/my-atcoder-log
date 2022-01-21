import java.io.PrintWriter;
import java.util.Scanner;

public class ARC098C {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        char[] chars = s.toCharArray();
        int[] wSum = new int[n];
        int[] eSum = new int[n];
        for (int i = 0; i < n; i++) {
            wSum[i] = (i>0?wSum[i-1]:0) + (s.charAt(i)=='W'?1:0);
            eSum[i] = (i>0?eSum[i-1]:0) + (s.charAt(i)=='E'?1:0);
        }

        int ans = n+1;
        for (int i = 0; i < n; i++) {
            ans = Math.min(
                ans,
                (i>0?wSum[i-1]:0) + (i<n-1?(eSum[n-1]-eSum[i]):0)
            );
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