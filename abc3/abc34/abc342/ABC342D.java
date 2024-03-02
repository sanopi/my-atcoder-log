import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC342D {

    private static void solve() {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Map<Integer, Integer>[] aa = new Map[n];
        Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            if (ai == 0) {
                zeroCount++;
                continue;
            }
            Map<Integer, Integer> primes = new HashMap<>();
            for (int j = 2; j*j <= ai; j++) {
                while (ai % j == 0) {
                    int value = primes.getOrDefault(j, 0);
                    value = (value+1)%2;
                    primes.put(j, value);
                    primes.remove(j, 0);
                    ai /= j;
                }
            }
            if (ai != 1) {
                primes.merge(ai, 1, Math::addExact);
            }
            map.merge(primes, 1, Math::addExact);
            aa[i] = primes;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zeroCount--;
                ans += n-i-1;
                continue;
            }
            ans+=zeroCount;
            Map<Integer, Integer> aiMap = aa[i];
            map.merge(aiMap, -1, Math::addExact);
            ans += map.getOrDefault(aiMap, 0);
        }

        out.println(ans);
        out.flush();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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