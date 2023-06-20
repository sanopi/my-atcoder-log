import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ABC306F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = nextIntArray(m);
            Arrays.sort(a[i]);
        }

        int[] tmpA = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpA[i*m+j] = a[i][j];
            }
        }
        int[] compressedTmpA = compress(tmpA);
        int[][] compressedA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                compressedA[i][j] = compressedTmpA[i*m+j];
            }
        }

        BIT bit = new BIT(n * m);
        for (int i = 0; i < n * m; i++) {
            bit.add(i, 1);
        }


        long ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                bit.add(compressedA[i][j], -1);
            }
            for (int j = 0; j < m; j++) {
                int aij = compressedA[i][j];
                ans += (long)(n-i-1)*(j+1);
                ans += bit.sum(aij);
            }
        }

        System.out.println(ans);
    }

    private static int[] compress(int[] array) {
        TreeSet<Integer> sortedElements = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element: sortedElements) map.put(element, count++);
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) res[i] = map.get(array[i]);
        return res;
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

    private static class BIT {
        int n;
        long[] tree;
        BIT(int n) {
            this.n=n;
            tree = new long[n+1];
        }
        private void add(int i, long v) {
            for (int index = i+1; index <= n; index += (index & -index)) {
                tree[index]+=v;
            }
        }
        private long sum(int i) {
            if (i<0) return 0;
            long res = 0;
            for (int index = i+1; index > 0; index -= (index & -index)) {
                res += tree[index];
            }
            return res;
        }

        private static long calcInvCount(int[] array) {
            int len = array.length;
            int max = Arrays.stream(array).max().getAsInt();
            BIT bit = new BIT(max);
            long count = 0;
            for (int i = 0; i < len; i++) {
                bit.add(array[i], 1);
                count += (i+1-bit.sum(array[i]));
            }
            return count;
        }
    }
}