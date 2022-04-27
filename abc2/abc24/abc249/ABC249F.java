import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> delCan = new TreeMap<>();
        int delCanCount = 0;
        long deleteSum = 0;
        long sum = 0;
        // 逆順で見る
        for (int i = n - 1; i >= 0; i--) {
            Operation oi = operations[i];
            if (oi.t == 1) {
                long tmpSum = sum + oi.y;
                max = Math.max(max, tmpSum-deleteSum);
                if (k==0) return max;
                if (k > 0) k--;
            } else {
                sum += oi.y;
                if (oi.y<0) {
                    delCan.put(oi.y, delCan.getOrDefault(oi.y, 0)+1);
                    deleteSum+=oi.y;
                    delCanCount++;
                }
            }
            if (delCanCount>k) {
                deleteSum -= deleteDelete(delCan);
                delCanCount--;
            }
        }
        return max;
    }

    private static long deleteDelete(TreeMap<Integer, Integer> delCan) {
        Map.Entry<Integer, Integer> entry = delCan.pollLastEntry();
        if (entry.getValue()-1 >0) {
            delCan.put(entry.getKey(), entry.getValue()-1);
        }
        return entry.getKey();
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