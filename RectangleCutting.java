import java.util.*;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // rows
        int b = sc.nextInt(); // columns

        int[][] dp = new int[a + 1][b + 1];

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (i == j) {
                    dp[i][j] = 0; // already a square
                } else {
                    dp[i][j] = Integer.MAX_VALUE;

                    // vertical cuts
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[k][j] + dp[i - k][j]);
                    }

                    // horizontal cuts
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[i][j - k]);
                    }
                }
            }
        }

        System.out.println(dp[a][b]);
        sc.close();
    }
}
