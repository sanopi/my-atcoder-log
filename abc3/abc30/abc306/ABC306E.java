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

        solve2(n, k, q);
//        solve1(n, k, q);
        out.flush();

    }
    private static void solve2(int n, int k, int q) {
        TreeMap<Integer, Integer> contains = new TreeMap<>();
        TreeMap<Integer, Integer> notContains = new TreeMap<>();
        contains.put(0, k);
        notContains.put(0, n-k);
        int[] a = new int[n];
        long ans = 0;
        while (q--> 0) {
            int x = nextInt()-1;
            int y = nextInt();
            int ax = a[x];
            a[x] = y;

            if (contains.containsKey(ax)) {
                contains.put(ax, contains.get(ax)-1);
                contains.remove(ax, 0);
                ans-=ax;
                if (notContains.lastKey() >= y) {
                    Integer highest = notContains.lastKey();
                    notContains.put(highest, notContains.get(highest)-1);
                    notContains.remove(highest, 0);
                    notContains.merge(y, 1, Math::addExact);
                    contains.merge(highest, 1, Math::addExact);
                    ans+=highest;
                } else {
                    contains.merge(y, 1, Math::addExact);
                    ans+=y;
                }
            } else {
                notContains.put(ax, notContains.get(ax)-1);
                notContains.remove(ax, 0);
                if (contains.firstKey() < y) {
                    Integer lowest = contains.firstKey();
                    ans-=lowest;
                    contains.put(lowest, contains.get(lowest)-1);
                    contains.remove(lowest, 0);
                    notContains.merge(lowest, 1, Math::addExact);

                    contains.merge(y, 1, Math::addExact);
                    ans+=y;
                } else {
                    notContains.merge(y, 1, Math::addExact);
                }
            }
            out.println(ans);
        }
    }
    private static void solve1(int n, int k, int q) {
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
        while (q--> 0) {
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