import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ARC148C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] p = new int[n];
        p[0] = -1;
        for (int i = 1; i < n; i++) {
            p[i] = nextInt()-1;
        }
        int[] nextCounts = new int[n];
        for (int i = 1; i < n; i++) {
            nextCounts[p[i]]++;
        }

        while (q-- > 0) {
            int m = nextInt();
            int[] v = new int[m];
            Set<Integer> omote = new HashSet<>();
            for (int i = 0; i < m; i++) {
                v[i] = nextInt()-1;
                omote.add(v[i]);
            }
            int componentCount = 0;
            for (int i = 0; i < m; i++) {
                int vi = v[i];
                componentCount+=nextCounts[vi];
                if (omote.contains(p[vi])) componentCount--;
                else componentCount++;
            }
            out.println(componentCount);
        }
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