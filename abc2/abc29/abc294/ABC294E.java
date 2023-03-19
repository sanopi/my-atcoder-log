import java.io.PrintWriter;
import java.util.Scanner;

public class ABC294E {

    public static void main(String[] args) {
        long l = nextLong();
        int n1 = nextInt();
        int n2 = nextInt();
        Range[] range1 = new Range[n1];
        long prevR1 = 0;
        for (int i = 0; i < n1; i++) {
            int u = nextInt();
            long len = nextLong();
            range1[i] = new Range(u, prevR1, prevR1+len);
            prevR1=range1[i].r;
        }
        Range[] range2 = new Range[n2];
        long prevR2=0;
        for (int i = 0; i < n2; i++) {
            int u = nextInt();
            long len = nextLong();
            range2[i] = new Range(u, prevR2, prevR2+len);
            prevR2 = range2[i].r;
        }

        long ans = 0;

        int one = 0;
        int two = 0;
        while (one < n1 && two < n2) {
            if (range1[one].num == range2[two].num) {
                long result = range1[one].calc(range2[two]);
                ans += result;
            }
            if (range1[one].r < range2[two].r) {
                one++;
            } else {
                two++;
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Range {
        int num;
        long l;
        long r;
        public Range(int num, long l, long r) {
            this.num = num;
            this.l = l;
            this.r = r;
        }
        private long calc(Range other) {
            return Math.max(0,
                Math.min(this.r, other.r) - Math.max(this.l, other.l)
                );
        }
        @Override
        public String toString() {
            return "Range{" +
                "num=" + num +
                ", l=" + l +
                ", r=" + r +
                '}';
        }
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