import java.io.PrintWriter;
import java.util.Scanner;

public class ABC234E {

    public static void main(String[] args) {
        String s = next();
        int length = s.length();
        if (length <3) {
            System.out.println(s);
            return;
        }
        if (isOk(s)) {
            System.out.println(s);
            return;
        }

        long x = Long.parseLong(s);
        char[] chars = s.toCharArray();
        if (length <= 10) {
            int maxStep = 10/(length-1);
            if (extracted(length, x, chars, maxStep)) return;
            if (chars[0]<'9') {
                chars[0]+=1;
                if (extracted(length, x, chars, maxStep)) return;
            }
        } else {
            if (x < Long.parseLong(Character.toString(chars[0]).repeat(length))) {
                System.out.println(Character.toString(chars[0]).repeat(length));
            } else {
                System.out.println(Character.toString(chars[0]+1).repeat(length));
            }
        }
    }

    private static boolean extracted(int length, long x, char[] chars, int maxStep) {
        for (int i = maxStep; i >= 0; i--) {
            char[] next = generate(chars[0], length, i);
            try {
                long nextX = Long.parseLong(String.valueOf(next));
                if (nextX > x) {
                    System.out.println(nextX);
                    return true;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println("desc");
            }
        }
        if (x < Long.parseLong(Character.toString(chars[0]).repeat(length))) {
            System.out.println(Character.toString(chars[0]).repeat(length));
            return true;
        }
        for (int i = 0; i <= maxStep; i++) {
            char[] next = generatePlus(chars[0], length, i);
            try {
                long nextX = Long.parseLong(String.valueOf(next));
                if (nextX > x) {
                    System.out.println(nextX);
                    return true;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.err.println("asc");
            }
        }
        return false;
    }

    // 長さ3以上
    private static boolean isOk(String s) {
        char[] chars = s.toCharArray();
        int diff = chars[1] - chars[0];
        for (int i = 2; i < chars.length; i++) {
            if (diff != (chars[i] - chars[i-1])) {
                return false;
            }
        }
        return true;
    }

    private static char[] generate(char first, int length, int step) {
        char[] res = new char[length];
        res[0] = first;
        for (int i = 1; i < length; i++) {
            res[i] = (char)((int) res[i - 1] - step);
        }
        return res;
    }

    private static char[] generatePlus(char first, int length, int step) {
        char[] res = new char[length];
        res[0] = first;
        for (int i = 1; i < length; i++) {
            res[i] = (char)((int) res[i - 1] + step);
        }
        return res;
    }

    private static boolean isNotAsc(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1] < chars[i]) {
                return false;
            }
        }
        return true;
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