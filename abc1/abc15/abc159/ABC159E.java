import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC159E {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int k = nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << h; i++) {
            // 1桁目は0固定で考える。
            if ((i&1)==1) continue;
            List<List<Integer>> lists = new ArrayList<>();
            int current = 1;
            for (int j = 0; j < h; j++) {
                if (Math.min(1, i & (1 << j)) != current) {
                    lists.add(new ArrayList<>());
                    current = 1-current;
                }
                lists.get(lists.size()-1).add(j);
            }
            int size = lists.size();
            int result = size-1;
            int[] total = new int[size];
            for (int j = 0; j < w; j++) {
                int[] counts = new int[size];
                for (int l = 0; l < size; l++) {
                    List<Integer> list = lists.get(l);
                    for (Integer integer : list) {
                        if (s[integer][j] == '1') {
                            counts[l]++;
                        }
                    }
                }
                int countMax = 0;
                for (int l = 0; l < size; l++) {
                    countMax = Math.max(countMax, counts[l]);
                }
                if (countMax>k) {
                    result = Integer.MAX_VALUE;
                    break;
                }
                int sumMax = 0;
                for (int l = 0; l < size; l++) {
                    sumMax = Math.max(sumMax, total[l]+counts[l]);
                }
                if (sumMax>k) {
                    total = counts;
                    result++;
                } else {
                    for (int l = 0; l < size; l++) {
                        total[l]+=counts[l];
                    }
                }
            }
            ans = Math.min(ans, result);
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