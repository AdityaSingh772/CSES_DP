// in this question , even using scanner is causing the higher time so avoid using it, instead use buffer reader

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MOD = 1_000_000_007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int value = 1; value <= x; value++) {
            for (int i = 0; i < n; i++) {
                if (value - coins[i] >= 0) {
                    dp[value] = (dp[value] + dp[value - coins[i]]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}
