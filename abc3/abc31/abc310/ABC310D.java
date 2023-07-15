import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC310D {
    private static int ans = 0;
    private static int t;
    private static Set<Integer>[] g;
    public static void main(String[] args) {
        int n = nextInt();
        t = nextInt();
        int m = nextInt();
        g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        solve(IntStream.range(0,n).boxed().collect(Collectors.toList()), 0, new ArrayList<>());
        out.println(ans);
        out.flush();
    }

    private static void solve(List<Integer> base, int i, List<List<Integer>> teams) {
        if (base.size() == i) {
            if (teams.size() != t) return;
            boolean ok = true;
            for (List<Integer> team : teams) {
                for (int j = 0; j < team.size(); j++) {
                    for (int k = j+1; k < team.size(); k++) {
                        if (g[team.get(j)].contains(team.get(k))) {
                            ok = false;
                        }
                    }
                }
            }
            if (ok) {
                ans++;
            }
            return;
        }
        int p = base.get(i);
        for (int j = 0; j < teams.size(); j++) {
            teams.get(j).add(p);
            solve(base, i+1, teams);
            teams.get(j).remove(teams.get(j).size()-1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(p);
        teams.add(list);
        solve(base, i+1, teams);
        teams.remove(teams.size()-1);
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