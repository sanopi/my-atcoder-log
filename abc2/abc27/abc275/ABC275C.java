import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ABC275C {

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = next().toCharArray();
        }

        Set<Set<Pair>> ans = new HashSet<>();
        // 始点
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 移動
                if (board[i][j] == '.') continue;
                for (int k = 0; k < 9; k++) {
                    for (int l = 0; l < 9; l++) {
                        HashSet<Pair> pairs = new HashSet<>();
                        pairs.add(new Pair(i, j));
                        int nx = i;
                        int ny = j;

                        int[] X = {k, -l, -k};
                        int[] Y = {l, k, -l};
                        for (int m = 0; m < 3; m++) {
                            nx += X[m];
                            ny += Y[m];
                            if (!(0<=nx && nx<9 && 0<=ny && ny<9)) continue;
                            if (board[nx][ny] == '.') continue;
                            pairs.add(new Pair(nx, ny));
                        }
                        if (pairs.size() == 4) {
                            ans.add(pairs);
                        }
                    }
                }
            }
        }
        out.println(ans.size());
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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