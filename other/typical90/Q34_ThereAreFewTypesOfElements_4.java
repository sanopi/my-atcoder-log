import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q34_ThereAreFewTypesOfElements_4 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            int ra = a[i];
            Integer raCount = map.getOrDefault(ra, 0);
            if (raCount > 0 || map.size() < k) {
                map.put(ra, raCount+1);
                count+=1;
            } else {
                while (true) {
                    int la = a[left];
                    Integer laCount = map.get(la);
                    if (laCount == 1) {
                        map.remove(la);
                        left += 1;
                        map.put(ra, 1);
                        break;
                    } else {
                        map.put(la, laCount-1);
                        left += 1;
                        count -= 1;
                    }
                }
            }

            if (max < count) {
                max = count;
            }
        }
        out.println(max);
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
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}