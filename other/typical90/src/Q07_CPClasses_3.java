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

            int position = Arrays.binarySearch(classes, student);
            if (position < 0) {
                position = -(position + 1);
            }
            int diff1 = Integer.MAX_VALUE;
            int diff2 = Integer.MAX_VALUE;
            if (position < n) diff1 = Math.abs(classes[position] - student);
            if (position > 0) diff2= Math.abs(classes[position-1] - student);
            out.println(Math.min(diff1, diff2));
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