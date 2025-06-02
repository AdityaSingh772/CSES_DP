//approach -> since the sum of all the choices of player 1 and player 2 can be the sum of the entire array only -> s1 + s2
//          so if I maximize the differce s1 - s2 in the range i to j and then in the last I find the value of s1 from that then it will be the ans


import java.io.*;
import java.util.*;

public class RemovalGame {
    public static void main(String[] args) throws IOException {
        // Fast input using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read number of elements
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];

        long total = 0L;

        long[][] dp = new long[n][n];

        // Read the array
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
            total += a[i];
            dp[i][i] = a[i]; //when the interval length is one then the ans is the value itself
        }

        //now to fill the dp table
        //I have to choose the left and the right pointer 
        //move the left pointer from n-1 to 0
        //move the right pointer from left +1 to n


        for(int left = n-1;left>=0;left--){
            for(int right = left + 1;right<n;right++){
                //either take the first element and take the diff from the remaining part
                //or take the last element and take the diff from the remaining part

                long choose_first = a[left] - dp[left + 1][right];
                long choose_last = a[right] - dp[left][right-1];

                dp[left][right] = Math.max(choose_first, choose_last); 

            }
        }


        //Now the result is the max in the interval of 0 to n-1

        long ans = (total + dp[0][n-1])/2;

        System.out.println(ans);
       
        
       
    }
}
