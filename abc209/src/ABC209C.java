import java.util.Arrays;
import java.util.Scanner;

public class ABC209C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextLong();
        }

        Arrays.sort(c);

        long ans = 1;

        for (int i = 0; i < n; i++) {
            ans = ans * Math.max(c[i] - i, 0);
            ans = ans % 1000000007;
        }

        System.out.println(ans);
    }
}
