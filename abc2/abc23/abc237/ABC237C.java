import java.io.PrintWriter;
import java.util.Scanner;

public class ABC237C {

    public static void main(String[] args) {
        String s = next();
        int i = s.length()-1;
        while (i>=0) {
            if (s.charAt(i) != 'a') {
                break;
            }
            i--;
        }
        if (i==-1) {
            System.out.println("Yes");
            return;
        }

        int j = 0;
        while (j<s.length()) {
            if (s.charAt(j) != 'a') {
                break;
            }
            j++;
        }

        s = "a".repeat(Math.max(0, s.length()-i-j-1)) + s;
        int n = s.length();
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) != s.charAt(n-1-k)) {
                System.out.println("No");
                return;
            }
        }
        out.println("Yes");
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