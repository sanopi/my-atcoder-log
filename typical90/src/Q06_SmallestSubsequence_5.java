import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q06_SmallestSubsequence_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        List<Character> c = new ArrayList<>(k);
        next().chars().forEach(ch -> c.add((char)ch));

        List<Character> ans = c.subList(0, k);
        for (int i = k; i < n; i++) {
            ans.add(c.get(i));
            for (int j = 0; j < k; j++) {
                if (ans.get(j) > ans.get(j+1)) {
                    ans.remove(j);
                    break;
                }
            }
            if (ans.size() > k) {
                ans.remove(ans.size()-1);
            }
        }
        out.println(ans.stream().map(String::valueOf).reduce((s1, s2) -> s1 + s2).get());
        out.flush();
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
}