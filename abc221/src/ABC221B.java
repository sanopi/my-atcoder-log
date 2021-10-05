import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC221B {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        char[] t = next().toCharArray();
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != t[i]) {
                ind.add(i);
            }
        }

        if (ind.size() == 0) {
            out.println("Yes");
        } else
        if (ind.size() == 2) {
            if (ind.get(0)+1 == ind.get(1) && s[ind.get(0)] == t[ind.get(1)] && s[ind.get(1)] == t[ind.get(0)]) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        } else {
            out.println("No");
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