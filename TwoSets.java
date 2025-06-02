import java.util.*;
public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
     

        int mod = 1000000007;
        double sum = n*(n+1)/2.0;
        if(sum%2.0 != 0.0){
            System.out.println("0");
            return;
        }

        int[] a = new int[n];
        for(int i = 1;i<=n;i++){
            a[i-1] = i;
        }
        int s = n*(n+1)/4;



        
        System.out.println(go(0, a, s)/2);
    }
    public static int go(int i, int[] a, int sum){
        if(sum == 0) return 1;
        if(i >= a.length || sum < 0) return 0;
        
        //take 
        int take = go(i + 1, a, sum-a[i]);

        //not take
        int notTake = 0 + go(i+1, a, sum);

        return take + notTake;

    }
}
