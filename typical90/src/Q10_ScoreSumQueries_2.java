import java.io.PrintWriter;
import java.util.Scanner;

public class Q10_ScoreSumQueries_2 {

    public static void main(String[] args) {
        int n = nextInt();
        int[][] students = new int[2][n];
        for (int i = 0; i < n; i++) {
            int c = nextInt()-1;
            int p = nextInt();
            students[c][i] = p;
        }
        int[][] sum = new int[2][n];
        sum[0][0] = students[0][0];
        sum[1][0] = students[1][0];
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i-1] + students[0][i];
            sum[1][i] = sum[1][i-1] + students[1][i];
        }

        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            int lp0 = l == 0 ? 0 : sum[0][l-1];
            int rp0 = sum[0][r];
            int lp1 = l == 0 ? 0 : sum[1][l-1];
            int rp1 = sum[1][r];
            out.println((rp0-lp0) + " " + (rp1-lp1));
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
}