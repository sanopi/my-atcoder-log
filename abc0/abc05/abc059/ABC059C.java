import java.io.PrintWriter;
import java.util.Scanner;

public class ABC059C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long ans1 = 0;
        long currentSum1 = 0;
        for (int i = 0; i < n; i++) {
            currentSum1 += a[i];
            if (i%2==0) {
                if (currentSum1<=0) {
                    ans1 += Math.abs(currentSum1)+1;
                    currentSum1=1;
                }
            } else {
                if (currentSum1>=0) {
                    ans1 += Math.abs(currentSum1)+1;
                    currentSum1=-1;
                }
            }
        }

        long ans2 = 0;
        long currentSum2 = 0;
        for (int i = 0; i < n; i++) {
            currentSum2 += a[i];
            if (i%2==0) {
                if (currentSum2>=0) {
                    ans2 += Math.abs(currentSum2)+1;
                    currentSum2=-1;
                }
            } else {
                if (currentSum2<=0) {
                    ans2 += Math.abs(currentSum2)+1;
                    currentSum2=1;
                }
            }
        }
        out.println(Math.min(ans1, ans2));
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