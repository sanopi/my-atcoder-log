import java.io.PrintWriter;
import java.util.Scanner;

public class ABC269E {

    public static void main(String[] args) {
        int n = nextInt();
        int a = 1;
        int b = n;
        int c = 1;
        int d = n;
        while (b-a>0) {
            int aa = a;
            int bb = (a+b)/2;
            System.out.printf("? %d %d %d %d%n", aa, bb, 1, n);
            int res = nextInt();
            if (res == bb-aa+1) {
                a = bb+1;
            } else {
                b = bb;
            }
        }
        while (d-c>0) {
            int cc = c;
            int dd = (c+d)/2;
            System.out.printf("? %d %d %d %d%n", 1, n, cc, dd);
            int res = nextInt();
            if (res == dd-cc+1) {
                c = dd+1;
            } else {
                d = dd;
            }
        }
        System.out.printf("! %d %d%n", a, c);
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