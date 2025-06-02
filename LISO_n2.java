import java.util.*;
public class LISO_n2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                int notTake = dp[i+1][j+1];
                int take = 0;
                if(j== -1 || a[i]>a[j]){
                    take = 1 + dp[i+1][i+1]; //here we are using i + 1 instead if i in the place of j because the values here used are 1 based because of prev value = -1

                }

                dp[i][j+1] = Math.max(take, notTake);
            }
        }
        System.out.println(dp[0][0]);
    }
}
