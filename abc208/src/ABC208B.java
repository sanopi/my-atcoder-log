import java.util.Scanner;

public class ABC208B {

    public static void main(String[] args) {
        int a = 1;
        int b = 1 * 2;
        int c = 1 * 2 * 3;
        int d = 1 * 2 * 3 * 4;
        int e = 1 * 2 * 3 * 4 * 5;
        int f = 1 * 2 * 3 * 4 * 5 * 6;
        int g = 1 * 2 * 3 * 4 * 5 * 6 * 7;
        int h = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8;
        int i = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9;
        int j = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10;

        int[] coins = {j, i, h, g, f, e, d, c, b, a};

        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();

        int rest = p;
        int ans = 0;
        for (int k = 0; k < 10; k++) {
            ans += rest / coins[k];
            rest = rest % coins[k];
        }

        System.out.println(ans);
    }
}
