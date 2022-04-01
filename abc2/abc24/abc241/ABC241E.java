import java.io.PrintWriter;
import java.util.Scanner;

public class ABC241E {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        int[] a = nextIntArray(n);
        Pair[] counts = new Pair[n];
        // 0（mod N）個キャンディーがある状態が最初にあわられるのは、0回の操作後で実際に0個乗っている
        counts[0] = new Pair(0, 0);

        long candies = a[0];
        int i = 1;
        while (i<k && counts[(int)(candies%n)] == null) {
            counts[(int)(candies%n)] = new Pair(i, candies);
            int ap = a[(int)(candies%n)];
            candies += ap;
            i++;
        }
        k-=i;
        if (k==0) {
            System.out.println(candies);
            return;
        }

        Pair prev = counts[(int) (candies % n)];
        candies += k/(i-prev.i) * (candies - prev.candyCount);
        k = k%(i-prev.i);

        while (k --> 0) {
            candies += a[(int)(candies%n)];
        }
        out.println(candies);
        out.flush();
    }

    private static class Pair {
        int i;
        long candyCount;
        public Pair(int i, long candyCount) {
            this.i = i;
            this.candyCount = candyCount;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "i=" + i +
                ", candyCount=" + candyCount +
                '}';
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