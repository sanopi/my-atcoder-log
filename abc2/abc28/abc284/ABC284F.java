import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC284F {
    private static final long B = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        String t = next();
//        solve1(n, t);
        solve2(n, t);
    }
    private static void solve2(int n, String t) {
        char[] t1 = t.substring(0, n).toCharArray();
        char[] t2 = new StringBuilder().append(t, n, 2* n).reverse().toString().toCharArray();
        RollingHash hash1 = new RollingHash(convert(t1));
        RollingHash hash2 = new RollingHash(convert(t2));

        int count = 0;
        while (!hash1.equals(hash2) && count<n) {
            hash1.set(n-count-1, t.charAt(2*n-count-1));
            hash2.roll(t.charAt(n-count-1));
            count++;
        }

        if (count == n) {
            System.out.println(-1);
        } else {
            StringBuilder ans = new StringBuilder(n);
            for (long l : hash1.getCurrent()) {
                ans.append((char)(int) l);
            }
            System.out.println(ans);
            System.out.println(n-count);
        }
    }

    private static long[] convert(char[] chars) {
        long[] res = new long[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = chars[i];
        }
        return res;
    }

    private static void solve1(int n, String t) {
        char[] t1 = t.substring(0, n).toCharArray();
        char[] t2 = new StringBuilder().append(t, n, 2* n).reverse().toString().toCharArray();
        if (Arrays.equals(t1, t2)) {
            System.out.println(new String(t1));
            System.out.println(n);
            return;
        }

        long[] bb = new long[n +1];
        bb[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            bb[i] = bb[i-1]*B;
        }

        long t1h = 0;
        for (int i = 0; i < n; i++) {
            t1h += t1[i]*bb[n -i-1];
        }
        long t2h = 0;
        for (int i = 0; i < n; i++) {
            t2h += t2[i]*bb[n -i-1];
        }

        // i文字ずらす
        for (int i = 1; i <= n; i++) {
            // Sの候補は、n-i文字目 * bb[i-1] がひかれる
            // そこに、2*n-i文字目 * bb[i-1] が足される
            t1h -= t.charAt(n -i) * bb[i-1];
            t1h += t.charAt(2* n -i) * bb[i-1];

            // rSの候補はスライドするので、全体をB倍して、
            // 2*n-i文字目 * bb[n] を引いて、
            // n-i文字目 を足す
            t2h *= B;
            t2h -= t.charAt(2* n -i) * bb[n];
            t2h += t.charAt(n -i);

            if (t1h == t2h) {
                String candidate = new StringBuilder().append(t, 0, n - i).append(t, 2 * n - i, 2 * n).toString();
                if (
                    candidate
                        .equals(new StringBuilder().append(t, n -i, 2* n -i).reverse().toString())
                    ) {
                    System.out.println(candidate);
                    System.out.println(n -i);
                    return;
                }
            }
        }
        System.out.println(-1);
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

    private static class RollingHash {
        private static final long BASE = 1000000007;

        int n;
        long value;
        long[] baseExp;

        int rollCount = 0;
        List<Long> memo;

        RollingHash(long[] arr) {
            n = arr.length;
            baseExp = initExp(n);
            value = initValue(arr);
            memo = new ArrayList<>(n);
            for (long l : arr) {
                memo.add(l);
            }
        }

        private long[] initExp(int n) {
            long[] exps = new long[n + 1];
            exps[0] = 1;
            for (int i = 1; i <= n; i++) {
                exps[i] = exps[i-1]*BASE;
            }
            return exps;
        }

        private long initValue(long[] arr) {
            long v = 0;
            for (int i = 0; i < n; i++) {
                v += arr[i] * baseExp[n-i-1];
            }
            return v;
        }

        private long roll(long push) {
            long remove = memo.get(rollCount);
            memo.add(push);

            value *= BASE;
            value -= remove * baseExp[n];
            value += push;

            rollCount++;
            return remove;
        }

        private long set(int i, long v) {
            long remove = memo.get(rollCount+i);
            memo.set(rollCount+i, v);

            value -= remove * baseExp[n-i-1];
            value += v * baseExp[n-i-1];

            return remove;
        }

        private List<Long> getCurrent() {
            List<Long> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                res.add(memo.get(rollCount+i));
            }
            return res;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RollingHash that = (RollingHash) o;
            if (this.value != that.value) return false;
            return this.getCurrent().equals(that.getCurrent());
        }
    }

}