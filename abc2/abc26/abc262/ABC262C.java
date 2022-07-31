import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC262C {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(i, nextInt()-1);
        }

        int[] count = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i].num == i) {
                count[i]++;
            }
            count[i] += count[i+1];
        }

        List<Integer>[] ordered = new List[n];
        for (int i = 0; i < n; i++) {
            ordered[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            Pair ai = a[i];
            ordered[ai.num].add(ai.i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            Pair ai = a[i];
            if (ai.num == i) {
                ans += count[i+1];
            } else if (ai.num > i) {
                List<Integer> integers = ordered[i];
                for (Integer integer : integers) {
                    if (integer > i && ai.num == integer) ans++;
                }
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int i;
        int num;
        public Pair(int i, int num) {
            this.i = i;
            this.num = num;
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