import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Q06 {

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        String s = next();
        TreeSet<Integer>[] treeSets = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            treeSets[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            treeSets[s.charAt(i)-'a'].add(i);
        }
        StringBuilder ans = new StringBuilder();
        int point = -1;
        while (k > 0) {
            for (int i = 0; i < 26; i++) {
                Integer higher = treeSets[i].higher(point);
                if (higher != null && n-higher >= k) {
                    ans.append((char) (i+'a'));
                    point = higher;
                    k--;
                    break;
                }
            }
        }
        out.println(ans);
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