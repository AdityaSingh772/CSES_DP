import java.util.Scanner;
public class BookShop {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        int[] s = new int[n];
        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        
        // int[][] dp = new int[n][x+1];
        //base case : when there are zero books then the pages will be zero
        //            so dp[0][x] = 0

        int[] prev = new int[x+1];
       
        for(int j = 0;j<=x;j++){
            if(h[0] <= j){
                prev[j] = s[0];
            }
        }

        //parameters i : starts from 1 and j(denoting x) start from 
        for(int i = 1;i<n;i++){
            int[] cur = new int[x + 1];
            for(int j = 0;j<=x;j++){
                //copy the recursion

                //take
                int take = Integer.MIN_VALUE;
                if(h[i]<=j){
                    take = s[i] + prev[j-h[i]]; //adding s[i] in all the recursion call is very impportant
                }

                //notTake
                int notTake = prev[j];

                cur[j] = Math.max(take, notTake);
            }
            prev = cur;
        }

        System.out.println(prev[x]);
        sc.close();


    }
    
   
}
