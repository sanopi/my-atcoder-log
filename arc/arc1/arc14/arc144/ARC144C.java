import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ARC144C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] ans = new int[n];

        if (2*k > n) {
            System.out.println(-1);
            return;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i+1);
        }

        int t = n - k;

        // 最大値を埋める
        for (int i = t - 1; i >= t-k; i--) {
            ans[i] = i+1+k;
            treeSet.remove(ans[i]);
        }

        // 頭を埋める
        for (int i = 0; i < k; i++) {
            if (ans[i]>0) continue;
            ans[i] = i+1+k;
            treeSet.remove(ans[i]);
        }

        for (int i = 0; i < n; i++) {
            if (ans[i]>0) continue;
            int first = treeSet.first();
            if (first <= i-k+1 || i+k+1 <= first) {
                ans[i] = first;
            } else {
                ans[i] = treeSet.ceiling(i+k+1);
            }
            treeSet.remove(ans[i]);
        }

        for (int an : ans) {
            out.print(an + " ");
        }
        out.println();
        out.flush();
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