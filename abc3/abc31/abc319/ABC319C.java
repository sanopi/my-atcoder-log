import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC319C {

    private static void solve() {
        int[][] c = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = nextInt();
            }
        }

        List<List<Integer>> perm = perm(List.of(), IntStream.range(0, 9).boxed().collect(Collectors.toList()));
        int gakkari = 0;
        for (List<Integer> order : perm) {
            boolean[][] done = new boolean[3][3];
            for (Integer current : order) {
                int i = current / 3;
                int j = current % 3;

                List<List<Integer>> ll = new ArrayList<>();
                // i固定
                ll.add(new ArrayList<>());
                ll.add(new ArrayList<>());
                ll.add(new ArrayList<>());
                ll.add(new ArrayList<>());
                for (int k = 0; k < 3; k++) {
                    if (done[i][k]) {
                        ll.get(0).add(c[i][k]);
                    }
                }
                // j固定
                for (int k = 0; k < 3; k++) {
                    if (done[k][j]) {
                        ll.get(1).add(c[k][j]);
                    }
                }

                //　右上 左下
                if ((i==0&&j==2) || (i==1&&j==1) || (i==2&&j==0)) {
                    if (done[0][2]) {
                        ll.get(2).add(c[0][2]);
                    }
                    if (done[1][1]) {
                        ll.get(2).add(c[1][1]);
                    }
                    if (done[2][0]) {
                        ll.get(2).add(c[2][0]);
                    }
                }

                //　右した 左うえ
                if ((i==0&&j==0) || (i==1&&j==1) || (i==2&&j==2)) {
                    if (done[0][0]) {
                        ll.get(3).add(c[0][0]);
                    }
                    if (done[1][1]) {
                        ll.get(3).add(c[1][1]);
                    }
                    if (done[2][2]) {
                        ll.get(3).add(c[2][2]);
                    }
                }
                boolean is = false;
                for (List<Integer> integers : ll) {
                    if (integers.size() == 2) {
                        if (Objects.equals(integers.get(0), integers.get(1))) {
                            is = true;
                            break;
                        }
                    }
                }
                done[i][j] = true;
                if (is) {
                    gakkari++;
                    break;
                }
            }
        }

        out.println(((double) (perm.size() - gakkari) / perm.size()));
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

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> System.exit(1));
        thread.start();
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