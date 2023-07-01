import java.io.PrintWriter;
import java.util.Scanner;

public class ABC308A {

    public static void main(String[] args) {
        int[]  s = new int[8];
        for (int i = 0; i < 8; i++) {
            s[i] = nextInt();
        }
        boolean inc = true;
        for (int i = 1; i < 8; i++) {
            inc &= s[i-1]<=s[i];
        }
        boolean range =true;
        boolean x25 =true;

        for (int i = 0; i < 8; i++) {
            int si = s[i];
            range &= (100<=si && si <=675);
            x25 &= si%25==0;
        }
        if (inc && range && x25) {
            out.println("Yes");
        } else {
            out.println("No");
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