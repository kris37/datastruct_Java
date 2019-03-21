package punch.day7.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-20 23:24
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode300_LongestIncreasingSubsequence {

    /**
     * 最长递增子序列
     * 0-1背包问题
     * time:O(n^2)
     * Runtime: 7 ms, faster than 68.57% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 34.2 MB, less than 93.93% of Java online submissions for Longest Increasing Subsequence.
     * Next challenges:
     * @param nums
     * @return
     */
    public  int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i ; j++) {
                if(nums[j] < nums[i]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+1;
        }
        int m = 0;
        for (int i : dp) {
            m = Math.max(m,i);
        }
        return m;

    }



}
