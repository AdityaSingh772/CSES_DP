import java.util.*;

public class NoConsecutiveSameDigit {
    private String num;
    private long[][][][] dp; // Use long
    
    
    private long solve(int pos, int tight, int started, int lastDigit) {
        if (pos == num.length()) {
            return 1L;
        }
        
        if (dp[pos][tight][started][lastDigit] != -1) {
            return dp[pos][tight][started][lastDigit];
        }
        
        int limit = (tight == 1) ? (num.charAt(pos) - '0') : 9;
        long result = 0;
        
        for (int digit = 0; digit <= limit; digit++) {
            if (started == 1 && digit == lastDigit) {
                continue;
            }
            
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newStarted = (started == 1 || digit > 0) ? 1 : 0;
            int newLast = (newStarted == 1) ? digit : lastDigit;
            
            result += solve(pos + 1, newTight, newStarted, newLast);
        }
        
        dp[pos][tight][started][lastDigit] = result;
        return result;
    }

    public long countNoConsecutive(long n) {
        if (n < 0) return 0;
        
        this.num = Long.toString(n);
        this.dp = new long[num.length() + 1][2][2][11];
        for (int i = 0; i <= num.length(); i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        
        return solve(0, 1, 0, 10);
    }
    
    public static void main(String[] args) {
        NoConsecutiveSameDigit solver = new NoConsecutiveSameDigit();
        Scanner sc = new Scanner(System.in);
        long L = sc.nextLong();
        long R = sc.nextLong();
        long result = solver.countNoConsecutive(R) - solver.countNoConsecutive(L - 1);
        System.out.println(result);
        sc.close();
    }
}
