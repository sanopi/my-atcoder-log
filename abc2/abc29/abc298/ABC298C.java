import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ABC298C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = 200000;
        TreeMap<Integer, Integer>[] boxs = new TreeMap[n];
        for (int i = 0; i < n; i++) {
            boxs[i] = new TreeMap<>();
        }
        TreeSet<Integer>[] nums = new TreeSet[m];
        for (int i = 0; i < m; i++) {
            nums[i] = new TreeSet<>();
        }


        int q = nextInt();
        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                int i = nextInt()-1;
                int j = nextInt()-1;
                boxs[j].merge(i, 1, Math::addExact);
                nums[i].add(j);
            } else if (t == 2) {
                int i = nextInt()-1;
                boxs[i].forEach((key, value) -> {
                    for (int k = 0; k < value; k++) {
                        out.print(key+1+" ");
                    }
                });
                out.println();
            } else {
                int i = nextInt()-1;
                nums[i].forEach(value -> {
                    out.print(value+1+" ");
                });
                out.println();
            }
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