import java.util.*;
public class minimize_coins{
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


        
        for(int t = 0;t<=x;t++){
            if(t % coins[0] == 0){
               prev[t] = t/coins[0];
            }
            else prev[t] = (int)1e9;
        }

        for(int ind = 1;ind<n;ind++){
            for(int t = 0;t<=x;t++){


                int take = Integer.MAX_VALUE;
                if(t >= coins[ind]){
                take = 1+cur[t - coins[ind]];
                }

                //not take
                int notTake = prev[t];

                cur[t] = Math.min(take, notTake);
            }
            prev = cur;
        }
        int ans = prev[x];
        if(ans>=(int)1e9){
            System.out.println("-1");
            sc.close();
            return;
        }
        System.out.println(ans);
        sc.close();
        
    }
    
}
