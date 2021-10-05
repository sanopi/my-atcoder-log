import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC221C {

    public static void main(String[] args) {
        char[] n = next().toCharArray();
        Arrays.sort(n);

        int max = 0;
        for (int i = 0; i < (1 << n.length); i++) {
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < n.length; j++) {
                if ((i & (1 << j)) == 0) {
                    a.append(n[n.length - j - 1]);
                } else {
                    b.append(n[n.length - j - 1]);
                }
            }
            String as = a.toString();
            String bs = b.toString();
            if (as.length() > 0 && bs.length() > 0) {
                max = Math.max(max, Integer.parseInt(as) * Integer.parseInt(bs));
            }
        }

        out.println(max);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}