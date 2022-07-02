import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC258E {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int x = nextInt();
        int[] w = nextIntArray(n);
        long[] wSum = new long[n+1];
        for (int i = 0; i < n; i++) {
            wSum[i+1] = wSum[i] + w[i];
        }

        List<Pair> cycle = new ArrayList<>();

        boolean[] done = new boolean[n];
        done[0] = true;
        int index = 0;
        while (true) {
            int found = lowerBound(wSum, x + wSum[index])-1;
            if (found < n) {
                cycle.add(new Pair(index, found-index+1));
                index = (found+1)%n;
                if (done[index]) break;
                done[index] = true;
            } else {
                long rest = x - (wSum[n] - wSum[index]);
                long count = rest / wSum[n];
                rest = rest % wSum[n];
                int found2 = lowerBound(wSum, rest)-1;

                cycle.add(new Pair(index, (n-index) + count*n + (found2+1)));
                index = (found2+1)%n;
                if (done[index]) break;
                done[index] = true;
            }
        }

        int start = -1;
        int size = cycle.size();
        for (int i = 0; i < size; i++) {
            if (cycle.get(i).startI == index) {
                start = i;
            }
        }

        long cycleCount = size-start;

//        System.out.println("wSum: " + Arrays.toString(wSum));
//        System.out.println("cycle: " + cycle);
//        System.out.println("index: " + index);
//        System.out.println("cycleCount: " + cycleCount);

        while (q --> 0) {
            long k = nextLong()-1;
            if (k<=size) {
                out.println(cycle.get((int) k).count);
                continue;
            }
            k -= size;
            k %= cycleCount;
            out.println(cycle.get((int) k + start).count);
        }
        out.flush();
    }

    private static class Pair {
        int startI;
        long count;
        public Pair(int startI, long count) {
            this.startI = startI;
            this.count = count;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "startI=" + startI +
                ", count=" + count +
                '}';
        }
    }

    private static int lowerBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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