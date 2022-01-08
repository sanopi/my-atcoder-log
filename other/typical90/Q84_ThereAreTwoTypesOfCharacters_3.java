import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q84_ThereAreTwoTypesOfCharacters_3 {

    public static void main(String[] args) {
        int n = nextInt();
        char[] ss = next().toCharArray();

        int baseIndex = 0;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (ss[baseIndex] != ss[i]) {
                ans += (long) (i - 1 - baseIndex + 1) * (long) ((n - 1) - i + 1);
                baseIndex = i;
            }
        }
        out.println(ans);
        out.flush();
    }

    // ランレングス圧縮を試す
    public static void main2(String[] args) {
        long n = nextLong();
        char[] ss = next().toCharArray();

        List<Count> counts = new ArrayList<>();
        counts.add(new Count(ss[0], 1L));
        for (int i = 1; i < n; i++) {
            if (ss[i - 1] != ss[i]) {
                counts.add(new Count(ss[i - 1], 1L));
            } else {
                counts.get(counts.size() - 1).count += 1L;
            }
        }
        long ret = counts.stream()
            .map(c -> c.count)
            .filter(count -> count != 1)
            .map(c -> (c * (c - 1) / 2))
            .reduce(((i, j) -> i + j))
            .orElse(0L)
            ;
        out.println((n * (n - 1) / 2) - ret);
        out.flush();
    }

    private static class Count {
        char c;
        long count;
        Count(char c, long count) {
            this.c = c;
            this.count = count;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
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