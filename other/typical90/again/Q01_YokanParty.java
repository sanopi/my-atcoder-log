package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q01_YokanParty {

    public static void main(String[] args) {
        int n = nextInt();
        int l = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);
        int[] len = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            len[i] = (i<n?a[i]:l) - (i>0?a[i-1]:0);
        }
        int ng = l;
        int ok = 0;
        while (ng-ok>1){
            int p = (ok+ng)/2;
            int tmpLen = 0;
            int count = 0;
            for (int i = 0; i < n + 1; i++) {
                tmpLen+=len[i];
                if (tmpLen>=p) {
                    count++;
                    tmpLen=0;
                }
            }
            if (count >= k+1) ok = p;
            else ng = p;
        }
        out.println(ok);
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