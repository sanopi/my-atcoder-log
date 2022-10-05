import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class ABC271F {

    private static final int[] X = {1, 0};
    private static final int[] Y = {0, 1};
    private static final int[] XX= {-1, 0};
    private static final int[] YY = {0, -1};

    public static void main(String[] args) {
        int n = nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            a[i][0] = 1;
            a[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }
        Map<Pair, Map<Integer, Long>> mapMap1 = new HashMap<>();
        fillMap(n, a, mapMap1, 0, 0, X, Y);
        Map<Pair, Map<Integer, Long>> mapMap2 = new HashMap<>();
        fillMap(n, a, mapMap2, n-1, n-1, XX, YY);
        long ans = 0;
        for (Map.Entry<Pair, Map<Integer, Long>> entry : mapMap1.entrySet()) {
            Pair pair = entry.getKey();
            if (pair.x + pair.y != n - 1) {
//                continue;
            }
            Map<Integer, Long> map = entry.getValue();
            Map<Integer, Long> map2 = mapMap2.getOrDefault(pair, new HashMap<>());
            for (Map.Entry<Integer, Long> mapEntry : map.entrySet()) {
                Integer integer = mapEntry.getKey();
                Long count = mapEntry.getValue();
                ans += map2.getOrDefault(integer ^ a[pair.x][pair.y], 0L) * count;
            }
        }
        out.println(ans);
        out.flush();
    }
    private static void fillMap(int n, int[][] a, Map<Pair, Map<Integer, Long>> mapMap, int sx, int sy, int[] X, int[] Y) {
        Queue<Pair> queue = new ArrayDeque<>();
        Pair sp = new Pair(sx, sy);
        queue.add(sp);
        HashMap<Integer, Long> sm = new HashMap<>();
        sm.put(a[sx][sy], 1L);
        mapMap.put(sp, sm);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x + current.y == n - 1) {
                continue;
            }
            Map<Integer, Long> cMap = mapMap.get(current);
            for (int i = 0; i < 2; i++) {
                int nx = current.x + X[i];
                int ny = current.y + Y[i];
                if (!(0<= nx && nx < n && 0<=ny && ny < n)) continue;
                Pair np = new Pair(nx, ny);
                Map<Integer, Long> nMap = mapMap.getOrDefault(np, new HashMap<>());
                cMap.forEach((k, v) -> {
                    nMap.merge(k ^ a[nx][ny], v, Math::addExact);
                });
                if (!mapMap.containsKey(np))  {
                    queue.add(np);
                }
                mapMap.put(np, nMap);
            }
        }
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public String toString() {
            return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
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