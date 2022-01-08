import java.io.PrintWriter;
import java.util.Scanner;

public class Q18_StatueOfChokudai_3 {

    public static void main(String[] args) {
        double t = nextDouble();
        double l = nextDouble();
        double x = nextDouble();
        double y = nextDouble();
        double q = nextDouble();

        for (int i = 0; i < q; i++) {
            double e = nextInt() % t;
            double ly = -1 * (l / 2) * Math.sin(Math.toRadians((e / t) * (double) 360));
            double lz = -1 * (l / 2) * Math.cos(Math.toRadians((e / t) * (double) 360)) + (l / 2);
            double a = Math.sqrt(lz*lz);
            double b = Math.sqrt(x*x + (ly-y)*(ly-y));
            double ans = Math.toDegrees(Math.atan2(a, b));
            out.println(ans);
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