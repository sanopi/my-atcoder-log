import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC248D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        List<Integer>[] indexes = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            indexes[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            indexes[a[i]].add(i);
        }

        int q = nextInt();
        while (q-->0) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            int x = nextInt();
            List<Integer> indexList = indexes[x];
            if (indexList.isEmpty()) {
                out.println(0);
                continue;
            }
            int left = findLeft(indexList, l);
            int right = findRight(indexList, r);
            out.println(Math.max(0, right-left+1));
        }

        out.flush();
    }

    // i <= return
    private static int findLeft(List<Integer> list, int i) {
        if (i <= list.get(0)) return 0;
        int n = list.size();
        if (list.get(n -1) < i) return n;
        int ok = n-1;
        int ng = -1;
        while (Math.abs(ok-ng)>1) {
            int p = (ok+ng)/2;
            if (i <= list.get(p)) {
                ok = p;
            } else {
                ng = p;
            }
        }
        return ok;
    }

    private static int findRight(List<Integer> list, int i) {
        int n = list.size();
        if (list.get(n-1) <= i) return n-1;
        if (i < list.get(0)) return -1;
        int ok = 0;
        int ng = n;
        while (Math.abs(ok-ng)>1) {
            int p = (ok+ng)/2;
            if (list.get(p) <= i) {
                ok = p;
            } else {
                ng = p;
            }
        }
        return ok;
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