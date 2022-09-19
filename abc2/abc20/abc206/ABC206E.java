import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC206E {

    public static void main(String[] args) {
        int l = nextInt();
        int r = nextInt();

        long[] arr = new long[r+1];
        long ans = 0;
        for (int g = r; g >= 2; g--) {
            long tmp = r/g - (l-1)/g;
            arr[g] += tmp*tmp;

            for (int j = 2*g; j <= r; j+=g) {
                arr[g]-=arr[j];
            }
            ans += arr[g];
        }

        for (int i = Math.max(2, l); i <= r; i++) {
            ans -= ((long)r/i)*2-1;
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