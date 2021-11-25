import java.util.Scanner;

public class ABC210D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        long c = scanner.nextInt();

        long[][] cost = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cost[i][j] = scanner.nextLong();
            }
        }

        long[][] dp = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp[i][j] = cost[i][j];
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j] ,dp[i-1][j] + c);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j] ,dp[i][j-1] + c);
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i > 0) {
                    ans = Math.min(dp[i-1][j] + c + cost[i][j], ans);
                }
                if (j > 0) {
                    ans = Math.min(dp[i][j-1] + c + cost[i][j], ans);
                }
            }
        }

        long[][] dp2 = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = w-1; j >= 0; j--) {
                dp2[i][j] = cost[i][j];
                if (i > 0) {
                    dp2[i][j] = Math.min(dp2[i][j] ,dp2[i-1][j] + c);
                }
                if (j < w-1) {
                    dp2[i][j] = Math.min(dp2[i][j] ,dp2[i][j+1] + c);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = w-1; j >= 0; j--) {
                if (i > 0) {
                    ans = Math.min(dp2[i-1][j] + c + cost[i][j], ans);
                }
                if (j < w-1) {
                    ans = Math.min(dp2[i][j+1] + c + cost[i][j], ans);
                }
            }
        }

        System.out.println(ans);
    }
}
