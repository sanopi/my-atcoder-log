import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC281E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);
        long ans = 0;
        TreeMap<Integer, Integer> upper = new TreeMap<>();
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        int[] f = Arrays.copyOf(a, m);
        Arrays.sort(f);
        for (int i = 0; i < m; i++) {
            if (i < k) {
                increment(lower, f[i]);
                ans += f[i];
            } else {
                increment(upper, f[i]);
            }
        }
        out.print(ans);

        for (int i = m; i < n; i++) {
            int remove = a[i-m];
            int add = a[i];
            // 削除
            if (upper.size()==0) {
                decrement(lower, remove);
                ans -= remove;
            } else {
                Integer uf = upper.firstKey();
                if (uf <= remove) {
                    decrement(upper, remove);
                } else {
                    decrement(upper, uf);
                    increment(lower, uf);
                    decrement(lower, remove);
                    ans -= remove;
                    ans += uf;
                }
            }

            // 追加
            if (lower.size() == 0) {
                increment(lower, add);
                ans += add;
            } else {
                Integer ll = lower.lastKey();
                if (ll <= add) {
                    increment(upper, add);
                } else {
                    increment(upper, ll);
                    decrement(lower, ll);
                    increment(lower, add);
                    ans -= ll;
                    ans += add;
                }
            }

            out.print(" " + ans);
        }
        out.println();
        out.flush();
    }

    private static void increment(Map<Integer, Integer> map, Integer key) {
         map.put(key, map.getOrDefault(key, 0)+1);
    }

    private static void decrement(Map<Integer, Integer> map, Integer key) {
        if (map.get(key) == null) return;
        map.put(key, map.getOrDefault(key, 0)-1);
        map.remove(key, 0);
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