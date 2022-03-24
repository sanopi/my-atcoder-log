import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC232C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Set<Integer>[] takahashi = new Set[n];
        for (int i = 0; i < n; i++) {
            takahashi[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            takahashi[a].add(b);
            takahashi[b].add(a);
        }
        int[] aokiC = new int[m];
        int[] aokiD = new int[m];
        for (int i = 0; i < m; i++) {
            aokiC[i] = nextInt()-1;
            aokiD[i] = nextInt()-1;
        }
        List<List<Integer>> perm = perm(List.of(), IntStream.range(0, n).boxed().collect(Collectors.toList()));
        for (List<Integer> integers : perm) {
            Set<Integer>[] aoki = new Set[n];
            for (int i = 0; i < n; i++) {
                aoki[i] = new HashSet<>();
            }
            for (int i = 0; i < m; i++) {
                Integer c = integers.get(aokiC[i]);
                Integer d = integers.get(aokiD[i]);
                aoki[c].add(d);
                aoki[d].add(c);
            }
            if (Arrays.equals(takahashi, aoki)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
        out.flush();
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