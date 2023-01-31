import java.io.PrintWriter;
import java.util.Scanner;

public class ARC154A {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        char[] A = next().toCharArray();
        char[] B = next().toCharArray();
        long a = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < B[i]) {
                char tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
            a = (a*10+A[i]-'0')%MOD;
            b = (b*10+B[i]-'0')%MOD;
        }

        out.println(a*b%MOD);

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