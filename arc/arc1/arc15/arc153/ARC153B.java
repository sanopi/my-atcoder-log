import java.io.PrintWriter;
import java.util.Scanner;

public class ARC153B {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] a = new char[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = next().toCharArray();
        }

        int sh = 0;
        int sw = 0;
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int u = nextInt();
            int v = nextInt();
            if (i % 2 == 1) {
                u = -u;
                v = -v;
            }

            sh = ((sh - u) + h) %h;
            sw = ((sw - v) + w) %w;
        }
        int[] hh = new int[h];
        hh[sh] = 0;
        int hc = h;
        while (hc --> 1) {
            int base = hh[sh];
            sh = (sh+1)%h;
            hh[sh] = base+1;
        }

        int[] ww = new int[w];
        ww[sw] = 0;
        int wc = w;
        while (wc --> 1) {
            int base = ww[sw];
            sw = (sw+1)%w;
            ww[sw] = base+1;
        }
        if (q % 2 == 1) {
            int[] hhh = new int[h];
            for (int i = 0; i < h; i++) {
                hhh[i] = hh[h-i-1];
            }
            hh = hhh;

            int[] www = new int[w];
            for (int i = 0; i < w; i++) {
                www[i] = ww[w-i-1];
            }
            ww = www;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                out.print(a[hh[i]][ww[j]]);
            }
            out.println();
        }

        out.flush();
    }


    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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