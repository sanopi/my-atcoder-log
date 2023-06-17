import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ABC306E {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int q = nextInt();

        TreeMap<Integer, TreeSet<Integer>> contains = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> notContains = new TreeMap<>();
        TreeSet<Integer> cSet = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            cSet.add(i);
        }
        TreeSet<Integer> ncSet = new TreeSet<>();
        for (int i = k; i < n; i++) {
            ncSet.add(i);
        }
        contains.put(0, cSet);
        notContains.put(0, ncSet);
        int[] a = new int[n];
        long ans = 0;
        while (q --> 0) {
            int x = nextInt()-1;
            int y = nextInt();
            int ax = a[x];
            a[x] = y;
            if (contains.getOrDefault(ax, new TreeSet<>()).contains(x)) {
                TreeSet<Integer> tSet = contains.getOrDefault(ax, new TreeSet<>());
                tSet.remove(x);
                if (tSet.isEmpty()) {
                    contains.remove(ax);
                }
                ans -= ax;
                Map.Entry<Integer, TreeSet<Integer>> highest = notContains.lastEntry();
                if (highest != null) {
                    if (highest.getKey() > y) {
                        Integer toMove = highest.getValue().pollFirst();
                        if (highest.getValue().isEmpty()) {
                            notContains.remove(highest.getKey());
                        }

                        TreeSet<Integer> set = contains.getOrDefault(highest.getKey(), new TreeSet<>());
                        set.add(toMove);
                        contains.put(highest.getKey(), set);
                        ans += highest.getKey();

                        TreeSet<Integer> set2 = notContains.getOrDefault(y, new TreeSet<>());
                        set2.add(x);
                        notContains.put(y, set2);
                    } else {
                        TreeSet<Integer> set = contains.getOrDefault(y, new TreeSet<>());
                        set.add(x);
                        contains.put(y, set);
                        ans += y;
                    }
                } else {
                    TreeSet<Integer> set = contains.getOrDefault(y, new TreeSet<>());
                    set.add(x);
                    contains.put(y, set);
                    ans += y;
                }

            } else {
                TreeSet<Integer> tSet = notContains.getOrDefault(ax, new TreeSet<>());
                tSet.remove(x);
                if (tSet.isEmpty()) {
                    notContains.remove(ax);
                }

                Map.Entry<Integer, TreeSet<Integer>> lowest = contains.firstEntry();
                if (lowest != null) {
                    if (lowest.getKey() < y) {
                        Integer toMove = lowest.getValue().pollFirst();
                        if (lowest.getValue().isEmpty()) {
                            contains.remove(lowest.getKey());
                        }
                        ans -= lowest.getKey();

                        TreeSet<Integer> set = notContains.getOrDefault(lowest.getKey(), new TreeSet<>());
                        set.add(toMove);
                        notContains.put(lowest.getKey(), set);

                        TreeSet<Integer> set2 = contains.getOrDefault(y, new TreeSet<>());
                        set2.add(x);
                        contains.put(y, set2);
                        ans += y;
                    } else {
                        TreeSet<Integer> set = notContains.getOrDefault(y, new TreeSet<>());
                        set.add(x);
                        notContains.put(y, set);
                    }
                } else {
                    TreeSet<Integer> set = notContains.getOrDefault(y, new TreeSet<>());
                    set.add(x);
                    notContains.put(y, set);
                }
            }
            out.println(ans);

        }
        out.flush();

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