import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC325D {

    private static void solve() {
        int n = nextInt();
        String r = next();
        String c = next();

        List<char[]> can = new ArrayList<>();
        if (n == 3) {
            char[] add1 = new char[n];
            Arrays.fill(add1, '#');
            can.add(add1);
        }
        else if (n==4) {

            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '#');
                chars[i] = '.';
                can.add(chars);
            }
        }
        else {

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    char[] chars = new char[n];
                    Arrays.fill(chars, '#');
                    chars[i] = chars[j] = '.';
                    can.add(chars);
                }
            }
        }
        List<char[][]> grids = build(n - 1, can);

        for (char[][] grid : grids) {
            if (!checkEmpty(grid, n-3)) continue;
            fillR(grid, r);
            if (!fillC(grid, c)) continue;

            List<Pair> hashes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '#') {
                        hashes.add(new Pair(i, j));
                    }
                }
            }
            int size = hashes.size();
            int mul = 1;
            for (int i = 0; i < size; i++) mul *= 3;
            for (int i = 0; i < mul; i++) {
                char[][] exam = new char[n][n];
                for (int ii = 0; ii < n; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        exam[ii][jj] = grid[ii][jj];
                    }
                }

                String s = Integer.toString(i, 3);
                s = "0".repeat(size-s.length()) + s;
                for (int j = 0; j < size; j++) {
                    exam[hashes.get(j).i][hashes.get(j).j] = (char)(s.charAt(j)-'0'+'A');
                }
                if (checkABC(exam)) {
                    System.out.println("Yes");
                    for (char[] chars : exam) {
                        System.out.println(String.valueOf(chars));
                    }
                    return;
                }
            }

        }

        System.out.println("No");
        out.flush();
    }

    private static List<char[][]> build(int i, List<char[]> can) {
        List<char[][]> res = new ArrayList<>();
        int n = can.get(0).length;
        if (i == 0) {
            for (char[] chars : can) {
                char[] newChar = new char[n];
                System.arraycopy(chars, 0, newChar, 0, n);
                char[][] g = new char[n][n];
                g[i] = newChar;
                res.add(g);
            }
            return res;
        }
        List<char[][]> result = build(i - 1, can);
        for (char[][] g : result) {
            for (char[] chars : can) {
                char[] newChar = new char[n];
                System.arraycopy(chars, 0, newChar, 0, n);
                char[][] add = new char[n][n];
                for (int ii = 0; ii < n; ii++) {
                    for (int jj = 0; jj < n; jj++) {
                        add[ii][jj] = g[ii][jj];
                    }
                }
                add[i] = newChar;
                res.add(add);
            }
        }
        return res;
    }

    private static boolean checkEmpty(char[][] target, int required) {
        int n = target.length;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (target[i][j] == '.') {
                    count++;
                }
            }
            if (count!=required) {
                return false;
            }
        }
        return true;
    }

    private static boolean fillR(char[][] grid, String r) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') {
                    grid[i][j] = r.charAt(i);
                    break;
                }
            }
        }
        return true;
    }

    private static boolean fillC(char[][] grid, String c) {
        int n = grid.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == '#' || grid[i][j] == c.charAt(j)) {
                    grid[i][j] = c.charAt(j);
                    break;
                }
                if (grid[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkABC(char[][] grid) {
        int n = grid.length;
        {
            for (int i = 0; i < n; i++) {
                int[] count = new int[3];
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '.') continue;
                    count[grid[i][j]-'A']++;
                }
                if (!Arrays.equals(count, new int[]{1,1,1})) return false;
            }
        }
        {
            for (int j = 0; j < n; j++) {
                int[] count = new int[3];
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == '.') continue;
                    count[grid[i][j]-'A']++;
                }
                if (!Arrays.equals(count, new int[]{1,1,1})) return false;
            }
        }
        return true;
    }

    private static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
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