import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q16_MinimumCoins_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] coins = new int[3];
        for (int i = 0; i < 3; i++) {
            coins[i] = nextInt();
        }
        Arrays.sort(coins);

        int min = Integer.MAX_VALUE;

        int aMax = n / coins[2];
        for (int i = 0; i <= aMax; i++) {
            int restA = n - coins[2] * i;
            int bMax = restA / coins[1];
            for (int j = 0; j <= bMax; j++) {
                int restB = restA - coins[1] * j;
                if (restB % coins[0] == 0) {
                    int ans = i + j + restB / coins[0];
                    if (ans < min) {
                        min = ans;
                    }
                }
            }
        }

        out.println(min);
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