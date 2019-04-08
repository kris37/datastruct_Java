package punch.day12.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode300_LIS {
    public int lengthOfLIS(int[] nums) {
        return dpFunction(nums);
    }

    //dp function
    public int dpFunction(int[]nums) {
        // dp[i] 截止至i且包含i的最长上升长度
        if(nums.length <= 1) return nums.length;
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i],dp[j] +1) ;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
