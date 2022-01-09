import java.io.PrintWriter;
import java.util.Scanner;

public class Q10_Sushi {

    private static int n;
    private static double[][][] dp;
    public static void main(String[] args) {
        n = nextInt();
        int[] a = nextIntArray(n);

        dp = new double[n+1][n+1][n+1];
        int[] counts = new int[4];
        for(int i:a)counts[i]++;

        double ans = memoRec(counts[1],counts[2],counts[3]);

        out.println(ans);
        out.flush();
    }

    private static double memoRec(int one, int two, int three) {
        if(one+two+three==0) return 0;
        if (dp[one][two][three] > 0) {
            return dp[one][two][three];
        }
        double sum = one+two+three;
        double k = 1-(1-sum/n);

        double res = 0;
        if(one>0) res+=(memoRec(one-1, two, three)*(((double) one/n))/k);
        if(two>0) res+=(memoRec(one+1, two-1, three)*(((double) two/n))/k);
        if(three>0) res+=(memoRec(one, two+1, three-1)*(((double) three/n))/k);
        res += 1/k;

        dp[one][two][three]=res;
        return res;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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