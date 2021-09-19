import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ABC219C {

    public static void main(String[] args) {
        String x = next();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = x.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        int n = nextInt();

        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }

        Stream<List<Integer>> tmp = Arrays.stream(ss)
            .map(s -> {
                List<Integer> list = new ArrayList<>();
                for (final char c : s.toCharArray()) {
                    list.add(map.get(c));
                }
                return list;
            });

        tmp.sorted((l1, l2) -> compare(l1, l2))
            .forEach(l -> {
                List<String> collect = l.stream()
                    .map(i -> chars[i])
                    .map(c -> c.toString())
                    .collect(Collectors.toList());
                out.println(String.join("", collect));
            });

        out.flush();
    }

    static int compare(List<Integer> l1, List<Integer> l2) {
        int min = Math.min(l1.size(), l2.size());
        for (int i = 0; i < min; i++) {
            if (l1.get(i).equals(l2.get(i))) {
                continue;
            }
            return l1.get(i).compareTo(l2.get(i));
        }
        return Integer.compare(l1.size(), l2.size());
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