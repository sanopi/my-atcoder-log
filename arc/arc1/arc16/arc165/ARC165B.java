import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ARC165B {

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        int[] p = nextIntArray(n);
//        int[] copy = Arrays.copyOf(p, p.length);
        int[] result1 = myAnswer(n, k, p);
//        int[] result2 = guchoku(n, k, copy);
        sOutP(result1);

//        List<Integer> list = IntStream.range(0, n).boxed().collect(Collectors.toList());
//        for (int i = 0; i < 1000; i++) {
//            Collections.shuffle(list);
//            int[] p = new int[n];
//            for (int j = 0; j < n; j++) {
//                p[j] = list.get(j);
//            }
//            int[] copy0 = new int[n];
//            for (int j = 0; j < n; j++) {
//                copy0[j] = p[j];
//            }
//            int[] copy1 = new int[n];
//            for (int j = 0; j < n; j++) {
//                copy1[j] = p[j];
//            }
//            int[] result1 = myAnswer(n, k, copy0);
//            int[] result2 = guchoku(n, k, copy1);
//            if (!Arrays.equals(result1, result2)) {
//                System.out.println(n + " " + k);
//                System.out.println("   " + Arrays.toString(p));
//                System.out.println("my " + Arrays.toString(result1));
//                System.out.println("gu " + Arrays.toString(result2));
//                return;
//            }
//        }


        out.flush();
    }

    private static int[] myAnswer(int n, int k, int[] p) {
        if (k == 1) {
            return p;
        }
        if (k == n) {
            Arrays.sort(p);
            return p;
        }

        int incCount = 0;
        for (int i = 0; i < n -1; i++) {
            if (p[i] < p[i+1]) {
                incCount++;
            } else {
                incCount = 0;
            }
            if (incCount >= k -1) {
                break;
            }
        }
        if (incCount >= k -1) {
            return p;
        }

        int left = n-k-1;
        while (left >= 1 && left > n-k-1-k+1) {
            if (p[left-1] > p[left]) {
                break;
            }
            left--;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = left; i < n - k; i++) {
            treeSet.add(p[i]);
        }

        int right = n-k;
        while (!treeSet.isEmpty()) {
            while (right-left < k && treeSet.last() < p[right]) {
                right++;
            }
            if (right-left == k) {
                break;
            }
            treeSet.remove(p[left]);
            left++;
        }
        if (treeSet.isEmpty()) {
            left = n-k;
        }

        int[] tmp = new int[k];
        for (int i = left; i < left + k; i++) {
            tmp[i-left] = p[i];
        }
        Arrays.sort(tmp);
        for (int i = left; i < left + k; i++) {
            p[i] = tmp[i-left];
        }
        return p;
    }

    private static int[] guchoku(int n, int k, int[] p) {
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++) {
            int[] copy = new int[n];
            for (int j = 0; j < n; j++) {
                copy[j] = p[j];
            }
            int[] tmp = new int[k];
            for (int j = i; j < i + k; j++) {
                tmp[j-i] = copy[j];
            }
            Arrays.sort(tmp);
            for (int j = i; j < i + k; j++) {
                copy[j] = tmp[j-i];
            }
            lists.add(copy);
        }
        lists.sort(Arrays::compare);
        return lists.get(lists.size()-1);
    }

    private static void sOutP(int[] p) {
        for (int i : p) {
            out.print(i + " ");
        }
        out.println();
        out.flush();
    }


    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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