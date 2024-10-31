import java.util.Arrays;
import java.util.List;

class Solution 
{
    private static final long INF = (long) 1e15;
    
    public long minimumTotalDistance(List<Integer> robotList, int[][] factory) 
    {
        // Convert List<Integer> to int[] for processing
        int[] robot = robotList.stream().mapToInt(Integer::intValue).toArray();
        int n = robot.length, N = factory.length;
        
        
        Arrays.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
     
        long[][][] dp = new long[101][101][101];
        for (long[][] row : dp)
            for (long[] col : row)
                Arrays.fill(col, INF);
        
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                int xR = robot[i], xF = factory[j][0], cap = factory[j][1];
                
                
                long nottake = (j == 0) ? INF : dp[i][j - 1][0];
                dp[i][j][cap] = nottake;
                
                for (int k = 0; k < cap; k++) 
                {
                   
                    long take = (i == 0) ? Math.abs(xR - xF) : Math.abs(xR - xF) + dp[i - 1][j][k + 1];
                    dp[i][j][k] = Math.min(take, nottake);
                }
            }
        }
        
        return dp[n - 1][N - 1][0];
    }
}
