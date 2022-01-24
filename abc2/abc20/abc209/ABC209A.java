import java.util.Scanner;

public class ABC209A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println(0);
        } else {
            System.out.println(b - a + 1);
        }
    }
}
