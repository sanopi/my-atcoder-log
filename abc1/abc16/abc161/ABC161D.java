import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC161D {

    private static List<Integer>[] nexts = new List[10];

    public static void main(String[] args) {
        int k = nextInt();

        for (int i = 0; i < 10; i++) {
            nexts[i] = new ArrayList<>();
            for (int j = -1; j <= 1; j++) {
                int next = i+j;
                if (next < 0 || next > 9) continue;
                nexts[i].add(next);
            }
        }

        List<Long> lunlun = new ArrayList<>();
        int keta = 1;
        while (lunlun.size() < k) {
            for (long i = 1; i < 10; i++) {
                lunlun.addAll(dfs(i, keta-1));
                if (lunlun.size()>=k) {
                    break;
                }
            }
            keta++;
        }
        out.println(lunlun.get(k-1));
        out.flush();
    }

    private static List<Long> dfs(long i, int keta) {
        if (keta == 0) {
            return List.of(i);
        }
        List<Long> res = new ArrayList<>();
        for (Integer next : nexts[(int)i % 10]) {
            res.addAll(dfs(i*10+next, keta-1));
        }
        return res;
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