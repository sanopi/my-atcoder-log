import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ABC060D {

    public static void main(String[] args) {
        int n = nextInt();
        int w = nextInt();
        Mono[] monos = new Mono[n];
        for (int i = 0; i < n; i++) {
            monos[i] = new Mono(nextInt(), nextInt());
        }

        long ans;
//        ans = solve1(n, w, monos);
        ans = solve2(n, w, monos);
        out.println(ans);
        out.flush();
    }

    private static long solve2(int n, int w, Mono[] monos) {
        List<Long>[] monoMap = new List[4];
        int w0 = monos[0].w;
        int w01 = w0+1;
        int w02 = w0+2;
        int w03 = w0+3;
        for (int i = 0; i <= 3; i++) {
            monoMap[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int j = monos[i].w - w0;
            monoMap[j].add((long)monos[i].v);
        }

        int w0Count = monoMap[0].size();
        int w01Count = monoMap[1].size();
        int w02Count = monoMap[2].size();
        int w03Count = monoMap[3].size();

        long[][] values = new long[4][n+1];
        for (int i = 0; i < 4; i++) {
            monoMap[i].sort(Comparator.reverseOrder());
            for (int j = 0; j < monoMap[i].size(); j++) {
                values[i][j+1] = monoMap[i].get(j);
            }
            for (int j = 1; j < n + 1; j++) {
                values[i][j] += values[i][j-1];
            }
        }
        long ans = 0;
        for (int i = 0; i <= w0Count; i++) {
            for (int j = 0; j <= w01Count; j++) {
                for (int k = 0; k <= w02Count; k++) {
                    for (int l = 0; l <= w03Count; l++) {
                        if ((long)w0*i+(long)w01*j+(long)w02*k+(long)w03*l > w) continue;
                        ans = Math.max(ans, values[0][i]+values[1][j]+values[2][k]+values[3][l]);
                    }
                }
            }
        }

        return ans;
    }

    private static long solve1(int n, int w, Mono[] monos) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);

        for (int i = 0; i < n; i++) {
            Mono mi = monos[i];
            Map<Integer, Long> newMap = new HashMap<>(map);
            Set<Integer> keys = map.keySet();
            for (Integer weight : keys) {
                int next = weight + mi.w;
                if (next <= w) {
                    newMap.put(next, Math.max(map.getOrDefault(next, 0L), map.get(weight) + mi.v));
                }
            }
            map = newMap;
        }
        long ans = map.values().stream().max(Comparator.naturalOrder()).get();
        return ans;
    }

    private static class Mono {
        int w;
        int v;
        public Mono(int w, int v) {
            this.w = w;
            this.v = v;
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