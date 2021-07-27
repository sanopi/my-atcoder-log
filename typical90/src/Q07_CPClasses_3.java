import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q07_CPClasses_3 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) { classes[i] = nextInt(); }
        int q = nextInt();
        int[] students = new int[q];
        for (int i = 0; i < q; i++) { students[i] = nextInt(); }

        Arrays.sort(classes);

        for (int i = 0; i < q; i++) {
            int student = students[i];
            // 自分のレートより大きければOKとする
            int ok = n-1;
            int ng = -1;
            while (ok-ng!=1) {
                int checkPoint = (ok + ng) / 2;
                if (classes[checkPoint] - student > 0) {
                    ok = checkPoint;
                } else {
                    ng = checkPoint;
                }
            }
            if (ok == 0) {
                out.println(Math.abs(classes[ok] - student));
            } else {
                out.println(Math.min(Math.abs(classes[ok] - student), Math.abs(classes[ok-1] - student)));
            }
        }
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