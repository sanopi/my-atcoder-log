import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC260E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        List<Integer>[] rev = new List[m+1];
        for (int i = 0; i < m+1; i++) {
            rev[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            Pair pi = pairs[i];
            rev[pi.a].add(i);
            rev[pi.b].add(i);
        }

        int[] counts = new int[n];
        int count = 0;

        long[] ans = new long[m+2];
        int r = 1;
        for (Integer integer : rev[r]) {
            if (counts[integer] == 0) count++;
            counts[integer]++;
        }
        r++;
        int l = 1;

        while (l<=m) {
            while (count < n && r <= m) {
                List<Integer> list = rev[r];
                for (Integer integer : list) {
                    if (counts[integer] == 0) count++;
                    counts[integer]++;
                }
                r++;
            }

            if (count == n) {

                int minLen = r - l;
                int maxLen = m-l+1;
                ans[minLen]++;
                ans[maxLen+1]--;
            }

            for (Integer integer : rev[l]) {
                counts[integer]--;
                if (counts[integer] == 0) count--;
            }
            l++;

        }

        for (int i = 1; i < m + 2; i++) {
            ans[i]+= ans[i-1];
        }
        for (int i = 1; i <= m; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
        out.flush();
    }

    private static final class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
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