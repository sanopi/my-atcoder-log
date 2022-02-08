import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC113C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        City[] cities = new City[m];
        for (int i = 0; i < m; i++) {
            cities[i] = new City(i+1, nextInt(), nextInt());
        }
        Arrays.stream(cities)
            .sorted(Comparator.comparing(city -> city.y))
            .collect(Collectors.groupingBy(city -> city.p))
            .forEach((key, pCities) -> {
                for (int i = 0; i < pCities.size(); i++) {
                    pCities.get(i).resolveId(i + 1);
                }
            });
        for (City city : cities) {
            out.println(city.id);
        }
        out.flush();
    }

    private static class City {
        int i;
        int p;
        int y;
        String id;
        public City(int i, int p, int y) {
            this.i = i;
            this.p = p;
            this.y = y;
        }
        void resolveId(int suf) {
            String sp = String.valueOf(p);
            String ssuf = String.valueOf(suf);
            id = "0".repeat(6-sp.length())+sp+"0".repeat(6-ssuf.length())+ssuf;
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