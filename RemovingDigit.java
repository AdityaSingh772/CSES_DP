import java.util.*;
public class RemovingDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=9) {
            System.out.println(1);
            sc.close();
            return;
        }
        int[] dp = new int[n+1];
        for(int i = 0;i<=9;i++){
            dp[i] = 1;
        }
        for(int i = 10;i<=n;i++){
            int maxD = 0;
            int p = i;
            while(p != 0){
                int d = p%10;
                maxD = Math.max(d, maxD);
                p = p/10;
            }
            dp[i] = dp[i-maxD] + 1;
        }
        System.out.println(dp[n]);
        sc.close();

    }
}
