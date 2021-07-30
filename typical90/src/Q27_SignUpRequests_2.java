import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q27_SignUpRequests_2 {

    public static void main(String[] args) {
        int n = nextInt();
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = next();
            if (ss.contains(s)) {
                continue;
            }
            ss.add(s);
            out.println(i+1);
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