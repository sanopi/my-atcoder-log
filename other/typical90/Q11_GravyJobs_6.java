import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11_GravyJobs_6 {

    public static void main(String[] args) {
        int n = nextInt();
        int maxD = 0;
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            int d = nextInt();
            int c = nextInt();
            long s = nextLong();
            tasks[i] = new Task(d, c, s);
            maxD = Math.max(maxD, d);
        }
        Arrays.sort(tasks, Comparator.comparing((Task task) -> task.d).thenComparing(task -> task.startDead));

        // i個目までの仕事を見ていて、j日目以降に仕事をしない場合（j日目に新たに仕事を増やさない）の最大値
        long[][] dp = new long[n+1][maxD+1];
        for (int i = 1; i <= n; i++) {
            Task ti = tasks[i - 1];
            dp[i] = Arrays.copyOf(dp[i-1], maxD+1);
            for (int j = 0; j < maxD; j++) {
                if (ti.startDead <= j) continue;
                dp[i][j+ti.c] = Math.max(dp[i][j+ti.c], dp[i-1][j]+ti.s);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        long ans = Arrays.stream(dp[n]).max().getAsLong();
        out.println(ans);
        out.flush();
    }

    private static class Task {
        int d;
        int c;
        int startDead;
        long s;
        public Task(int d, int c, long s) {
            this.d = d;
            this.c = c;
            this.startDead = d-c+1;
            this.s = s;
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