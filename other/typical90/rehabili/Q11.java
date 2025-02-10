import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11 {

    private static void solve() {
        int n = nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            int d = nextInt();
            int c = nextInt();
            long s = nextLong();
            jobs[i] = new Job(d, c, s);
        }
        Arrays.sort(jobs, Comparator.comparing(job -> job.d));

        // 〇日目の終わりのタイミングでの最大報酬（0日目の終わりは何も仕事してない）
        long[][] dp = new long[n+1][5001];
        for (int i = 0; i < n; i++) {
            Job job = jobs[i];
            fill(job, dp[i+1], dp[i]);
        }


        out.print(dp[n][5000]);
        out.flush();
    }

    private static void fill(Job job, long[] current, long[] prev) {
        for (int i = 1; i <= 5000; i++) {
            if (i <= job.d && i-job.c >= 0) {
                current[i] = prev[i-job.c] + job.s;
            }
            current[i] = Math.max(current[i], prev[i]);
            current[i] = Math.max(current[i], current[i-1]);
        }
    }

    private static class Job {
        int d;
        int c;
        long s;
        public Job(int d, int c, long s) {
            this.d = d;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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