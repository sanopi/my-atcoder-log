import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC278C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        Map<Integer, Set<Integer>> follow = new HashMap<>();
        while (q-- > 0) {
            int t = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (t == 1) {
                Set<Integer> set = follow.getOrDefault(a, new HashSet<>());
                set.add(b);
                follow.put(a, set);
            } else if (t == 2) {
                Set<Integer> set = follow.getOrDefault(a, new HashSet<>());
                set.remove(b);
                follow.put(a, set);
            } else {
                Set<Integer> aSet = follow.getOrDefault(a, new HashSet<>());
                Set<Integer> bSet = follow.getOrDefault(b, new HashSet<>());
                if (aSet.contains(b) && bSet.contains(a)) {
                    out.println("Yes");
                } else {
                    out.println("No");
                }
            }
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