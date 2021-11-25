import java.util.Scanner;

public class ABC207B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if (b >= c * d) {
            System.out.println(-1);
            return;
        }

        int i = a / (c * d - b);
        int i2 = a % (c * d - b) > 0 ? 1 : 0;
        System.out.println(i + i2);

    }
}
