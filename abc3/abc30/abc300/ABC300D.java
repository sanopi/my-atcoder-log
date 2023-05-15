import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC300D {

    public static void main(String[] args) {
        long n = nextLong();
        int MAX = 1000000;
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < MAX; i++) {
            if (!isPrime[i]) continue;
            for (int j = i+i; j < MAX; j+=i) {
                isPrime[j] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int ans = 0;
        int size = primes.size();
        for (int ai = 0; ai < size; ai++) {
            long a = primes.get(ai);
            long candidate = a*a;
            if (candidate > n) break;
            for (int bi = ai+1; bi < size; bi++) {
                long b = primes.get(bi);
                long candidate1 = candidate * b;
                if (candidate1>n) break;
                for (int ci = bi+1; ci < size; ci++) {
                    long c = primes.get(ci);
                    long candidate2 = candidate1*c;
                    if (candidate2>n) break;
                    candidate2 *= c;
                    if (candidate2>n) break;
                    ans++;
                }
            }
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