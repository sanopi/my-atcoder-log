import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC245E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        int[] c = nextIntArray(m);
        int[] d = nextIntArray(m);
        String ans;
//        ans = solve1(n, m, a, b, c, d);
        ans = solve2(n, m, a, b, c, d);
        out.println(ans);
        out.flush();
    }

    private static String solve2(int n, int m, int[] a, int[] b, int[] c, int[] d) {
        Square[] chocos = new Square[n];
        for (int i = 0; i < n; i++) {
            chocos[i] = new Square(a[i], b[i], false);
        }
        Square[] boxes = new Square[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = new Square(c[i], d[i], true);
        }
        Arrays.sort(chocos, Comparator.comparing(s -> -s.x));
        Arrays.sort(boxes, Comparator.comparing(s -> -s.x));

        TreeMap<Integer, Integer> counts = new TreeMap<>();
        int boxi = 0;
        for (Square choco : chocos) {
            while (boxi < m && boxes[boxi].x >= choco.x) {
                counts.put(boxes[boxi].y, counts.getOrDefault(boxes[boxi].y, 0)+1);
                boxi++;
            }
            int chocoy = choco.y;
            Map.Entry<Integer, Integer> entry = counts.ceilingEntry(chocoy);
            if (entry == null) {
                return "No";
            }
            counts.put(entry.getKey(), entry.getValue()-1);
            counts.remove(entry.getKey(), 0);
        }
        return "Yes";
    }

    private static String solve1(int n, int m, int[] a, int[] b, int[] c, int[] d) {
        List<Square> all = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            all.add(new Square(a[i], b[i], false));
        }
        for (int i = 0; i < m; i++) {
            all.add(new Square(c[i], d[i], true));
        }
        all.sort(Comparator.comparing((Square s) -> -s.x).thenComparing(s -> s.box?0:1));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Square square : all) {
            if (square.box) {
                map.put(square.y, map.getOrDefault(square.y, 0)+1);
            } else {
                Map.Entry<Integer, Integer> entry = map.ceilingEntry(square.y);
                if (entry==null) {
                    return "No";
                }
                map.put(entry.getKey(), entry.getValue()-1);
                map.remove(entry.getKey(), 0);
            }
        }
        return "Yes";
    }

    private static class Square {
        int x;
        int y;
        boolean box;
        public Square(int x, int y, boolean box) {
            this.x = x;
            this.y = y;
            this.box = box;
        }
        @Override
        public String toString() {
            return "Square{" +
                "x=" + x +
                ", y=" + y +
                ", box=" + box +
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