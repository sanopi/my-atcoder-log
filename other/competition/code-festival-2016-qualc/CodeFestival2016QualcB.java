import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CodeFestival2016QualcB {

    public static void main(String[] args) {
        int k = nextInt();
        int t = nextInt();
        int[] a = nextIntArray(t);
        int ans;
//        ans = solve1(k, t, a);
        ans = solve2(k, t, a);
        out.println(ans);
        out.flush();
    }
    private static int solve2(int k, int t, int[] a) {
        int max = Arrays.stream(a).max().getAsInt();
        return Math.max(2*max-k-1, 0);
    }
    private static int solve1(int k, int t, int[] a) {
        PriorityQueue<Cake> pq = new PriorityQueue<>(Comparator.comparing(cake -> -cake.rest));
        for (int i = 0; i < t; i++) {
            pq.add(new Cake(i, a[i]));
        }
        int prev = -1;
        int count = 0;
        while (!pq.isEmpty()) {
            Cake cake = pq.poll();
            if (cake.num != prev) {
                cake.rest-=1;
                prev = cake.num;
            } else {
                Cake cake2 = pq.poll();
                if (cake2 != null) {
                    cake2.rest-=1;
                    prev = cake2.num;
                    if (cake2.rest>0) pq.add(cake2);
                } else {
                    cake.rest-=1;
                    count++;
                    prev = cake.num;
                }
            }
            if (cake.rest>0) pq.add(cake);
        }
        return count;
    }

    private static class Cake {
        int num;
        int rest;
        public Cake(int num, int rest) {
            this.num = num;
            this.rest = rest;
        }
        @Override
        public String toString() {
            return "Cake{" +
                "num=" + num +
                ", rest=" + rest +
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