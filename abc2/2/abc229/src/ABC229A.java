import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC229A {

    public static void main(String[] args) {
        char[][] g = new char[2][2];
        g[0] = next().toCharArray();
        g[1] = next().toCharArray();
        List<Integer> l = new ArrayList<>();
        if (g[0][0] == '.' && g[1][1] == '.' || (g[1][0] == '.' && g[0][1] == '.')) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }


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