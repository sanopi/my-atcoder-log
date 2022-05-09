import java.io.PrintWriter;
import java.util.Scanner;

public class ABC250C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] nums = new int[n];
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
            positions[i] = i;
        }
        while (q-->0) {
            int x = nextInt()-1;
            int current = positions[x];
            int next = current + (current==n-1 ? -1 : +1);
            int y = nums[next];


            nums[next] = x;
            nums[current] = y;
            positions[x] = next;
            positions[y] = current;
        }
        for (int num : nums) {
            out.print((num+1) + " ");
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