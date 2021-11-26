import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ABC201C {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        Set<Integer> mustContain = new HashSet<>();
        Set<Integer> mayContain = new HashSet<>();
        Set<Integer> notContain = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == 'o') {
                mustContain.add(i);
            } else if (c=='x') {
                notContain.add(i);
            } else if (c=='?') {
                mayContain.add(i);
            }
        }

        int ans = 0;
        for (int i = 0; i < 10000; i++) {
            String si = String.valueOf(i);
            si = "0".repeat(4-si.length()) + si;
            Set<Integer> collect = Arrays.stream(si.split("")).map(j -> Integer.parseInt(j)).collect(Collectors.toSet());
            if (collect.containsAll(mustContain) && collect.stream().noneMatch(j -> notContain.contains(j))) {
                ans ++;
            }
        }
        System.out.println(ans);
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}