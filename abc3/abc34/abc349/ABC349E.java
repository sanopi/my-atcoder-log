import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC349E {

    private static int[][] a;
    private static void solve() {
        a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = nextInt();
            }
        }
        // 3進数で盤面を表現する 3^9
        int MAX = 19683;
        // grundy数（0なら負け）を考える
        int[] grundy = new int[MAX];
        Arrays.fill(grundy, -1);
        for (int i = MAX - 1; i >= 0; i--) {
            Wins judge = judge(i);
            if (judge.equals(Wins.Error)) continue;
            int zeroCount = countZero(i);
            boolean tTurn = zeroCount%2 == 1;
            if ((judge.equals(Wins.Takahashi) && tTurn) || (judge.equals(Wins.Aoki) && !tTurn)) {
                continue;
            }
            if (judge.equals(Wins.Takahashi) || judge.equals(Wins.Aoki)) {
                int[][] ints = toGrid(i);
//                for (int[] anInt : ints) {
//                    System.out.println(Arrays.toString(anInt));
//                }
//                System.out.println();
                grundy[i] = 0;
                continue;
            }
            String s = getString(i);
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int j = 0; j < 9; j++) {
                treeSet.add(j);
            }
            for (int j = 0; j < 9; j++) {
                if (s.charAt(j) == '0') {
                    char[] chars = s.toCharArray();
                    if (zeroCount % 2 == 0) { // 青木くんのターン
                        chars[j] = '2';
                    } else { // 高橋くんのターン
                        chars[j] = '1';
                    }
                    int next = Integer.parseInt(String.valueOf(chars), 3);
                    treeSet.remove(grundy[next]);
                }
            }
            Integer g = treeSet.ceiling(0);
            grundy[i] = g;
        }
//        System.out.println(Arrays.toString(grundy));
        if (grundy[0] == 0) {
            System.out.println("Aoki");
        } else {
            System.out.println("Takahashi");
        }
        out.flush();
    }

    private static int countZero(int num) {
        int res = 0;
        int[][] grid = toGrid(num);
        for (int[] ints : grid) {
            for (int i : ints) {
                if (i == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    private static Wins judge(int num) {
        int[][] grid = toGrid(num);
        int tCount = 0;
        int aCount = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    tCount++;
                } else if (anInt == 2) {
                    aCount++;
                }
            }
        }
        if (!(tCount == aCount || tCount == aCount+1)) {
            return Wins.Error;
        }

        int tLines = 0;
        int aLines = 0;
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 1 && grid[i][1] == 1 && grid[i][2] == 1) {
                tLines++;
            }
            if (grid[i][0] == 2 && grid[i][1] == 2 && grid[i][2] == 2) {
                aLines++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == 1 && grid[1][i] == 1 && grid[2][i] == 1) {
                tLines++;
            }
            if (grid[0][i] == 2 && grid[1][i] == 2 && grid[2][i] == 2) {
                aLines++;
            }
        }

        if (grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1) {
            tLines++;
        }
        if (grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2) {
            aLines++;
        }

        if (grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1) {
            tLines++;
        }
        if (grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 2) {
            aLines++;
        }

        if (tLines + aLines > 1) {
            return Wins.Error;
        }
        if (tLines == 1) {
            return Wins.Takahashi;
        }
        if (aLines == 1) {
            return Wins.Aoki;
        }

        if (countZero(num) != 0) {
            return Wins.None;
        }

        long taka = 0;
        long ao = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 1) {
                    taka += a[i][j];
                } else {
                    ao += a[i][j];
                }
            }
        }
        if (taka>ao) {
            return Wins.Takahashi;
        } else {
            return Wins.Aoki;
        }
    }

    enum Wins {
        Takahashi, Aoki, None, Error
    }

    private static int[][] toGrid(int num) {
        String s = getString(num);
        int[][] res = new int[3][3];
        for (int i = 0; i < 9; i++) {
            char si = s.charAt(i);
            res[i / 3][i % 3] = si - '0';
        }
        return res;
    }

    private static String getString(int num) {
        String s = Integer.toString(num, 3);
        s = "0".repeat(9 - s.length()) + s;
        return s;
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
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
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