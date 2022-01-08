import java.io.PrintWriter;
import java.util.Scanner;

public class Q30_KFactors_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] nums = new int[n];
        for (int num = 2; num <= n; num++) {
            int i = num - 1;
            if (nums[i] == 0) {
                for (int j = i; j < n; j+=num) {
                    nums[j] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= k) {
                count++;
            }
        }
        out.println(count);
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