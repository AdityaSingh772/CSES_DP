// import java.util.*;
// class Main{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] a = new int[n];
//         for(int i = 0;i<n;i++){
//             a[i] = sc.nextInt();
//         }
        
//         Arrays.sort(a);

//         int max = n*a[n-1];

//         Integer[][] dp = new Integer[n+1][max + 2];

        
//         //take , not take starting from all the numbers


//         Set<Integer> ans = new HashSet<>();
//         // for(int i = 0;i<n;i++){
//         //     // ans.add(a[i]);
//             go(0, a, ans, 0, dp);
//         // }
//         List<Integer> res = new ArrayList<>(ans);

//         Collections.sort(res);

//         System.out.println(res.size());
//         for(int i : res){
//             System.out.print(i + " ");
//         }

//         sc.close();

//     }
//     public static void go(int i , int[] a, Set<Integer> ans, int curSum, Integer[][] dp){
//         if(i==a.length-1) {
        
//             ans.add(curSum + a[i]);
//             return;
//         }
//         if(i>=a.length) return;
//         if(dp[i][curSum] != null){
//             return;
//         }

//         //take 
//         ans.add(curSum + a[i]);
//         go(i+1, a, ans, curSum+a[i], dp);

//         //not take
//         // ans.remove(curSum + a[i]);
//         go(i+1, a,ans,  curSum, dp);

//         dp[i][curSum] = 1;
//     }
// }



import java.util.*;

class MoneySums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
       
        Arrays.sort(a);
        
        // Use boolean DP to track possible sums
        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }
        
        boolean[] dp = new boolean[totalSum + 1];
        dp[0] = true; // Empty subset sum
        
        // For each element in array
        for (int i = 0; i < n; i++) {
            // Traverse from right to left to avoid using updated values
            for (int sum = totalSum; sum >= a[i]; sum--) {
                if (dp[sum - a[i]]) {
                    dp[sum] = true;
                }
            }
        }
        
        // Collect all possible sums
        List<Integer> ans = new ArrayList<>();
        for (int i = a[0]; i <= totalSum; i++) {
            if (dp[i]) {
                ans.add(i);
            }
        }
        
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int sum : ans) {
            System.out.print(sum + " ");
        }
        sc.close();
    }
}