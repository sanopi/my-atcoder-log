import java.io.PrintWriter;
import java.util.Scanner;

public class ABC251E {

    private static int[] a;
    private static long[][] dp1;
    private static long[][] dp2;
    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        a = nextIntArray(n);

        // あげる場合とあげない場合で場合分けしてDPを行う
        // N-1であげない場合、Maxがn-1
        dp1 = new long[n][2];
        long ans1 = memoRec1(0, 1);
        // N-1であげる場合、Maxがn-2
        dp2 = new long[n][2];
        long ans2 = memoRec2(0, 0) + a[n-1];
        out.println(Math.min(ans1, ans2));
        out.flush();
    }

    private static long memoRec1(int i, int must/*1なら必須*/) {
        if (dp1[i][must]>0) return dp1[i][must];
        if (i==n-2) {
            return a[i];
        }

        long res;
        if (must == 1) {
            res = memoRec1(i+1, 0) + a[i];
        } else {
            res = Math.min(memoRec1(i+1, 0) + a[i], memoRec1(i+1, 1));
        }
        return dp1[i][must] = res;
    }

    private static long memoRec2(int i, int must/*1なら必須*/) {
        if (dp2[i][must]>0) return dp2[i][must];
        if (i==n-2) {
            return must==1?a[i]:0;
        }

        long res;
        if (must == 1) {
            res = memoRec2(i+1, 0) + a[i];
        } else {
            res = Math.min(
                memoRec2(i+1, 0) + a[i],
                memoRec2(i+1, 1)
            );
        }
        return dp2[i][must] = res;
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