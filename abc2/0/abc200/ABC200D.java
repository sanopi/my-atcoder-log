import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ABC200D {

    private static final int MOD = 200;
    private static boolean[][] dp;
    private static int[] a;

    public static void main(String[] args) {
//        solve1();
        solve2();
        out.flush();
    }

    private static void solve2() {
        int n = nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt() % MOD;
        }
        int max = Math.min(n, 8);
        ArrayList<Integer>[] candidates = new ArrayList[MOD];
        List<Integer> b = null;
        List<Integer> c = null;
        for (long i = 0; i < 1L << max; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < max; j++) {
                if ((i&(1<<j)) != 0) {
                    list.add(j);
                }
            }
            int sum = list.stream().mapToInt(k -> a[k]).sum() % MOD;
            if (list.isEmpty()) {
                continue;
            }
            Collections.sort(list);
            if (candidates[sum] == null) {
                candidates[sum] = list;
            } else {
                b = list;
                c = candidates[sum];
                break;
            }
        }
        if (b == null) {
            out.println("No");
        } else {
            out.println("Yes");
            out.print(b.size() + " ");
            for (final Integer integer : b) {
                out.print((integer+1) + " ");
            }
            out.println();
            out.print(c.size() + " ");
            for (final Integer integer : c) {
                out.print((integer+1) + " ");
            }
        }
    }

    private static void solve1() {
        int n = nextInt();
        a = nextIntArray(n);

        dp = new boolean[n][MOD];
        dp[0][a[0]%MOD] = true;
        int index = 0;
        int point = -1;
        while (point < 0 && ++index < n) {
            dp[index][a[index]%MOD] = true;
            for (int current = 0; current < MOD; current++) {
                if (!dp[index-1][current]) continue;
                if (!dp[index][current]) {
                    dp[index][current] = true;
                } else {
                    point = current;
                    break;
                }
                int next = (current + a[index]) % MOD;
                if (!dp[index][next]) {
                    dp[index][next] = true;
                } else {
                    point = next;
                    break;
                }
            }
        }

        if (point < 0) {
            System.out.println("No");
            return;
        }

        List<Integer> b = new ArrayList<>();
        back(index, point, b);

        List<Integer> c = new ArrayList<>();
        if (a[index] % MOD == point && !dp[index - 1][point]) {
            c.add(index);
        }
        back(index - 1, point, c);

        if (b.size() > 0 && c.size() > 0) {
            Collections.reverse(b);
            Collections.reverse(c);
            out.println("Yes");
            out.print(b.size() + " ");
            for (final Integer integer : b) {
                out.print((integer+1) + " ");
            }
            out.println();
            out.print(c.size() + " ");
            for (final Integer integer : c) {
                out.print((integer+1) + " ");
            }

        } else {
            out.println("No");
        }
    }

    private static void back(int i, int p, List<Integer> list) {
        if (i == 0) {
            if (dp[i][p]) {
                list.add(i);
            }
            return;
        }
        int prev = (((p - a[i]) % MOD) + MOD) % MOD;
        if (dp[i-1][prev]) {
            list.add(i);
            back(i - 1, prev, list);
        } else if (a[i] % MOD == p) {
            list.add(i);
        } else if (dp[i-1][p]) {
            back(i-1, p, list);
        }
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