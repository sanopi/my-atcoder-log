import java.io.PrintWriter;
import java.util.Scanner;

public class ABC235A {

    public static void main(String[] args) {
        char[] chars  = next().toCharArray();
        int a = Integer.parseInt(Character.toString(chars[0]));
        int b = Integer.parseInt(Character.toString(chars[1]));
        int c = Integer.parseInt(Character.toString(chars[2]));
        System.out.println(100*(a+b+c)+10*(a+b+c)+a+b+c);
        out.flush();
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