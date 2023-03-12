import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ARC158B {

    public static void main(String[] args) {
        int n = nextInt();
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextDouble();
        }
        Arrays.sort(x);
        List<Triple> candidates = new ArrayList<>();
        for (int i = 0; i+2 < n; i++) {
            candidates.add(new Triple(x[i], x[i+1], x[i+2]));
        }
        candidates.add(new Triple(x[0], x[1], x[n-1]));
        candidates.add(new Triple(x[0], x[n-2], x[n-1]));
        List<Double> collect = candidates.stream()
            .map(Triple::calc)
            .sorted()
            .collect(Collectors.toList());
        out.println(collect.get(0));
        out.println(collect.get(n-1));
        out.flush();
    }

    private static class Triple {
        double a;
        double b;
        double c;
        public Triple(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        private double calc() {
            return (a+b+c)/a/b/c;
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