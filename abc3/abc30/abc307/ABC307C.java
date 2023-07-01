import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC307C {

    public static void main(String[] args) {
        int ha = nextInt();
        int wa = nextInt();
        char[][] a = new char[ha][wa];
        for (int i = 0; i < ha; i++) {
            a[i] = next().toCharArray();
        }

        int hb = nextInt();
        int wb = nextInt();
        char[][] b = new char[hb][wb];
        for (int i = 0; i < hb; i++) {
            b[i] = next().toCharArray();
        }

        int hx = nextInt();
        int wx = nextInt();
        char[][] x = new char[hx][wx];
        int hashCountX= 0;
        for (int i = 0; i < hx; i++) {
            x[i] = next().toCharArray();
            for (int j = 0; j < wx; j++) {
                if (x[i][j] == '#') {
                    hashCountX++;
                }
            }
        }

        boolean yes = false;

        for (int xDiff = -20; xDiff <= 20; xDiff++) {
            for (int yDiff = -20; yDiff <= 20; yDiff++) {
                char[][] c = new char[50][50];
                for (int i = 0; i < 50; i++) {
                    Arrays.fill(c[i], '.');
                }
                int base = 20;
                for (int i = 0; i < ha; i++) {
                    for (int j = 0; j < wa; j++) {
                        c[base+i][base+j] = a[i][j];
                    }
                }
                for (int i = 0; i < hb; i++) {
                    for (int j = 0; j < wb; j++) {
                        if (c[base+xDiff+i][base+yDiff+j] == '#') continue;
                        c[base+xDiff+i][base+yDiff+j] = b[i][j];
                    }
                }

                int hashCount = 0;
                for (int i = 0; i < 50; i++) {
                    for (int j = 0; j < 50; j++) {
                        if (c[i][j] == '#') {
                            hashCount++;
                        }
                    }
                }
                if (hashCountX != hashCount) continue;

                for (int i = 0; i <= 50 - hx; i++) {
                    for (int j = 0; j <= 50 - wx; j++) {
                        boolean same = true;
                        for (int k = 0; k < hx; k++) {
                            for (int l = 0; l < wx; l++) {
                                same &= (c[i+k][j+l] == x[k][l]);
                            }
                        }
                        if (same) {
                            yes = true;
                            break;
                        }
                    }
                }
            }
        }

        out.println(yes ? "Yes" : "No");
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