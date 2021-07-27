import java.util.Scanner;

public class Q01_YokanParty_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n+2];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        a[n+1] = l;

        int[] pieces = new int[n+1];
        for (int i = 0; i < a.length-1; i++) {
            pieces[i] = a[i+1] - a[i];
        }

        int upper = l;
        int lower = 0;
        while (lower + 1 < upper) {
            int threshold = (upper + lower) / 2;
            int tmpPiece = 0;
            int rest = k;
            for (int j = 0; j < pieces.length; j++) {
                tmpPiece += pieces[j];
                if (tmpPiece >= threshold && rest > 0) {
                    rest -= 1;
                    tmpPiece = 0;
                }
            }
            if (tmpPiece >= threshold) {
                lower = threshold;
            } else {
                upper = threshold;
            }
        }
        System.out.println(lower);
    }
}
