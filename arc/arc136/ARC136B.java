import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC136B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);

        int[] count = new int[5001];
        boolean d = false;
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
            if (count[a[i]]>=2) {
                d = true;
                break;
            }
        }

        sort(a);
        sort(b);
        int[] copyA = Arrays.copyOf(a, a.length);
        int tmp = copyA[0];
        copyA[0] = copyA[1];
        copyA[1] = tmp;

        out.println(Arrays.equals(a, b) || (d && Arrays.equals(copyA, b))?"Yes":"No");
        out.flush();
    }

    private static void sort(int[] array) {
        for (int j = 0; j < array.length-2; j++) {
            for (int i = 0; i < array.length-2; i++) {
                int a0 = array[i];
                int a1 = array[i+1];
                int a2 = array[i+2];
                if (a0 == a1) {
                    array[i] = Math.min(a0, a2);
                    array[i+2] = Math.max(a0, a2);
                    array[i+1] = a1;
                } else if (a0 == a2) {
                    array[i] = Math.min(a0, a1);
                    array[i+2] = Math.max(a0, a1);
                    array[i+1] = a2;
                } else if (a1 == a2) {
                    array[i] = Math.min(a0, a1);
                    array[i+2] = Math.max(a0, a1);
                    array[i+1] = a2;
                } else {
                    while (!(a0<=a2 && a1<=a2)) {
                        array[i] = a2;
                        array[i+1] = a0;
                        array[i+2] = a1;
                        a0 = array[i];
                        a1 = array[i+1];
                        a2 = array[i+2];
                    }
                }
            }
        }
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