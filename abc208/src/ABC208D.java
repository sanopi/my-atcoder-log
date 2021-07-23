import java.util.Arrays;
import java.util.Scanner;

public class ABC208D {

    public static void main(String[] args) {
       ans1();
//       ans2();
    }

    public static void ans2() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int inf = 1000000000;

        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            int c = scanner.nextInt();
            g[a][b] = c;
        }

        long ans = 0;
        for (int k = 0; k < n; k++) {
            for (int s = 0; s < n; s++) {
                for (int t = 0; t < n; t++) {
                    g[s][t] = Math.min(g[s][t], g[s][k] + g[k][t]);
                    if (g[s][t] < inf) {
                        ans += g[s][t];
                    }
                }
            }
        }

        System.out.println(ans);
    }


    public static void ans1() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] g = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = c;
        }

        int[][][] dp = new int[n+1][n+1][n+1];
        for (int s = 0; s < n+1; s++) {
            for (int t = 0; t < n+1; t++) {
                if (s == t) {
                    dp[s][t][0] = 0;
                }
                else if (g[s][t] != 0) {
                    dp[s][t][0] = g[s][t];
                } else {
                    dp[s][t][0] = -1;
                }
            }
        }

        int ans = 0;

        for (int k = 1; k < n + 1; k++) {
            for (int s = 1; s < n + 1; s++) {
                for (int t = 1; t < n + 1; t++) {
                    int pre = dp[s][t][k - 1];
                    int firstHalf = dp[s][k][k - 1];
                    int secondHalf = dp[k][t][k - 1];

                    if (pre == -1) {
                        if (firstHalf == -1 || secondHalf == -1) {
                            dp[s][t][k] = -1;
                        } else {
                            dp[s][t][k] = firstHalf + secondHalf;
                        }
                    } else if (firstHalf == -1 || secondHalf == -1) {
                        dp[s][t][k] = pre;
                    } else {
                        dp[s][t][k] = Math.min(pre, firstHalf + secondHalf);
                    }

                    int tmp = dp[s][t][k];
                    if (tmp != -1) {
                        ans += tmp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
