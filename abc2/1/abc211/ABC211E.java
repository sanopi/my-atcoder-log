import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Scanner;

public class ABC211E {

    static int ans = 0;
    static int n = 0;
    static String[][] s;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        s = new String[n][n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j].equals(".")) {
                    s[i][j] = "@";
                    solve(k-1);
                    s[i][j] = "#";
                }
            }
        }
        System.out.println(ans);
    }

    static void solve(int num) {
        if (num == 0) {
            ans += 1;
            return;
        }

        ArrayList<SimpleEntry<Integer, Integer>> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i][j].equals(".")) {
                    if (valid(i-1, j) && s[i - 1][j].equals("@")
                        || valid(i, j-1) && s[i][j - 1].equals("@")
                        || valid(i+1, j) && s[i + 1][j].equals("@")
                        || valid(i, j+1) && s[i][j + 1].equals("@")) {
                        s[i][j] = "@";
                        solve(num-1);
                        s[i][j] = "#";
                        queue.add(new SimpleEntry(i, j));
                    }
                }
            }
        }
        for (SimpleEntry<Integer, Integer> entry : queue) {
            s[entry.getKey()][entry.getValue()] = ".";
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x <= n - 1 && y >= 0 && y <= n - 1;
    }
}
