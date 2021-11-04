import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABC224D {

    private static ArrayList<Integer>[] g;
    private static int n;
    private static int m;

    private static Set<Integer> done = new HashSet<>(362880); // 9!

    public static void main(String[] args) {
        n = 9;
        m = nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        // komaI[i] = j: マスiにコマjがある
        int[] komaI = new int[n];
        Arrays.fill(komaI, 9);
        for (int i = 0; i < n-1; i++) {
            komaI[nextInt()-1] = i + 1;
        }

        Queue<Pair> q = new ArrayDeque<>();
        int linear = getInt(komaI);
        q.add(new Pair(linear, 0));
        done.add(linear);
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int i = poll.i;
            if (i == 123456789) {
                System.out.println(poll.dep);
                return;
            }
            int[] splited = splitInt(i);
            int point = -1;
            for (int j = 0; j < n; j++) {
                if (splited[j] == n) {
                    point = j;
                }
            }
            int tmp = splited[point];
            for (final Integer integer : g[point]) {
                int[] copied = Arrays.copyOf(splited, splited.length);
                copied[point] = copied[integer];
                copied[integer] = tmp;
                int anInt = getInt(copied);
                if (done.contains(anInt)) {
                    continue;
                }
                done.add(anInt);
                q.add(new Pair(anInt, poll.dep+1));
            }
        }
        System.out.println(-1);
    }

    private static class Pair {
        int i;
        int dep;
        public Pair(final int i, final int dep) {
            this.i = i;
            this.dep = dep;
        }
    }


    private static int getInt(int[] a) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res * 10 + a[i]);
        }
        return res;
    }

    private static int[] splitInt(int i) {
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            res[n-j-1] = (i % 10);
            i = i / 10;
        }
        return res;
    }

    private static boolean isOk(int[] koma) {
        for (int i = 0; i < n; i++) {
            if (koma[i] != i) {
                return false;
            }
        }
        return true;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}