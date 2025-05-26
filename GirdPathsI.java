import java.util.*;

public class GirdPathsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int mod = 1000000007;

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            grid[i] = s.toCharArray();
        }
        if(grid[0][0] == '*') {
            System.out.println("0");
            sc.close();
            return;
        }

        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){

                if(grid[i][j] == '*'){
                    dp[i][j] = 0;
                    continue;
                }

                if(i>0) dp[i][j] = (dp[i][j] + dp[i-1][j])%mod; // for going up
                if(j>0) dp[i][j] = (dp[i][j] + dp[i][j-1])%mod; // for going left
            }
        }
        // System.out.println();
        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<n;j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n-1][n-1]);

 

        sc.close();
    }
}
