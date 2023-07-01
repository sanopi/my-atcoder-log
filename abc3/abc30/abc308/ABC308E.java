import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC308E {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        char[] c = next().toCharArray();

        int[] mCount = new int[3];
        Map<Set<Integer>, Long>[] meCountSum = new Map[n];
        meCountSum[0] = new HashMap<>();
        long ans = 0;
        if (c[0] == 'M') {
            mCount[a[0]]++;
        }

        for (int i = 1; i < n; i++) {
            char ci = c[i];
            if (ci == 'M') {
                mCount[a[i]]++;
            } else if (ci == 'E') {
                Map<Set<Integer>, Long> currentMeCount = new HashMap<>();
                for (int j = 0; j < 3; j++) {
                    long count = mCount[j];
                    if (count == 0) continue;
                    Set<Integer> set=new HashSet<>();
                    set.add(a[i]);
                    set.add(j);
                    currentMeCount.merge(set, count, Math::addExact);
                }
                Map<Set<Integer>, Long> prev = meCountSum[i - 1];
                currentMeCount.forEach((set, cnt) -> prev.merge(set, cnt, Math::addExact));
                meCountSum[i] = prev;
            } else {
                Map<Set<Integer>, Long> prev = meCountSum[i - 1];
                for (Map.Entry<Set<Integer>, Long> entry : prev.entrySet()) {
                    Set<Integer> set = entry.getKey();
                    Long count = entry.getValue();
                    for (int j = 0; j <= 3; j++) {
                        if (a[i]==j || set.contains(j)) continue;
                        ans += count*j;
                        break;
                    }
                }
            }
            if (meCountSum[i] == null) {
                meCountSum[i] = meCountSum[i-1];
            }
        }
        out.println(ans);
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