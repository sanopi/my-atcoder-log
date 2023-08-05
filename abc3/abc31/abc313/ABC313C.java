import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC313C {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        Arrays.sort(a);
        long sum = Arrays.stream(a).sum();
        long min = sum/n;
        long max = (sum+n-1)/n;

        int minCount = -1;
        for (int i = 0; i <= n; i++) {
            if (min*i+max*(n-i) == sum) {
                minCount = i;
                break;
            }
        }

        long ans = 0;
        for (int i = 0; i < minCount; i++) {
            ans += Math.abs(min - a[i]);
        }
        for (int i = minCount; i < n; i++) {
            ans += Math.abs(max - a[i]);
        }
        out.println(ans/2);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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