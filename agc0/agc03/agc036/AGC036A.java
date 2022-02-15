import java.io.PrintWriter;
import java.util.Scanner;

public class AGC036A {

    public static void main(String[] args) {
        long s = nextLong();

        // {1000000000から引くとsの下9桁になる数} を求める
        // 全部ゼロの場合はゼロにしたいので、最後にもう一度あまりをとる
        long a = (1000000000-s%1000000000)%1000000000;
        // sの下9桁より大きい桁+1を求める。
        // 下9桁（a）が0の場合は+1しない。
        long b = (a+s)/1000000000;


        out.println("0 0 1000000000 1 " + a + " "+ b);

        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}