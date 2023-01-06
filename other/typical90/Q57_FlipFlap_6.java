import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Q57_FlipFlap_6 {

    private static final int MOD = 998244353;
    private static char[] expect;
    private static int m;
    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();
        BitSet[] switches = new BitSet[n];
        for (int i = 0; i < n; i++) {
            BitSet bitSet = new BitSet(m);
            switches[i] = bitSet;
            int t = nextInt();
            for (int j = 0; j < t; j++) {
                int r = nextInt()-1;
                bitSet.set(r);
            }
        }
        BitSet expected = new BitSet(m);
        for (int i = 0; i < m; i++) {
            int s = nextInt();
            if (s == 1) {
                expected.set(i);
            }
        }

        BitSet[] lowestBit = new BitSet[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                BitSet bitSet = switches[j];
                if (bitSet.get(i) && bitSet.previousSetBit(i-1) == -1) {
                    lowestBit[i] = bitSet;
                    for (int k = 0; k < n; k++) {
                        if (j==k) continue;
                        BitSet target = switches[k];
                        if (target.get(i) && target.previousSetBit(i-1) == -1) {
                            target.xor(bitSet);
                        }
                    }
                    break;
                }
            }
        }

        BitSet result = new BitSet(m);
        for (int i = 0; i < m; i++) {
            if (expected.get(i) == result.get(i)) continue;
            if (lowestBit[i] == null) {
                System.out.println(0);
                return;
            }
            result.xor(lowestBit[i]);
        }

        int count = 0;
        for (BitSet bitSet : switches) {
            if (bitSet.cardinality() == 0) {
                count ++;
            }
        }
        out.println(modPow(2, count, MOD));
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

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

}