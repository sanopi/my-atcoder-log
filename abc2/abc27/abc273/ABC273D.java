import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC273D {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int rs = nextInt();
        int rc = nextInt();
        int n = nextInt();
        Map<Integer, TreeSet<Integer>> ijMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> jiMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = nextInt();
            int c = nextInt();
            TreeSet<Integer> jSet = ijMap.getOrDefault(r, new TreeSet<>());
            jSet.add(c);
            ijMap.put(r, jSet);

            TreeSet<Integer> iSet = jiMap.getOrDefault(c, new TreeSet<>());
            iSet.add(r);
            jiMap.put(c, iSet);
        }
        int q = nextInt();
        TreeSet<Integer> empty = new TreeSet<>();
        while (q --> 0) {
            String d = next();
            int l = nextInt();
            if (d.equals("L")) {
                int limit = Optional.ofNullable(ijMap.getOrDefault(rs, empty).lower(rc)).orElse(0);
                rc = Math.max(limit+1, rc-l);
                out.println(rs + " " + rc);
            } else if (d.equals("R")){
                int limit = Optional.ofNullable(ijMap.getOrDefault(rs,empty).higher(rc)).orElse(w+1);
                rc = Math.min(limit-1, rc+l);
                out.println(rs + " " + rc);
            } else  if (d.equals("U")){
                int limit = Optional.ofNullable(jiMap.getOrDefault(rc,empty).lower(rs)).orElse(0);
                rs = Math.max(limit+1, rs-l);
                out.println(rs + " " + rc);
            } else  if (d.equals("D")){
                int limit = Optional.ofNullable(jiMap.getOrDefault(rc,empty).higher(rs)).orElse(h+1);
                rs = Math.min(limit-1, rs+l);
                out.println(rs + " " + rc);
            }
        }

        out.flush();
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