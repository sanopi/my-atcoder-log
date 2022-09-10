import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC268F {

    public static void main(String[] args) {
        int n = nextInt();
        S[] input = new S[n];
        for (int i = 0; i < n; i++) {
            String s = next();
            char[] chars = s.toCharArray();
            int xCount = 0;
            long thisScore = 0;
            long addScore = 0;
            for (char aChar : chars) {
                if (aChar == 'X') xCount++;
                else {
                    thisScore += (long) xCount * (aChar - '0');
                    addScore += (aChar - '0');
                }
            }
            input[i] = new S(s, xCount, thisScore, addScore);
        }

        Arrays.sort(input, Comparator.naturalOrder());
        long ans = 0;
        long xCount = 0;
        for (S s : input) {
            ans += (s.thisScore + xCount*s.addScore);
            xCount += s.xCount;
        }
        out.println(ans);
        out.flush();
    }

    private static class S implements Comparable<S> {
        String s;
        int xCount;
        long thisScore;
        long addScore;
        public S(String s, int xCount, long thisScore, long addScore) {
            this.s = s;
            this.xCount = xCount;
            this.thisScore = thisScore;
            this.addScore = addScore;
        }

        @Override
        public int compareTo(S other) {
            return -Long.compare(
                this.xCount * other.addScore,
                other.xCount * this.addScore
            );
        }
        @Override
        public String toString() {
            return "S{" +
                "s='" + s + '\'' +
                ", xCount=" + xCount +
                ", thisScore=" + thisScore +
                ", addScore=" + addScore +
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