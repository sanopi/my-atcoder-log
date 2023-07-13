import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC309C {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        Med[] meds = new Med[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long a = nextLong();
            long b = nextLong();
            meds[i] = new Med(a, b);
            sum+=b;
        }
        Arrays.sort(meds, Comparator.comparing(med -> med.a));
        if (sum <= k) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            Med mi = meds[i];
            sum -= mi.b;
            if (sum <= k) {
                System.out.println(mi.a+1);
                return;
            }
        }

        System.out.println(meds[n-1].a+1);
    }

    private static class Med {
        long a;
        long b;
        public Med(long a, long b) {
            this.a = a;
            this.b = b;
        }
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