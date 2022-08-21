import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC265D {

    public static void main(String[] args) {
        int n = nextInt();
        long P = nextLong();
        long Q = nextLong();
        long R = nextLong();
        long[] a = nextLongArray(n);
        long[] sums = new long[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + a[i];
        }

        int r = 0;
        int l = 0;
        long sum = 0;
        while (sums[n]-sums[l] >= P+Q+R) {
            while (r<n && sum < P) {
                sum+=a[r];
                r++;
            }
            if (sum == P) {
                int found = Arrays.binarySearch(sums, sums[r] + Q);
                if (found>0) {
                    int found2 = Arrays.binarySearch(sums, sums[found] + R);
                    if (found2 > 0) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
            if (sum >= P) {
                sum-=a[l];
                l++;
            }
        }

        System.out.println("No");
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