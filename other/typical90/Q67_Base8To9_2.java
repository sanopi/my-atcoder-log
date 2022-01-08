import java.io.PrintWriter;
import java.util.Scanner;

public class Q67_Base8To9_2 {

    public static void main(String[] args) {
        String n = next();
        int k = nextInt();

        for (int j = 0; j < k; j++) {
            String[] s = n.split("");
            long d = 0;
            long p = 1;
            for (int i = s.length - 1; i >= 0; i--) {
                d += Long.parseLong(s[i]) * p;
                p *= 8L;
            }

            String next = "";
            do {
                long r = d % 9L;
                next = r + next;
                d /= 9L;
            } while (d != 0);
            n = next.replaceAll("8", "5");
        }
        out.println(n);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

}