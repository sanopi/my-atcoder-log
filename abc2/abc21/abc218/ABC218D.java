import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC218D {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, ArrayList<Pair>> xp = new HashMap<>();
        Map<Integer, ArrayList<Pair>> yp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            ArrayList<Pair> xlist = xp.getOrDefault(x, new ArrayList<>());
            xlist.add(new Pair(x, y));
            xp.put(x, xlist);
        }


        List<ArrayList<Pair>> collect = xp.entrySet().stream()
            .filter(pp -> pp.getValue().size() >= 2)
            .map(pp -> pp.getValue())
            .collect(Collectors.toList());
        int m = collect.size();


        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                ArrayList<Pair> a = collect.get(i);
                ArrayList<Pair> b = collect.get(j);
                int count = 0;
                for (int k = 0; k < a.size(); k++) {
                    for (int l = 0; l < b.size(); l++) {
                        if (a.get(k).y == b.get(l).y) {
                            count += 1;
                        }
                    }
                }
                ans += ((long) count * (count-1) / 2);
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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