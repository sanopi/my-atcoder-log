import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC329C {

    private static void solve() {
        int n = nextInt();
        String s = next();

        int r = 0;
        Map<Character, Integer> counts = new HashMap<>();
        Set<Integer>[] ans = new Set[26];
        for (int i = 0; i < 26; i++) {
            ans[i] = new HashSet<>();
        }

        for (int l = 0; l < n; l++) {
            while (r < n && (counts.size()==0 || counts.get(s.charAt(r)) != null)) {
                counts.merge(s.charAt(r), 1, Math::addExact);
                counts.forEach((c, count) -> {
                    ans[c-'a'].add(count);
                });
                r++;
            }

            counts.merge(s.charAt(l), -1, Math::addExact);
            counts.remove(s.charAt(l), 0);
        }
        long ansNum = 0;
        for (int i = 0; i < 26; i++) {
            ansNum += ans[i].size();
        }

        out.println(ansNum);
        out.flush();
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