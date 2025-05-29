import java.util.*;
class EditDistance{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if(s1.equals(s2)){
            System.out.println("0");
            sc.close();
            return;
        }

        char[] st1 = s1.toCharArray();
        char[] st2 = s2.toCharArray();

        int n= st1.length;
        int m = st2.length;

        int[][] dp = new int[n+1][m+1];

        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=m;j++){
                dp[0][j] = j;
                dp[i][0] = i;

            }
        }


        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){

                //same characters case
                
                if(st1[i-1] == st2[j-1]){
                    //skip
                    dp[i][j] = 0+ dp[i-1][j-1];
                }
                

                //notsame characters that means there is some kind of change int he string 
                //so any one of the three cases will be considered for the take and not take

                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    //means either insert , delete or replace
                }

            }
        }

        // for(int i = 0;i<=n;i++){
        //     for(int j = 0;j<=m;j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[n][m]); 
        sc.close();

    }
}