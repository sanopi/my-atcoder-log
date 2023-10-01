import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC322E {

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        int p = nextInt();
        An[] ans = new An[n];
        for (int i = 0; i < n; i++) {
            int c = nextInt();
            int[] a = new int[k];
            for (int j = 0; j < k; j++) {
                a[j] = Math.min(nextInt(), p);
            }
            ans[i] = new An(c, a);
        }

        Map<List<Integer>, Long>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        ArrayList<Integer> fList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            fList.add(0);
        }
        dp[0].put(fList, 0L);
        ArrayList<Integer> ffList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ffList.add(ans[0].a[i]);
        }
        dp[0].merge(ffList, ans[0].c, Math::min);

        for (int i = 1; i < n; i++) {
            Map<List<Integer>, Long> prev = dp[i-1];
            Map<List<Integer>, Long> current = dp[i];
            An an = ans[i];
            prev.forEach((list, cost) -> {
                current.merge(list, cost, Math::min);
                ArrayList<Integer> next = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    next.add(Math.min(p, list.get(j)+an.a[j]));
                }
                current.merge(next, cost+an.c, Math::min);
            });
        }
        List<Integer> ansKey = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ansKey.add(p);
        }
        if (!dp[n-1].containsKey(ansKey)) {
            out.println(-1);
        } else {
            out.println(dp[n-1].get(ansKey));
        }

        out.flush();
    }

    private static class An {
        long c;
        int[] a;
        public An(int c, int[] a) {
            this.c = c;
            this.a = a;
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