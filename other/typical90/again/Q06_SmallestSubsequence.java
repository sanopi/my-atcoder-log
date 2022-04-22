package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q06_SmallestSubsequence {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        String s = next();
        int[][] letterIndex = new int[26][n+1];
        for (int i = 0; i < 26; i++) {
            letterIndex[i][n] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == (char)(j+'a')) letterIndex[j][i] = i;
                else letterIndex[j][i] = letterIndex[j][i+1];
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int letterInt = 0;
        while (k>0) {
            int firstIndex = letterIndex[letterInt][index];
            if (n-firstIndex >= k) {
                index = firstIndex+1;
                sb.append((char)(letterInt+'a'));
                k--;
                letterInt=0;
            } else {
                letterInt++;
            }
        }
        out.println(sb);
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