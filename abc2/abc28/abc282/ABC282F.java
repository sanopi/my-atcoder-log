import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC282F {

    public static void main(String[] args) {
        int n = nextInt();
        List<Out> outs = new ArrayList<>();
        List<Integer> outLength = new ArrayList<>();
        outLength.add(0);
        // 長さ i の、 j から始まる 出力
        TreeMap<Integer, Map<Integer, Integer>> outMemo = new TreeMap<>();

        // i は長さ
        for (int i = 1; i <= n; i+=i) {
            HashMap<Integer, Integer> map = new HashMap<>();
            outMemo.put(i, map);
            // jから始まる
            for (int j = 1; j <= n-i+1; j++) {
                Out out = new Out(j, j + i-1);
                outs.add(out);
                map.put(j, outs.size());
            }
        }
        out.println(outs.size());
        for (Out output : outs) {
            out.println(output.l + " " + output.r);
        }
        out.flush();

        int q = nextInt();
        while (q --> 0) {
            int l = nextInt();
            int r = nextInt();
            int len = r - l + 1;
            Map.Entry<Integer, Map<Integer, Integer>> entry = outMemo.floorEntry(len);
            Map<Integer, Integer> value = entry.getValue();
            System.out.println(value.get(l) + " " + value.get(r-entry.getKey()+1));
        }
        out.flush();
    }

    private static class Out {
        int l;
        int r;
        public Out(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
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