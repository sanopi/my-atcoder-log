import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Tenka1_2018_BeginnerC {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);

        long ans = 0;
        if (n%2==0) {
            for (int i = 0; i <= n/2-2; i++) {
                ans-=a[i]* 2L;
            }
            ans-=a[n/2-1];
            ans+=a[n/2];
            for (int i = n/2+1; i < n; i++) {
                ans+=a[i]* 2L;
            }
        } else {
            long ans1 = 0;
            for (int i = 0; i <= n/2-1; i++) {
                ans1-=a[i]* 2L;
            }
            ans1+=a[n/2];
            ans1+=a[n/2+1];
            for (int i = n/2+2; i < n; i++) {
                ans1+=a[i]* 2L;
            }
            long ans2 = 0;
            for (int i = 0; i <= n/2-2; i++) {
                ans2-=a[i]* 2L;
            }
            ans2-=a[n/2-1];
            ans2-=a[n/2];
            for (int i = n/2+1; i < n; i++) {
                ans2+=a[i]* 2L;
            }
            ans = Math.max(ans1, ans2);
        }
        out.println(ans);

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