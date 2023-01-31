import java.io.PrintWriter;
import java.util.Scanner;

public class ARC091C {

    public static void main(String[] args) {
        long n = nextInt();
        long m = nextInt();
        // 裏 -> 1 3 5 7 9
        long omote = n==1||m==1 ? n==1&&m==1?0 : 2 : (n+m)*2-4;
        out.println(Math.max(m*n-omote, 0));
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