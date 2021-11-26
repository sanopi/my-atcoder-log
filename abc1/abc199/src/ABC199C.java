import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC199C {

    public static void main(String[] args) {

        int n = nextInt();
        char[] s = next().toCharArray();
        char[] first = Arrays.copyOfRange(s, 0, n);
        char[] second = Arrays.copyOfRange(s, n, 2*n);

        boolean inverted = false;

        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int a = nextInt()-1;
            int b = nextInt()-1;
            if (t == 1) {
                if (inverted) {
                    a = (a+n)%(2*n);
                    b = (b+n)%(2*n);
                }
                char[] aArray = a < n ? first : second;
                char[] bArray = b < n ? first : second;
                a %= n;
                b %= n;
                char tmp = aArray[a];
                aArray[a] = bArray[b];
                bArray[b] = tmp;
            } else if (t == 2) {
                inverted = !inverted;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (inverted) {
            for (final char c : second) {
                sb.append(c);
            }
        }
        for (final char c : first) {
            sb.append(c);
        }
        if (!inverted) {
            for (final char c : second) {
                sb.append(c);
            }
        }
        out.println(sb.toString());
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