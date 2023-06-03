import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC302C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }
        List<List<Integer>> perm = perm(List.of(), IntStream.range(0, n).boxed().collect(Collectors.toList()));
        boolean ok = false;
        for (List<Integer> is : perm) {
            boolean tmpOk = true;
            for (int i = 0; i < is.size()-1; i++) {
                String current = ss[is.get(i)];
                String next = ss[is.get(i+1)];
                int diffCount = 0;
                for (int j = 0; j < m; j++) {
                    if (current.charAt(j) != next.charAt(j)) {
                        diffCount++;
                    }
                }
                tmpOk &= diffCount == 1;
            }
            if (tmpOk) {
                ok = true;
                break;
            }
        }
        out.println(ok ? "Yes" : "No");
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