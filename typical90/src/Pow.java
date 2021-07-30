public class Pow {

    public static void main(String[] args) {
        int a=9;
        int n=10000000;
        int mod=1000000007;
        System.out.println(modPow(a, n, mod));
    }

    private static int modPow(int a, int n, int mod) {
        int[] exps = new int[32];
        exps[0] = a;
        int res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
                res = (res * exps[i]) % mod;
            }
            exps[i+1] = (exps[i] * exps[i]) % mod;
            i += 1;
        }

        return res;
    }
}
