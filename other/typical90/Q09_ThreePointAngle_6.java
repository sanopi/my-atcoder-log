
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q09_ThreePointAngle_6 {

    private static final double tPi = Math.PI*2;

    public static void main(String[] args) {
        int n = nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(i, nextLong(), nextLong());
        }
        double[][] angleLists = new double[n][n-1];
        for (int i = 0; i < n; i++) {
            int k = 0;
            double[] angleList = angleLists[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                angleList[k] = Math.atan2(points[j].y - points[i].y, points[j].x - points[i].x) + Math.PI;
                k++;
            }
            Arrays.sort(angleList);
        }

        double ans = 0.0;
        // pjを固定
        for (int j = 0; j < n; j++) {
            double[] angleList = angleLists[j];
            // piを選ぶ
            int length = angleList.length;
            for (int i = 0; i < length; i++) {
                if (j == i) continue;
                double angle1 = angleList[i];
                // angle-π に最も近い物をpkとして選ぶ
                int found = lowerBound(angleList, (angle1+Math.PI)%tPi);
                double result = 0;
                for (int ii : new int[]{found - 1, found, found + 1}) {
                    int ii1 = (ii + length) % length;
                    double angle2 = angleList[ii1];
                    double normalized = Math.min(Math.abs(angle1 - angle2), Math.PI * 2 - Math.abs(angle1 - angle2));
                    result = Math.max(result, normalized);
                }
                ans = Math.max(ans, result);
            }
        }
        out.println(Math.toDegrees(ans));
        out.flush();
    }

    private static class Point {
        int i;
        long x;
        long y;
        public Point(int i, long x, long y) {
            this.i = i;
            this.x = x;
            this.y = y;
        }
    }

    private static int lowerBound(double[] a, double key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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