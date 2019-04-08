package punch.day12.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-04 13:38
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     戳气球
 *     dp[i][j] 表示第 i 个数到第j个 的最大积分
 *     if i + 1 <= j dp[i][j] = 0
 *     dp[i][j] = dp[i][k] + dp[k][j] + nums[k]* num[i] * nums[j]
 *
 *
 * <br>
 */
public class Leetcode312_BrustBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n ][n ];
        return dp(-1,n,nums,dp);

    }

    private int getValueByRecursive(int[] nums,int index){
        if(index < 0 || index >= nums.length) return 1;
        return nums[index];
    }


    private int dp(int left,int right,int[]nums,int [][] memory) {
        if(right -left <= 1) return 0;
        if(memory[left + 1][ right -1] >0) return memory[left+1][right -1];
        int max = Integer.MIN_VALUE;
        for (int i = left + 1; i < right ; i++) {
           max = Math.max(max,
                   getValueByRecursive(nums,left) * getValueByRecursive(nums,right) * getValueByRecursive(nums,i)
           + dp(left,i,nums,memory) + dp(i,right,nums,memory));
        }
        memory[left + 1][right -1] = max;
        return max;
    }


    private int getValueByUp(int[] nums,int index){
        if(index == 0 || index > nums.length) return 1;
        return nums[index -1];
    }

    private int bottomUp(int [] nums){
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len -1 ; i >= 0  ; i--) {
            for (int j = i + 2; j <= len + 1 ; j++) {
                int max = Integer.MIN_VALUE;
                int x = getValueByUp(nums,j) * getValueByUp(nums,i);
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max,dp[i][k] + dp[k][j] + getValueByUp(nums,k) * x );
                }
                dp[i][j] = max;
            }
        }

        return dp[0][len + 1];

    }

}
