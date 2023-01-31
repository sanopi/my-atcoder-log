import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC287E {

    public static void main(String[] args) {
        int n = nextInt();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            String si = next();
            s[i] = si;
            treeMap.merge(si, 1, Math::addExact);
        }
        for (int i = 0; i < n; i++) {
            String si = s[i];
            Integer count = treeMap.get(si);
            if (count >= 2) {
                out.println(si.length());
                continue;
            }

            String lower = treeMap.lowerKey(si);
            int lc = 0;
            if (lower != null) {
                for (int j = 0; j < Math.min(si.length(), lower.length()); j++) {
                    if (si.charAt(j) == lower.charAt(j)) {
                        lc++;
                    } else {
                        break;
                    }
                }
            }

            String higher = treeMap.higherKey(si);
            int hc = 0;
            if (higher != null) {
                for (int j = 0; j < Math.min(si.length(), higher.length()); j++) {
                    if (si.charAt(j) == higher.charAt(j)) {
                        hc++;
                    } else {
                        break;
                    }
                }
            }
            out.println(Math.max(lc, hc));
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