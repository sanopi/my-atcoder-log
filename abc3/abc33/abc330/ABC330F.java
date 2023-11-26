import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BinaryOperator;

public class ABC330F {

    private static BinaryOperator<Integer> ADD = Math::addExact;
    private static BinaryOperator<Integer> MINUS = (i, i0) -> i-i0;
    private static long k;

    private static void solve() {
        int n = nextInt();
        k = nextLong();
        TreeMap<Integer, Integer> xCount = new TreeMap<>();
        TreeMap<Integer, Integer> yCount = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            xCount.merge(x, 1, Math::addExact);
            yCount.merge(y, 1, Math::addExact);
        }
        while (k > 0) {
            Map.Entry<Integer, Integer> xf = xCount.firstEntry();
            Map.Entry<Integer, Integer> xl = xCount.lastEntry();
            Map.Entry<Integer, Integer> yf = yCount.firstEntry();
            Map.Entry<Integer, Integer> yl = yCount.lastEntry();
            int xDiff = Math.abs(xf.getKey() - xl.getKey());
            int yDiff = Math.abs(yf.getKey() - yl.getKey());
            if (xDiff > yDiff) {
                // xを縮める
                Map.Entry<Integer, Integer> xTarget;
                BinaryOperator<Integer> xOp;
                int xNext;
                if (xf.getValue() < xl.getValue()) {
                    xTarget = xf;
                    xOp = ADD;
                    xNext = xCount.higherKey(xTarget.getKey());
                } else {
                    xTarget = xl;
                    xOp = MINUS;
                    xNext = xCount.lowerKey(xTarget.getKey());
                }
                int cost = xTarget.getValue();
                int xMove = Math.abs(xNext-xTarget.getKey());
                int move = (int) Math.min(Math.min(k/cost, xMove), Math.abs(xDiff-yDiff));
                if (move == 0) break;
                k -= (long) move * cost;
                xCount.remove(xTarget.getKey());
                xCount.merge(xOp.apply(xTarget.getKey(), move), xTarget.getValue(), Math::addExact);

            } else if (xDiff < yDiff) {
                // yを縮める
                Map.Entry<Integer, Integer> yTarget;
                BinaryOperator<Integer> yOp;
                int yNext;
                if (yf.getValue() < yl.getValue()) {
                    yTarget = yf;
                    yOp = ADD;
                    yNext = yCount.higherKey(yTarget.getKey());
                } else {
                    yTarget = yl;
                    yOp = MINUS;
                    yNext = yCount.lowerKey(yTarget.getKey());
                }
                int cost = yTarget.getValue();
                int yMove = Math.abs(yNext-yTarget.getKey());
                int move = (int) Math.min(Math.min(k/cost, yMove), Math.abs(xDiff-yDiff));
                if (move == 0) break;
                k -= (long) move * cost;
                yCount.remove(yTarget.getKey());
                yCount.merge(yOp.apply(yTarget.getKey(), move), yTarget.getValue(), Math::addExact);
            } else {
                if (xDiff == 0) break;
                Map.Entry<Integer, Integer> xTarget;
                BinaryOperator<Integer> xOp;
                int xNext;
                if (xf.getValue() < xl.getValue()) {
                    xTarget = xf;
                    xOp = ADD;
                    xNext = xCount.higherKey(xTarget.getKey());
                } else {
                    xTarget = xl;
                    xOp = MINUS;
                    xNext = xCount.lowerKey(xTarget.getKey());
                }
                Map.Entry<Integer, Integer> yTarget;
                BinaryOperator<Integer> yOp;
                int yNext;
                if (yf.getValue() < yl.getValue()) {
                    yTarget = yf;
                    yOp = ADD;
                    yNext = yCount.higherKey(yTarget.getKey());
                } else {
                    yTarget = yl;
                    yOp = MINUS;
                    yNext = yCount.lowerKey(yTarget.getKey());
                }
                int cost = xTarget.getValue() + yTarget.getValue();
                int xMove = Math.abs(xNext-xTarget.getKey());
                int yMove = Math.abs(yNext-yTarget.getKey());
                int move = (int) Math.min(k/cost, Math.min(xMove, yMove));
                if (move == 0) break;
                k -= (long) move * cost;
                xCount.remove(xTarget.getKey());
                xCount.merge(xOp.apply(xTarget.getKey(), move), xTarget.getValue(), Math::addExact);
                yCount.remove(yTarget.getKey());
                yCount.merge(yOp.apply(yTarget.getKey(), move), yTarget.getValue(), Math::addExact);
            }
        }
        Map.Entry<Integer, Integer> xf = xCount.firstEntry();
        Map.Entry<Integer, Integer> xl = xCount.lastEntry();
        Map.Entry<Integer, Integer> yf = yCount.firstEntry();
        Map.Entry<Integer, Integer> yl = yCount.lastEntry();
//        System.out.println(xf);
//        System.out.println(xl);
//        System.out.println(yf);
//        System.out.println(yl);
        int xDiff = Math.abs(xf.getKey() - xl.getKey());
        int yDiff = Math.abs(yf.getKey() - yl.getKey());
        out.println(Math.max(xDiff, yDiff));
        out.flush();
    }



    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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