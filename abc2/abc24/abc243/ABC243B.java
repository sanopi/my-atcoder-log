import java.io.PrintWriter;
import java.util.Scanner;

public class ABC243B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i]==b[i]) count1++;
        }
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (a[i] == b[j]) count2++;
            }
        }

        out.println(count1);
        out.println(count2);


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