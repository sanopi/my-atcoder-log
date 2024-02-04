import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC339F {

    private static void solve() {
        long ans;
//        ans = solve1();
        ans = solve2();

        out.println(ans);
        out.flush();
    }
    private static long solve2() {int n = nextInt();
        BigDecimal[] a = new BigDecimal[n];

        for (int i = 0; i < n; i++) {
            BigDecimal ai = new BigDecimal(next());
            a[i] = ai;
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            primes.add(((int) (1000000000 + Math.random() * 100000000)));
        }
        List<BigDecimal> primes2 = primes.stream().map(BigDecimal::valueOf).toList();
        int m = primes.size();
        Map<Long, Long>[] counts = new Map[m];
        for (int i = 0; i < m; i++) {
            counts[i] = new HashMap<>();
        }
        long[][] aa = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                aa[i][j] = a[j].remainder(primes2.get(i)).longValue();
                counts[i].merge(aa[i][j], 1L, Math::addExact);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Long> set = new HashSet<>();
                for (int k = 0; k < m; k++) {
                    set.add(counts[k].getOrDefault(aa[k][i] * aa[k][j] % primes.get(k), 0L));
                }
                if (set.size() == 1) {
                    ans += set.stream().findAny().get();
                }
            }
        }
        return ans;
    }
    private static long solve1() {
        int n = nextInt();
        BigDecimal[] a = new BigDecimal[n];
        Map<BigDecimal, Long> counts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            BigDecimal ai = new BigDecimal(next());
            a[i] = ai;
            counts.merge(ai, 1L, Math::addExact);
        }
        Arrays.sort(a, Comparator.naturalOrder());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            BigDecimal ai = a[i];
            for (int j = 0; j < n; j++) {
                BigDecimal aj = a[j];
                BigDecimal multiply = ai.multiply(aj);
                if (multiply.compareTo(a[n-1]) > 0) break;
                ans += counts.getOrDefault(multiply, 0L);
            }
        }
        return ans;
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