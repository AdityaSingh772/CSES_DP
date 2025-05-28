import java.util.Scanner;
public class ArrayDesc_good_prob {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int mod = 1000000007;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[n][m+1];

        if(a[0] != 0){
            dp[0][a[0]] = 1;
        }
        else {
            for(int i = 1;i<=m;i++){
                dp[0][i] = 1;
            }
        }

        for(int i = 1;i<n;i++){
            if(a[i] == 0){
                for(int j = 1;j<=m;j++){
                    if(j-1>=1){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-1])%mod;
                    }
                    dp[i][j] = (dp[i][j] + dp[i-1][j])%mod;
                    if(j+1<=m){
                        dp[i][j] = (dp[i][j] + dp[i-1][j+1])%mod;
                    }
                }
            }
            else{
                if(a[i] - 1>= 1){
                    dp[i][a[i]] = (dp[i][a[i]] + dp[i-1][a[i]-1])%mod;
                }
                dp[i][a[i]] = (dp[i][a[i]] + dp[i-1][a[i]])%mod;
                if(a[i] + 1 <= m){
                    dp[i][a[i]] = (dp[i][a[i]] + dp[i-1][a[i] + 1])%mod;
                }

            }
        }
        int total = 0;
        for(int i = 1;i<=m;i++){
            total = (total + dp[n-1][i])%mod;
        }

        System.out.println(total);
        sc.close();
        

    }
    
   
}
