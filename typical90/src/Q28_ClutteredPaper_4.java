import java.io.PrintWriter;
import java.util.Scanner;

public class Q28_ClutteredPaper_4 {

    public static void main(String[] args) {
        int n = nextInt();
        int[][] paper = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            int lx = nextInt();
            int ly = nextInt();
            int rx = nextInt();
            int ry = nextInt();
            paper[lx][ly] += 1;
            paper[rx][ry] += 1;
            paper[rx][ly] += -1;
            paper[lx][ry] += -1;
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1000; j++) {
                paper[i][j+1] += paper[i][j];
            }
        }
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1001; j++) {
                paper[i+1][j] += paper[i][j];
            }
        }

        int[] ans = new int[n+1];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                ans[paper[i][j]] += 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.println(ans[i]);
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