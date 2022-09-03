import java.io.PrintWriter;
import java.util.Scanner;

public class ABC267B {

    public static void main(String[] args) {
        int[] rows = {3, 2, 4, 1, 3, 5, 0, 2, 4, 6};
        int[] count = new int[7];

        String s = next();
        if (s.charAt(0) == '1') {
            System.out.println("No");
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (s.charAt(i) == '1') {
                count[rows[i]]++;
            }
        }

        boolean ok = false;
        for (int i = 0; i < 5; i++) {
            for (int j = i+2; j < 7; j++) {
                if (count[i] == 0 || count[j] == 0) continue;
                for (int k = i+1; k < j; k++) {
                    ok |= count[k]==0;
                }
            }
        }
        out.println(ok?"Yes":"No");

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