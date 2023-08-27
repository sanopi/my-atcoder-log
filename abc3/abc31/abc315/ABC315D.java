import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC315D {

    private static void solve() {
        int h = nextInt();
        int w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }
        int[][] countH = new int[h][26];
        int[][] countW = new int[w][26];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int cij = g[i][j] - 'a';
                countH[i][cij]++;
                countW[j][cij]++;
            }
        }

        List<Integer> hi = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            hi.add(i);
        }
        List<Integer> wi = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            wi.add(i);
        }

        while (true) {
            List<Integer> nhi = new ArrayList<>();
            List<Integer> hDel = new ArrayList<>();
            if (hi.size()>=2) {
                for (int i : hi) {
                    int kind = 0;
                    int delKind = 0;
                    int alph = -1;
                    for (int j = 0; j < 26; j++) {
                        if (countH[i][j]>0) {
                            kind++;
                            alph=j;
                        }
                        if (countH[i][j] > 1) {
                            delKind++;
                        }
                    }
                    if (kind==1&&delKind==1) {
                        hDel.add(alph);
                    } else {
                        nhi.add(i);
                    }
                }
            } else {
                nhi=hi;
            }

            List<Integer> nwi = new ArrayList<>();
            List<Integer> wDel = new ArrayList<>();
            if (wi.size() >= 2) {
                for (Integer j : wi) {
                    int kind = 0;
                    int delKind = 0;
                    int alph = -1;
                    for (int i = 0; i < 26; i++) {
                        if (countW[j][i] > 0) {
                            kind++;
                            alph=i;
                        }
                        if (countW[j][i] > 1) {
                            delKind++;
                        }
                    }
                    if (kind==1 && delKind==1) {
                        wDel.add(alph);
                    } else {
                        nwi.add(j);
                    }
                }
            } else {
                nwi = wi;
            }
            for (Integer i : nhi) {
                for (Integer ci : wDel) {
                    countH[i][ci]--;
                }
            }
            for (Integer i : nwi) {
                for (Integer ci : hDel) {
                    countW[i][ci]--;
                }
            }

            if (hi.size()==nhi.size() && wi.size()==nwi.size()) {
                break;
            }
            hi = nhi;
            wi = nwi;
        }

        int ans = 0;
        for (Integer i : hi) {
            for (int j = 0; j < 26; j++) {
                ans += countH[i][j];
            }
        }
        for (Integer i : wi) {
            for (int j = 0; j < 26; j++) {
                ans += countW[i][j];
            }
        }

        out.println(ans/2);
        out.flush();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "", 16 * 1024 * 1024).start();

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