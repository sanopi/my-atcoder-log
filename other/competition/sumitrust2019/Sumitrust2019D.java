import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Sumitrust2019D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

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
        out.println(ans);
        out.flush();
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