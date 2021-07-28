import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q08_AtCounter_4 {

    public static void main(String[] args) {
        int n = nextInt();
        char[] s = next().toCharArray();
        char[] atcoder = "atcoder".toCharArray();

        int[][] dp = new int[n][atcoder.length];

        Arrays.fill(dp[0], 0);
        if (s[0] == 'a') {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            char letter = s[i];
            for (int j = 0; j < atcoder.length; j++) {
                if (letter == atcoder[j]) {
                    int prev = j == 0 ? 1 : dp[i-1][j-1];
                    dp[i][j] = (dp[i-1][j] + prev) % 1000000007;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        out.println(dp[n-1][atcoder.length-1]);
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