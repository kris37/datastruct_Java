package punch.day7.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-27 22:03
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     朴素dp方法
 *
 * <br>
 */
public class Leetcode152_MaximumProductSubarray {
    /**
     * dp[0][i] 以i结尾的最小乘积
     * dp[1][i] 表示以 i 为结尾的最大乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[][] dp = new int[2][nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            int v1 = i > 0 ?dp[0][i-1] * nums[i]:nums[i];
            int v2 = i>0 ? dp[1][i-1] * nums[i] :nums[i];
            dp[1][i] = Math.max(v1,Math.max(v2,nums[i]));
            dp[0][i] = Math.min(v1,Math.min(v2,nums[i]));
            max = Math.max(max,dp[1][i]);
        }
        return max;
    }

}
