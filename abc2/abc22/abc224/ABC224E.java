import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC224E {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int n = nextInt();
        Num[] nums = new Num[n];
        for (int i = 0; i < n; i++) {
            int r = nextInt()-1;
            int c = nextInt()-1;
            int a = nextInt();
            nums[i] = new Num(r, c, a, i);
        }

        Arrays.sort(nums, Comparator.comparing(num -> num.a));
        List<List<Num>> split = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            Num num = nums[i];
            ArrayList<Num> l = new ArrayList<>();
            l.add(num);
            while (i-1 >= 0 && nums[i-1].a == num.a) {
                l.add(nums[--i]);
            }
            split.add(l);
        }

        int[] ans = new int[n];

        int[] rMemo = new int[h];
        Arrays.fill(rMemo, -1);
        int[] cMemo = new int[w];
        Arrays.fill(cMemo, -1);

        for (List<Num> numList : split) {
            for (Num num : numList) {
                ans[num.i] = Math.max(rMemo[num.r], cMemo[num.c])+1;
            }
            for (Num num : numList) {
                rMemo[num.r] = Math.max(rMemo[num.r], ans[num.i]);
                cMemo[num.c] = Math.max(cMemo[num.c], ans[num.i]);
            }
        }

        for (int an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static class Num {
        int r;
        int c;
        int a;
        int i;
        public Num(int r, int c, int a, int i) {
            this.r = r;
            this.c = c;
            this.a = a;
            this.i = i;
        }
        @Override
        public String toString() {
            return "Num{" +
                "r=" + r +
                ", c=" + c +
                ", a=" + a +
                ", i=" + i +
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