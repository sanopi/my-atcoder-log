import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC329E {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        String s = next();
        String t = next();
        boolean[] ok = new boolean[n];
        List<Integer> starts = new ArrayList<>();
        int prev = 0;
        int tmp;
        while ((tmp = s.indexOf(t, prev)) >= 0) {
            starts.add(tmp);
            prev = tmp+1;
            for (int i = 0; i < m; i++) {
                ok[tmp+i] = true;
            }
        }

        if (starts.size() == 0) {
            System.out.println("No");
            return;
        }

        for (int start : starts) {
            // 左に見る

            for (int i = start-1; i >= 0; i--) {
                if (ok[i]) break;

                for (int j = Math.max(0, i-m+1); j <= i; j++) {
                    String target = s.substring(j, i+1);
                    if (t.startsWith(target)) {
                        for (int k = j; k <= i; k++) {
                            ok[k] = true;
                        }
                        i = j;
                        break;
                    } else if (t.contains(target)) {
                        if (j>0 && ok[j-1]) {
                            for (int k = j; k <= i; k++) {
                                ok[k] = true;
                            }
                            i = j;
                            break;
                        }
                    }
                }
                if (!ok[i]) break;
            }
            // 右に見る
            for (int i = start+m; i < n; i++) {
                if (ok[i]) break;

                for (int j = Math.min(n-1, i+m-1); j >= i; j--) {
                    String target = s.substring(i, j+1);
                    if (t.endsWith(target)) {
                        for (int k = i; k <= j; k++) {
                            ok[k] = true;
                        }
                        i = j;
                        break;
                    } else if (t.contains(target)) {
                        if (j<n-1 && ok[j+1]) {
                            for (int k = i; k <= j; k++) {
                                ok[k] = true;
                            }
                            i = j;
                            break;
                        }
                    }
                }
                if (!ok[i]) break;
            }
        }
        boolean yes = true;
        for (boolean b : ok) {
            yes &= b;
        }
        out.println(yes ? "Yes" : "No");
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