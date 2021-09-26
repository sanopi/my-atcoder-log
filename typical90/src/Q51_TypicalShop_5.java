import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class Q51_TypicalShop_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int n1 = n / 2;
        int n2 = n - n1;
        int k = nextInt();
        long p = nextLong();

        if (n == 1) {
            System.out.println(nextLong() <= p ? 1 : 0);
            return;
        }

        long[] a1 = new long[n1];
        long[] a2 = new long[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = nextLong();
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = nextLong();
        }

        ArrayList<Long>[] total1 = new ArrayList[n1 + 1];
        for (int i = 0; i <= n1; i++) {
            total1[i] = new ArrayList<>();
        }
        for (long i = 0; i < 1L << n1; i++) {
            int count = 0;
            long total = 0;
            for (int j = 0; j < n1; j++) {
                if ((i & (1L << j)) != 0) {
                    total += a1[j];
                    count++;
                }
            }
            total1[count].add(total);
        }

        ArrayList<Long>[] total2 = new ArrayList[n2 + 1];
        for (int i = 0; i <= n2; i++) {
            total2[i] = new ArrayList<>();
        }

        for (long i = 0; i < 1L << n2; i++) {
            int count = 0;
            long total = 0;
            for (int j = 0; j < n2; j++) {
                if ((i & (1L << j)) != 0) {
                    total += a2[j];
                    count++;
                }
            }
            total2[count].add(total);
        }

        for (int i = 0; i < n2; i++) {
            Collections.sort(total2[i]);
        }

        long ans = 0;
        for (int k1 = 0; k1 <= n1; k1++) {
            int k2 = k - k1;
            if (n2 < k2 || k2 < 0) {
                continue;
            }
            for (final Long t1 : total1[k1]) {
                long threshold = p - t1; // これ以下ならOK
                if (threshold < 0) {
                    continue;
                }
                int index = binarySearch(total2[k2].size(), -1, i -> total2[k2].get(i) <= threshold);
                ans += (index+1);
            }
        }

        out.println(ans);
        out.flush();
    }

    private static int binarySearch(int ng, int ok, Predicate<Integer> condition) {
        while (Math.abs(ok - ng) > 1) {
            int mid = (ok + ng) / 2;
            if (condition.test(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}