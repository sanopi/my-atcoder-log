import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AGC014A {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        Set<Integer> prev = new HashSet<>();
        prev.add(a); prev.add(b); prev.add(c);
        int count = 0;
        while (true) {
            if (a % 2!=0 || b % 2!=0 || c % 2!=0) {
                break;
            }
            int a2 = a/2;
            int b2 = b/2;
            int c2 = c/2;
            a = b2+c2;
            b = a2+c2;
            c = a2+b2;
            Set<Integer> current = new HashSet<>();
            current.add(a); current.add(b); current.add(c);
            if (prev.equals(current)) {
                System.out.println(-1);
                return;
            }
            prev = current;
            count++;
        }
        out.println(count);
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