import java.io.PrintWriter;
import java.util.Scanner;

public class ABC286A {

    public static void main(String[] args) {
        int n = nextInt();
        int p = nextInt()-1;
        int q = nextInt()-1;
        int r = nextInt()-1;
        int s = nextInt()-1;
        int[] a = nextIntArray(n);
        for (int i = 0; i < p; i++) {
            out.print(a[i]+ " ");
        }

        for (int i = r; i <= s; i++) {
            out.print(a[i]+" ");
        }

        for (int i = q+1; i < r; i++) {
            out.print(a[i]+ " ");
        }

        for (int i = p; i <= q; i++) {
            out.print(a[i]+" ");
        }

        for (int i = s+1; i < n; i++) {
            out.print(a[i]+ " ");
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