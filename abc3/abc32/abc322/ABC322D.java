import java.io.PrintWriter;
import java.util.Scanner;

public class ABC322D {

    public static void main(String[] args) {
        char[][][][] tmp = new char[3][4][4][4];
        int hashCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                char[] chars = next().toCharArray();
                for (int k = 0; k < 4; k++) {
                    tmp[i][0][j][k] = chars[k];
                    if (chars[k] == '#') hashCount++;
                }
            }
        }
        if (hashCount != 16) {
            System.out.println("No");
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        tmp[i][j+1][k][l] = tmp[i][j][3-l][k];
                    }
                }
            }
        }

        boolean ok = build(tmp[0], tmp[1], tmp[2]);

        if (ok) {
            out.println("Yes");
        } else {
            out.println("No");
        }

        out.flush();
    }

    private static boolean build(char[][][] a,char[][][] b,char[][][] c) {
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                boolean result = doBuild(a[0], b[j], c[k]);
                if (result) return true;
            }
        }
        return false;
    }

    private static boolean doBuild(char[][] a,char[][] b,char[][] c) {

        for (int ai = 0; ai < 7; ai++) {
            for (int aj = 0; aj < 7; aj++) {
                for (int bi = 0; bi < 7; bi++) {
                    for (int bj = 0; bj < 7; bj++) {
                        for (int ci = 0; ci < 7; ci++) {
                            for (int cj = 0; cj < 7; cj++) {
                                char[][] result = new char[10][10];
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        if (a[i][j] == '#') result[ai+i][aj+j] = a[i][j];
                                    }
                                }
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        if (b[i][j] == '#') result[bi+i][bj+j] = b[i][j];
                                    }
                                }
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        if (c[i][j] == '#') result[ci+i][cj+j] = c[i][j];
                                    }
                                }

                                boolean isAll = true;
                                for (int i = 3; i < 7; i++) {
                                    for (int j = 3; j < 7; j++) {
                                        isAll &= result[i][j] == '#';
                                    }
                                }
                                if (isAll) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
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