import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC332D {

    private static int h;
    private static int w;
    private static void solve() {
        h = nextInt();
        w = nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = nextInt();
            }
        }
        int[][] b = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                b[i][j] = nextInt();
            }
        }
        List<List<Integer>> permH = perm(List.of(), IntStream.range(0, h).boxed().collect(Collectors.toList()));
        List<List<Integer>> permW = perm(List.of(), IntStream.range(0, w).boxed().collect(Collectors.toList()));

        int ans = 100000;
        for (List<Integer> hList : permH) {
            for (List<Integer> wList : permW) {
                int[][] test = new int[h][w];
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        test[i][j] = a[hList.get(i)][wList.get(j)];
                    }
                }
                if (equals(test, b)) {
                    ans = Math.min(ans, calc(hList)+calc(wList));
                }
            }
        }
        if (ans == 100000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static List<List<Integer>> perm(List<Integer> current, List<Integer> target) {
        if (current.size() == target.size()) {
            return List.of(current);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer i : target) {
            if (current.contains(i)) continue;
            ArrayList<Integer> newList = new ArrayList<>(current);
            newList.add(i);
            res.addAll(perm(newList, target));
        }
        return res;
    }

    private static boolean equals(int[][] a, int[][] b) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int calc(List<Integer> l) {
        int len = l.size();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (l.get(i) < l.get(j)) {
                    res++;
                }
            }
        }
        return res;
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