import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] num1 = new int[n];
        int[] num2 = new int[m];

        for(int i = 0;i<n;i++){
            num1[i] = sc.nextInt();

        }
        for(int j = 0;j<m;j++){
            num2[j] = sc.nextInt();

        }

        int[][] dp = new int[n+1][m+1];

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(num1[i-1] == num2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);

        int max = 0;
        List<Integer> l = new ArrayList<>();

        int i = n, j=m;

        while (i > 0 && j > 0) {
            //if the numbers match , go diagonally upward
            if (num1[i - 1] == num2[j - 1]) {
                l.add(num1[i - 1]);
                i--;
                j--;
            } 
            
            // if they dont match then go to the higher of the two values of the upward or leftward
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        for(int k= l.size()-1;k>=0;k--){
            System.out.print(l.get(k) + " ");
        }
        

    }
}
