import java.io.PrintWriter;
import java.util.Scanner;

public class ABC229B {

    public static void main(String[] args) {
        String a = next();
        String b = next();
        if (a.length() > b.length()) {
            b = "0".repeat(a.length()-b.length()) +b;
        } else {
            a = "0".repeat(b.length()-a.length()) +a;
        }
        for (int i = 0; i < a.length(); i++) {
            if (Integer.parseInt(a.substring(i,i+1)) + Integer.parseInt(b.substring(i,i+1)) >= 10) {
                System.out.println("Hard");
               return;
            }
        }
        System.out.println("Easy");


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