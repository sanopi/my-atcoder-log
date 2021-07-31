import java.io.PrintWriter;
import java.util.Scanner;

public class ABC212B {

    public static void main(String[] args) {
        String[] s = next().split("");
        int[] x = new int[4];
        for (int i = 0; i < 4; i++) {
            x[i] = Integer.parseInt(s[i]);
        }

        boolean same = x[0] == x[1] && x[1] == x[2] && x[2] == x[3];
        if (same) {
            out.println("Weak");
            out.flush();
            return;
        }

        boolean serial = true;
        for (int i = 0; i < 3; i++) {
            if (x[i] == 9) {
                serial = serial && x[i+1] == 0;
            } else {
                serial = serial && x[i+1] == x[i] + 1;
            }
        }
        if (serial) {
            out.println("Weak");
        } else {
            out.println("Strong");
        }

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
}