import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC250E {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);

        Pair[] ranges = new Pair[n];
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        Set<Integer> additionalA = new HashSet<>();
        Set<Integer> additionalB = new HashSet<>();
        int r = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            if (aSet.contains(ai)) {
                ranges[i] = ranges[i-1];
                continue;
            }
            aSet.add(ai);
            additionalB.remove(ai);
            if (!bSet.contains(ai)) {
                additionalA.add(ai);
            }
            while (r<n && !additionalA.isEmpty()) {
                int br = b[r];
                additionalA.remove(br);
                bSet.add(br);
                if (!aSet.contains(br)) {
                    additionalB.add(br);
                }
                r++;
            }
            if (!additionalA.isEmpty()) continue;
            if (!additionalB.isEmpty()) continue;

            int l = r-1;
            while (r<n && aSet.contains(b[r])) {
                r++;
            }
            ranges[i] = new Pair(l, r);
        }

//        System.out.println(Arrays.toString(ranges));

        int q = nextInt();
        while (q-->0) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            Pair range = ranges[x];

            if (range != null && range.l <= y && y < range.r) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
    }

    private static class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "l=" + l +
                ", r=" + r +
                '}';
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