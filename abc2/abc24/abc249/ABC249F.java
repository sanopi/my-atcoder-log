import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC249F {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        Operation[] operations = new Operation[n+1];
        operations[0] = new Operation(1, 0);
        for (int i = 1; i <= n; i++) {
            operations[i] = new Operation(nextInt(), nextInt());
        }
        long max = getMax(k, operations);
        out.println(max);
        out.flush();
    }

    private static long getMax(int k, Operation[] operations) {
        long max = Long.MIN_VALUE;
        int n = operations.length;
        PriorityQueue<Integer> delCan = new PriorityQueue<>(Comparator.reverseOrder());
        long deleteSum = 0;
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            Operation oi = operations[i];
            if (oi.t == 1) {
                max = Math.max(max, sum + oi.y - deleteSum);
                if (k==0) return max;
                if (k > 0) k--;
            } else {
                sum += oi.y;
                if (oi.y<0) {
                    delCan.add(oi.y);
                    deleteSum+=oi.y;
                }
            }
            if (delCan.size()>k) {
                deleteSum -= delCan.poll();
            }
        }
        return max;
    }

    private static class Operation {
        int t;
        int y;
        public Operation(int t, int y) {
            this.t = t;
            this.y = y;
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