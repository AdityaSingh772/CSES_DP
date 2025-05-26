// import java.util.*;
// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int x = sc.nextInt();

//         int[] coins = new int[n];
//         for(int i = 0;i<n;i++){
//             coins[i] = sc.nextInt();

//         }

//         Arrays.sort(coins);

//         int[][] dp = new int[n][x+1];

//         //base case 1 : only 1 way to make the sum 0
//         for(int i = 0;i<n;i++){
//             dp[i][0] = 1;
//         }
        
//         //base case 2 : when the sum is varying but i have to use only coins[0]
//         for(int t = 0;t<=x;t++){
//             if(t%coins[0] == 0){
//                 dp[0][t] = 1;
//             }
//             else 
//                 dp[0][t] = 0;
//         }

//         //parameters define

//         for(int i = 1;i<n;i++){
//             for(int j = 0;j<=x;j++){
//                 //copy the recursion
//                 int take = 0;
//                 if(j>=coins[i]){
//                     take = dp[i][j-coins[i]];
//                 }
                

//                 int notTake = dp[i-1][j];

//                 dp[i][j] = (take + notTake)%1000000007;
//             }
//         }

//         // System.out.println();
//         // for(int i =0;i<n;i++){
//         //     for(int j = 0;j<=x;j++){
//         //         System.out.print(dp[i][j] + " ");

//         //     }
//         //     System.out.println();
//         // }

//         int ans = dp[n-1][x];
//         System.out.println(ans);
//         sc.close();
//     }   
    
// }

//here in this question , we need to choose the coins in order only , and not randomly

import java.util.*;
public class CoinCominationsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0;i<n;i++){
            coins[i] = sc.nextInt();

        }

        Arrays.sort(coins);


        int[] prev = new int[x+1];
        int[] cur = new int[x+1];

        // int[][] dp = new int[n][x+1];

        //base case 1 : only 1 way to make the sum 0
        for(int i = 0;i<n;i++){
            prev[0] = 1;
        }
        
        //base case 2 : when the sum is varying but i have to use only coins[0]
        for(int t = 0;t<=x;t++){
            if(t%coins[0] == 0){
                prev[t] = 1;
            }
            else 
               prev[t] = 0;
        }

        //parameters define

        for(int i = 1;i<n;i++){
            for(int j = 0;j<=x;j++){
                //copy the recursion
                int take = 0;
                if(j>=coins[i]){
                    take = cur[j-coins[i]];
                }
                

                int notTake = prev[j];

                cur[j] = (take + notTake)%1000000007;
            }
            prev = cur;
        }

        // System.out.println();
        // for(int i =0;i<n;i++){
        //     for(int j = 0;j<=x;j++){
        //         System.out.print(dp[i][j] + " ");

        //     }
        //     System.out.println();
        // }

        int ans = prev[x];
        System.out.println(ans);
        sc.close();
    }   
    
}
