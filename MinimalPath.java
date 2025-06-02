import java.util.*;
import java.io.*;

public class MinimalPath {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            grid[i] = line.toCharArray();
        }
        
        String result = findMinimalPath(grid, n);
        System.out.println(result);
        br.close();
    }
    
    public static String findMinimalPath(char[][] grid, int n) {
        // dp[i][j] stores the lexicographically minimal string to reach (i,j)
        String[][] dp = new String[n][n];
        
        // Initialize the starting position
        dp[0][0] = String.valueOf(grid[0][0]);
        
        // Fill first row (can only come from left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        
        // Fill first column (can only come from top)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        // Fill the rest of the grid
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                String fromTop = dp[i-1][j] + grid[i][j];
                String fromLeft = dp[i][j-1] + grid[i][j];
                
                // Choose lexicographically smaller string
                if (fromTop.compareTo(fromLeft) <= 0) {
                    dp[i][j] = fromTop;
                } else {
                    dp[i][j] = fromLeft;
                }
            }
        }
        
        return dp[n-1][n-1];
    }
}

// Alternative optimized version for better space complexity
class OptimizedMinimalPath {
    
    public static String findMinimalPathOptimized(char[][] grid, int n) {
        // Only keep current and previous row since we only need them
        String[] prev = new String[n];
        String[] curr = new String[n];
        
        // Initialize first row
        prev[0] = String.valueOf(grid[0][0]);
        for (int j = 1; j < n; j++) {
            prev[j] = prev[j-1] + grid[0][j];
        }
        
        // Process each subsequent row
        for (int i = 1; i < n; i++) {
            curr[0] = prev[0] + grid[i][0]; // First column: only from top
            
            for (int j = 1; j < n; j++) {
                String fromTop = prev[j] + grid[i][j];
                String fromLeft = curr[j-1] + grid[i][j];
                
                if (fromTop.compareTo(fromLeft) <= 0) {
                    curr[j] = fromTop;
                } else {
                    curr[j] = fromLeft;
                }
            }
            
            // Swap arrays for next iteration
            String[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n-1];
    }
}

// Test class to verify the solution
class TestMinimalPath {
    public static void testSolution() {
        // Test case from the problem
        char[][] grid = {
            {'A', 'A', 'C', 'A'},
            {'B', 'A', 'B', 'C'},
            {'A', 'B', 'D', 'A'},
            {'A', 'A', 'C', 'A'}
        };
        
        String result = MinimalPath.findMinimalPath(grid, 4);
        System.out.println("Expected: AAABACA");
        System.out.println("Got: " + result);
        System.out.println("Test " + (result.equals("AAABACA") ? "PASSED" : "FAILED"));
        
        // Test small case
        char[][] smallGrid = {
            {'A', 'B'},
            {'C', 'A'}
        };
        
        String smallResult = MinimalPath.findMinimalPath(smallGrid, 2);
        System.out.println("\nSmall test - Expected: ABA");
        System.out.println("Got: " + smallResult);
    }
    
    public static void main(String[] args) {
        testSolution();
    }
}