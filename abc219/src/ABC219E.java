import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC219E {

    static int[] xx = {1,0,-1,0};
    static int[] yy = {0,1,0,-1};

    static boolean valid(int x, int y, int max) {
        return x >= 0 && x < max && y >= 0 && y < max;
    }

    public static void main(String[] args) {
        boolean[] town = new boolean[16];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (next().equals("1")) {
                    town[i*4+j] = true;
                    count++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < (1<<16); i++) {
            List<Integer> target = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                if ((i & (1<<j)) != 0) {
                    target.add(j);
                }
            }
            int c = 0;
            for (final Integer integer : target) {
                if (town[integer]) {
                    c++;
                }
            }
            if (count != c) { continue; }

            Set<Integer> set = new HashSet<>();
            Integer first = target.get(0);
            set.add(first);
            dfs(first, target, set, 4);

            //6x6でやる
            List<Integer> notTarget = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 11, 12, 17, 18, 23, 24, 29, 30, 31, 32, 33, 34, 35));
            for (int j = 0; j < 16; j++) {
                if (!target.contains(j)) {
                    notTarget.add((j/4+1)*6 + (j%4)+1);
                }
            }
            Set<Integer> set1 = new HashSet<>();
            Integer first1 = notTarget.get(0);
            set1.add(first1);
            dfs(first1, notTarget, set1, 6);

            if (target.size() == set.size() && notTarget.size() == set1.size()) {
                ans += 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    static void dfs(int i, Collection<Integer> target, Set<Integer> set, int size) {
        int x = i / size;
        int y = i % size;
        for (int j = 0; j < 4; j++) {
            int nx = x + xx[j];
            int ny = y + yy[j];
            if (!valid(nx, ny, size)) { continue; }
            int ii = nx * size + ny;
            if (target.contains(ii) && !set.contains(ii)) {
                set.add(ii);
                dfs(ii, target, set, size);
            }
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