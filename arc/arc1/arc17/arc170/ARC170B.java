import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ARC170B {

    private static void solve() {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
        }
        long[][] counts = new long[10][10];
        long ans = 0;
        int r = 0;
        Map<Integer, Integer> appears = new HashMap<>();
        for (int l = 0; l < n; l++) {
            // rを足していく
            boolean ok = false;
            while (r < n && !ok) {
                int ar = a[r];
                for (int i = -4; i <= 4; i++) {
                    int f = ar+i*2;
                    int s = ar+i;
                    if (f<0 || f>9 || s<0 || s>9) continue;
                    if (counts[f][s] > 0) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    for (Map.Entry<Integer, Integer> entry : appears.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        counts[key][ar]+=value;
                    }
                    appears.merge(ar, 1, Math::addExact);

                    r++;
                }
            }
            ans += (n-r);

            // 最後に取り除く
            int al = a[l];
            appears.merge(al, -1, Math::addExact);
            for (Map.Entry<Integer, Integer> entry : appears.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                counts[al][key]-=value;
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