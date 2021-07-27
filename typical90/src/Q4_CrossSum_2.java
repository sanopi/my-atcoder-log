import java.io.PrintWriter;
import java.util.Scanner;

public class Q4_CrossSum_2 {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();

        int[][] a = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = nextInt();
            }
        }

        int[] hSum = new int[h];
        int[] wSum = new int[w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                hSum[i] += a[i][j];
                wSum[j] += a[i][j];
            }
        }

        for (int i = 0; i < h; i++) {
            String[] ans = new String[w];
            for (int j = 0; j < w; j++) {
                ans[j] = String.valueOf(hSum[i] + wSum[j] - a[i][j]);
            }
            out.println(String.join(" ", ans));
        }
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static int nextInt() {
        return Integer.parseInt(scanner.next());
    }
    static long nextLong() {
        return Long.parseLong(scanner.next());
    }
}
