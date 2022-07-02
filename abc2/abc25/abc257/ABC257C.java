import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ABC257C {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        int[] w = nextIntArray(n);
        int[] compressed = compress(w);
        int[] childs = new int[n];
        int[] adults = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                childs[compressed[i]]++;
            } else {
                adults[compressed[i]]++;
            }
        }
        for (int i = 1; i < n; i++) {
            childs[i] += childs[i-1];
        }
        for (int i = n - 2; i >= 0; i--) {
            adults[i] += adults[i+1];
        }

        int ans = adults[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, childs[i-1]+adults[i]);
        }
        ans = Math.max(ans, childs[n-1]);
        out.println(ans);
        out.flush();
    }

    private static int[] compress(int[] array) {
        TreeSet<Integer> sortedElements = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element: sortedElements) map.put(element, count++);
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) res[i] = map.get(array[i]);
        return res;
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