import java.io.PrintWriter;
import java.util.Scanner;

public class AGC050A {

    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).next());
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= n; i++) {
            out.println((i*2%n+1) + " " + ((i*2+1)%n+1));
        }
        out.flush();
    }
}
