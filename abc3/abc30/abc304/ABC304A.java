import java.io.PrintWriter;
import java.util.Scanner;

public class ABC304A {

    public static void main(String[] args) {
        int n = nextInt();
        String[] s = new String[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
            a[i] = nextInt();
        }
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }

        int count = n;
        while (count-->0) {
            out.println(s[index]);
            index = (index+1)%n;
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