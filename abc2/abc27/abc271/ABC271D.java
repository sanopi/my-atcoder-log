import java.io.PrintWriter;
import java.util.Scanner;

public class ABC271D {

    public static void main(String[] args) {
        int n = nextInt();
        int s = nextInt();
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            cards[i] = new Card(nextInt(), nextInt());
        }
        boolean[][] dp = new boolean[n+1][s+1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            int ai = cards[i].a;
            int bi = cards[i].b;
            for (int j = 0; j < s; j++) {
                if (ai+j<=s) {
                    dp[i+1][ai+j] = dp[i+1][ai+j] | dp[i][j];
                }
                if (bi+j<=s) {
                    dp[i+1][bi+j] = dp[i+1][bi+j] | dp[i][j];
                }
            }
        }
        if (!dp[n][s]) {
            System.out.println("No");
            return;
        }

        int sum = s;
        StringBuilder ans = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            int ai = cards[i].a;
            int bi = cards[i].b;
            if (sum-ai>=0 && dp[i][sum-ai]) {
                sum -= ai;
                ans.append('H');
            } else if (sum-bi>=0 && dp[i][sum-bi]) {
                sum -= bi;
                ans.append('T');
            }
        }
        out.println("Yes");
        out.println(ans.reverse());
        out.flush();
    }

    private static class Card {
        int a;
        int b;
        public Card(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}