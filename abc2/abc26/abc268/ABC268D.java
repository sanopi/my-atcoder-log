import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC268D {

    private static int n;
    private static String[] s;
    private static int len = 0;
    private static Set<String> t;
    private static String ans = null;

    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
            len += s[i].length();
        }
        t = new HashSet<>();
        for (int i = 0; i < m; i++) {
            t.add(next());
        }

        if (16 < len) {
            System.out.println(-1);
            return;
        }
        all(new String[n], new HashSet<>());

        out.println(ans != null ? ans : -1);
        out.flush();
    }

    private static void all(String[] strings, Set<Integer> done) {
        if (done.size() == n) {
            String[] mid = new String[n];
            mid[0] = strings[0];
            buildString(strings, mid, 1, 16-len);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (done.contains(i)) continue;
            strings[done.size()] = s[i];
            done.add(i);
            all(strings, done);
            done.remove(i);
            if (ans != null) {
                return;
            }
        }
    }

    private static void buildString(String[] strings, String[] mid, int index, int rest_) {
        if (index == n) {
            StringBuilder sb = new StringBuilder();
            for (String s1 : mid) {
                sb.append(s1);
            }
            String candidate = sb.toString();
            if (3 <= candidate.length() && candidate.length() <= 16 && !t.contains(candidate)) {
                ans = candidate;
            }
            return;
        }
        String first = mid[index-1];
        for (int i = 0; i < rest_; i++) {
            mid[index-1]+="_";
            mid[index] = strings[index];
            buildString(strings, mid, index+1, rest_ -i -1);
            if (ans != null) {
                return;
            }
        }
        mid[index-1] = first;
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