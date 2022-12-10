import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC280D {

    public static void main(String[] args) {
        long k = nextLong();
        Map<Long, Integer> primeCount = new HashMap<>();
        for (long i = 2; i*i <= k; i++) {
            while (k%i==0) {
                primeCount.put(i, primeCount.getOrDefault(i, 0)+1);
                k/=i;
            }
        }
        if (k!=1) {
            primeCount.put(k, primeCount.getOrDefault(k, 0)+1);
        }
        long ans = 2;
        for (Map.Entry<Long, Integer> entry : primeCount.entrySet()) {
            long prime = entry.getKey();
            long count = entry.getValue();
            long i = 0;
            while (count > 0) {
                i += prime;
                long j = i;
                while (j%prime==0) {
                    count--;
                    j/=prime;
                }
            }
            ans = Math.max(ans, i);
        }
        out.println(ans);
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