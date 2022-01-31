import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Sumitrust2019D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        int ans;
//        ans = solve1(n, s);
        ans = solve2(n, s);
        out.println(ans);
        out.flush();
    }
    private static int solve2(int n, String s) {
        int[][] master = new int[10][n];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(master[i], n);
        }
        char[] chars = s.toCharArray();
        master[chars[n-1]-'0'][n-1] = n-1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                master[j][i] = master[j][i+1];

            }
            master[chars[i]-'0'][i] = i;
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    int iIndex = master[i][0];
                    if (iIndex > n-3) continue;
                    int jIndex = master[j][iIndex + 1];
                    if (jIndex > n-2) continue;
                    int kIndex = master[k][jIndex + 1];
                    if (kIndex != n) ans++;
                }
            }
        }

        return ans;
    }
    private static int solve1(int n, String s) {
        char[] chars = s.toCharArray();
        TreeSet<Integer>[] treeSets = new TreeSet[10];
        for (int i = 0; i < 10; i++) {
            treeSets[i] = new TreeSet<>();
        }
        for (int i = 0; i < n; i++) {
            treeSets[chars[i]-'0'].add(i);
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (treeSets[i].isEmpty()) continue;
                    Integer iIndex = treeSets[i].first();
                    if (iIndex == null) continue;
                    Integer jIndex = treeSets[j].higher(iIndex);
                    if (jIndex == null) continue;
                    Integer kIndex = treeSets[k].higher(jIndex);
                    if (kIndex != null) ans++;
                }
            }
        }
        return ans;
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