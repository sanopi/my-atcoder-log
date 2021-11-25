import java.io.PrintWriter;
import java.util.Scanner;

public class Q46_ILove46_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        int[] c = nextIntArray(n);

        int[] aa = new int[46];
        int[] bb = new int[46];
        int[] cc = new int[46];
        for (int i = 0; i < n; i++) {
            aa[a[i]%46] += 1;
        }
        for (int i = 0; i < n; i++) {
            bb[b[i]%46] += 1;
        }
        for (int i = 0; i < n; i++) {
            cc[c[i]%46] += 1;
        }

        long ans = 0;
        for (int i = 0; i < 46; i++) {
            for (int j = 0; j < 46; j++) {
                for (int k = 0; k < 46; k++) {
                    if ((i + j + k) % 46 == 0) {
                        ans = ans + ((long) aa[i] *bb[j]*cc[k]);
                    }
                }
            }
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}