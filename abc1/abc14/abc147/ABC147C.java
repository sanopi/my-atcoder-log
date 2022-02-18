import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC147C {

    public static void main(String[] args) {
        int n = nextInt();
        List<Pair>[] shogen = new List[n];
        for (int i = 0; i < n; i++) {
            shogen[i] = new ArrayList<>();
            int a = nextInt();
            for (int j = 0; j < a; j++) {
                int x = nextInt()-1;
                boolean y = nextInt()==1;
                shogen[i].add(new Pair(x, y));
            }
        }

        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            boolean[] honests = new boolean[n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j))!=0) {
                    honests[j]=true;
                    count++;
                }
            }
            ans = Math.max(ans, isOk(n, shogen, honests)?count:0);
        }
        out.println(ans);
        out.flush();
    }

    private static boolean isOk(int n, List<Pair>[] shogen, boolean[] honests) {
        for (int j = 0; j < n; j++) {
            if (honests[j] != isTruth(shogen[j], honests)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isTruth(List<Pair> shogens, boolean[] honests) {
        for (Pair shogen : shogens) {
            if (honests[shogen.x]!=shogen.honest) {
                return false;
            }
        }
        return true;
    }

    private static class Pair {
        int x;
        boolean honest;
        public Pair(int x, boolean honest) {
            this.x = x;
            this.honest = honest;
        }
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