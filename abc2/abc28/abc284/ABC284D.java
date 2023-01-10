import java.io.PrintWriter;
import java.util.Scanner;

public class ABC284D {

    public static void main(String[] args) {
        int t = nextInt();
        while (t --> 0) {
            long n = nextLong();
            for (long i = 2; i*i*i <= n; i++) {
                int count = 0;
                while (n%i==0) {
                    count++;
                    n/=i;
                }
                if (count == 1) {
                    double p = Math.sqrt(n);
                    out.println(Math.round(p) + " " + i);
                } else if (count == 2) {
                    out.println(i + " " + n);
                }
            }
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