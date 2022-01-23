import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeFestival2016FinalB {

    public static void main(String[] args) {
        int n = nextInt();
        int i = 1;
        List<Integer> ints = new ArrayList<>();
        int sum = 1;
        while (sum <= n) {
            ints.add(i);
            i++;
            sum+=i;
        }
        sum-=i;

        int j = n - sum;
        int size = ints.size();
        for (int k = 0; k < size; k++) {
            ints.set(k, ints.get(k)+((size-k)<=j?1:0));
        }
        ints.forEach(out::println);
        out.flush();
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