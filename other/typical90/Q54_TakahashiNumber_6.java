import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q54_TakahashiNumber_6 {

    private static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] authorPapers = new List[n];
        for (int i = 0; i < n; i++) {
            authorPapers[i] = new ArrayList<>();
        }
        Set<Integer>[] paperCoAuthors = new Set[m];
        for (int i = 0; i < m; i++) {
            int k = nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                int author = nextInt() - 1;
                authorPapers[author].add(i);
                if (author !=0) {
                    set.add(author);
                }
            }
            paperCoAuthors[i] = set;
        }

        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        ans[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while (!q.isEmpty()) {
            int ca = q.poll();
            int cc = ans[ca];
            int nc = cc + 1;
            for (int paper : authorPapers[ca]) {
                Set<Integer> nexts = paperCoAuthors[paper];
                paperCoAuthors[paper] = new HashSet<>();
                for (int next : nexts) {
                    if (ans[next] <= nc) continue;
                    ans[next] = nc;
                    q.add(next);
                }
            }
        }

        for (int i : ans) {
            if (i == INF) {
                out.println(-1);
            } else {
                out.println(i);
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