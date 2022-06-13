import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC187E {

    private static long[] ans;
    private static List<Path>[] tree;

    public static void main(String[] args) {
        int n = nextInt();
        Path[] paths = new Path[n-1];
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            Path path = new Path(a, b, i);
            paths[i] = path;
            tree[a].add(path);
            tree[b].add(path);
        }
        ans = new long[n];
        //        solve1(n, paths);
        solve2(n, paths);
        for (long an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static void solve2(int n, Path[] paths) {
        fillChild(0, -1);
        int q = nextInt();
        while (q-->0) {
            int t = nextInt();
            int e = nextInt()-1;
            int x = nextInt();
            Path path = paths[e];
            if (t == 1) { // aの方
                if (path.child == 'a') {
                    ans[path.a] += x;
                } else {
                    ans[0] += x;
                    ans[path.b] -= x;
                }
            } else { // bの方
                if (path.child == 'b') {
                    ans[path.b] += x;
                } else {
                    ans[0] += x;
                    ans[path.a] -= x;
                }
            }
        }
        doImos(0, -1, ans);
    }

    private static void fillChild(int current, int prev) {
        for (Path path : tree[current]) {
            if (path.next(current).next == prev) continue;
            if (path.a == current) path.child='b'; else path.child='a';
            fillChild(path.next(current).next, current);
        }
    }

    private static void doImos(int current, int prev, long[] arr) {
        for (Path path : tree[current]) {
            Path.Pair next = path.next(current);
            if (next.next == prev) continue;
            arr[next.next] += arr[current];
            doImos(next.next, current, arr);
        }
    }

    private static void solve1(int n, Path[] paths) {
        int q = nextInt();
        while (q-->0) {
            int t = nextInt();
            int e = nextInt()-1;
            int x = nextInt();
            if (t == 1) {
                paths[e].aAdd+=x;
            } else {
                paths[e].bAdd+=x;
            }
        }
        dfs0(0, -1, null);
        dfs1(0, -1, 0);
    }

    private static void dfs0(int current, int prev, Path from) {
        long res = 0;
        for (Path path : tree[current]) {
            Path.Pair next = path.next(current);
            if (next.next == prev) continue;
            dfs0(next.next, current, path);
            res += path.current(current);
        }
        if (from == null) return;
        if (from.a == prev) {
            from.aAdd += res;
        } else {
            from.bAdd += res;
        }
    }
    private static void dfs1(int current, int prev, long add) {
        ans[current]+=add;
        long sum = tree[current].stream().filter(p -> p.a!=prev && p.b!=prev).mapToLong(p -> p.current(current)).sum();
        for (Path path : tree[current]) {
            Path.Pair next = path.next(current);
            if (next.next == prev) continue;
            dfs1(next.next, current, add + next.add + sum - path.current(current));
            ans[current] += path.current(current);
        }
    }

    private static class Path {
        int a;
        int b;
        int i;
        long aAdd = 0;
        long bAdd = 0;
        char child = ' ';
        public Path(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i = i;
        }
        private static class Pair {
            int next;
            long add;
            public Pair(int next, long add) {
                this.next = next;
                this.add = add;
            }
        }
        Pair next(int current) {
            if (a == current) {
                return new Pair(b, bAdd);
            }
            return new Pair(a, aAdd);
        }
        long current(int current) {
            return a==current ? aAdd: bAdd;
        }
        @Override
        public String toString() {
            return "Path{" +
                "a=" + a +
                ", b=" + b +
                ", i=" + i +
                ", aAdd=" + aAdd +
                ", bAdd=" + bAdd +
                '}';
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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