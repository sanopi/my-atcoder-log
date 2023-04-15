import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC298F {

    public static void main(String[] args) {
        int n = nextInt();
        Input[] input = new Input[n];
        for (int i = 0; i < n; i++) {
            int r = nextInt();
            int c = nextInt();
            long x = nextLong();
            input[i] = new Input(r, c, x);
        }
        Map<Integer, Map<Integer, Input>> tateYokoInputs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Input inputI = input[i];
            int r = inputI.r;
            int c = inputI.c;
            Map<Integer, Input> map = tateYokoInputs.getOrDefault(r, new HashMap<>());
            map.put(c, inputI);
            tateYokoInputs.put(r, map);
        }

        Map<Integer, Long> yokoSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Input inputI = input[i];
            yokoSum.merge(inputI.c, inputI.x, Math::addExact);
        }
        ArrayList<SumYoko> sumYokoList = new ArrayList<>();
        yokoSum.forEach((c, sum) -> {
            sumYokoList.add(new SumYoko(sum, c));
        });
        sumYokoList.sort(Comparator.comparing(sy -> -sy.sum));

        Map<Integer, Long> tateSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Input inputI = input[i];
            tateSum.merge(inputI.r, inputI.x, Math::addExact);
        }

        long ans = 0;
        for (Map.Entry<Integer, Long> entry : tateSum.entrySet()) {
            int r = entry.getKey();
            long sum = entry.getValue();
            for (SumYoko sumYoko : sumYokoList) {
                int c = sumYoko.c;
                Map<Integer, Input> cMap = tateYokoInputs.get(r);
                if (cMap != null && cMap.containsKey(c)) {
                    ans = Math.max(ans, sum+yokoSum.getOrDefault(c, 0L) - cMap.get(c).x);
                } else {
                    ans = Math.max(ans, sum+yokoSum.getOrDefault(c, 0L));
                    break;
                }
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Input {
        int r;
        int c;
        long x;
        public Input(int r, int c, long x) {
            this.r = r;
            this.c = c;
            this.x = x;
        }
    }

    private static class SumYoko {
        long sum;
        int c;
        public SumYoko(long sum, int c) {
            this.sum = sum;
            this.c = c;
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