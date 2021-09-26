import java.io.PrintWriter;
import java.util.Scanner;

public class ABC220B {

    public static void main(String[] args) {
        int k = nextInt();
        String a = next();
        String b = next();

        long ai = 0;
        char[] charsA = a.toCharArray();
        int x = 1;
        for (int i = charsA.length - 1; i >= 0; i--) {
            int i1 = Integer.parseInt(Character.toString(charsA[i]));
            ai += ((long) x * i1);
            x *= k;
        }

        long bi = 0;
        char[] charsB = b.toCharArray();
        int y = 1;
        for (int i = charsB.length - 1; i >= 0; i--) {
            int i1 = Integer.parseInt(Character.toString(charsB[i]));
            bi += ((long) y * i1);
            y *= k;
        }

        out.println(ai * bi);

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