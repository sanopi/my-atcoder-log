import java.io.PrintWriter;
import java.util.Scanner;

public class ABC152D {

    public static void main(String[] args) {
        int n = nextInt();
        int[][] count = new int[10][10];
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            count
                [s.charAt(0)-'0']
                [s.charAt(s.length()-1)-'0']
                ++;
        }


        long ans = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                ans += (long) count[i][j] * count[j][i];
            }
        }
        out.println(ans);
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