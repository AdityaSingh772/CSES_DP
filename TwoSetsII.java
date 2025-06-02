import java.util.*;

public class TwoSetsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mod = 1000000007;
        double sum = n * (n + 1) / 2.0;
        if (sum % 2.0 != 0.0) {
            System.out.println("0");
            return;
        }

        int s = n * (n + 1) / 4;

        int[][] dp = new int[n + 1][s + 1];

        dp[n][0] = 1; //one way to make sum 0 with no elements


        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j <= s; j++) {
                int notTake = dp[i+1][j];

                int take = 0;
                if(j>=i+1){
                    take = dp[i+1][j-i-1];
                }

                dp[i][j] = (take + notTake)%mod;
            }
        }

        long result = (dp[0][s] * 1L * modInverse(2, mod)) % mod;
        System.out.println(result);

        sc.close();
    }

    public static int modInverse(int a, int mod) {
        return pow(a, mod - 2, mod);
    }

    public static int pow(int a, int b, int mod) {
        long res = 1, base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            b >>= 1;
        }
        return (int) res;
    }
}
