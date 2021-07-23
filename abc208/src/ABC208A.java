import java.util.Scanner;

public class ABC208A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (1 * a <= b && 6 * a >= b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
