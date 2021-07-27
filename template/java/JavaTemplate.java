import java.io.PrintWriter;
import java.util.Scanner;

public class JavaTemplate {

    public static void main(String[] args) {
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static int nextInt() {
        return Integer.parseInt(scanner.next());
    }
    static long nextLong() {
        return Long.parseLong(scanner.next());
    }
}