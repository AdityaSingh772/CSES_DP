import java.util.*;
class minimize_coin{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        int ans = -1;
        if(ans>=(int)1e9){
            System.out.println("-1");
            sc.close();
            return;
        }
        System.out.println(go(coins.length-1, coins, x));
        sc.close();

    }
    public static int go(int i, int[] coins, int x){
        if(i == 0){
            if(x%coins[0] == 0){
                return x/coins[0];
            }
            else{
                return (int)1e9;
            }
        }

        //take 
        int take = Integer.MAX_VALUE;
        if(x >= coins[i]){
            take = 1+go(i, coins, x - coins[i]);
        }

        //not take
        int notTake = go(i-1, coins, x);

        return Math.min(take, notTake);
    }
}