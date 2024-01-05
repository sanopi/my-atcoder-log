import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC326F {

    private static final Map<Character, Map<Character, Character>> converter = Map.of(
        'U', Map.of('R', 'R', 'L', 'L'),
        'D', Map.of('R', 'L', 'L', 'R'),
        'R', Map.of('U', 'L', 'D', 'R'),
        'L', Map.of('U', 'R', 'D', 'L')
    );

    private static void solve() {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        int[] a = nextIntArray(n);
        int yN = (n + 1) / 2;
        int[] aY = new int[yN];
        int xN = n / 2;
        int[] aX = new int[xN];
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                aY[i/2] = a[i];
            } else {
                aX[i/2] = a[i];
            }
        }
        List<Integer> lY = solve2(y, aY);
        List<Integer> lX = solve2(x, aX);
        if (lY.isEmpty() || lX.isEmpty()) {
            System.out.println("No");
            return;
        }
        char[] s = new char[n];
        for (int i = 0; i < yN; i++) {
            int c = lY.get(i);
            s[i*2] = c==1?'U':'D';
        }
        for (int i = 0; i < xN; i++) {
            int c = lX.get(i);
            s[i*2+1] = c==1?'R':'L';
        }
        StringBuilder ans = new StringBuilder();
        char prev = 'R';
        for (int i = 0; i < n; i++) {
            char si = s[i];
            ans.append(converter.get(prev).get(si));
            prev = si;
        }
        out.println("Yes");
        out.println(ans);
        out.flush();
    }

    private static List<Integer> solve2(int goal, int[] a) {
        int n = a.length;
        int n1 = n / 2;
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = a[i];
        }
        Map<Integer, Integer> map1 = buildMap(a1);
        int n2 = n - n1;
        int[] a2 = new int[n2];
        for (int i = n1; i < n; i++) {
            a2[i- n1] = a[i];
        }
        Map<Integer, Integer> map2 = buildMap(a2);

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            if (map2.containsKey(goal-key)) {
                ArrayList<Integer> res = new ArrayList<>();
                Integer value1 = entry.getValue();
                for (int i = 0; i < n1; i++) {
                    res.add(Math.min(1, value1 & (1<<i)));
                }
                Integer value2 = map2.get(goal - key);
                for (int i = 0; i < n2; i++) {
                    res.add(Math.min(1, value2 & (1<<i)));
                }
                return res;
            }
        }
        return List.of();
    }

    private static Map<Integer, Integer> buildMap(int[] a) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            Map<Integer, Integer> tmp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                tmp.put(key + ai, value | (1 << i));
                tmp.put(key - ai, value);
            }
            map = tmp;
        }
        return map;
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