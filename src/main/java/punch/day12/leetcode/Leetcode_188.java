package punch.day12.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-04 16:23
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     股票买卖系列问题
 *     通用求解
 *     注意 K 过大无用 badcase问题
 *
 * <br>
 */
public class Leetcode_188 {

    public int maxProfit(int k, int[] prices) {
        // 记录子问题
        // if K >= (prices.length >> 1)  退化为 无限买卖
        if(k <= 0 || prices.length <= 1) return 0;
        if(k >= (prices.length >> 1)  ) return quick(prices);
        int[][][] memory = new int[2][k][prices.length];
        for (int[][] ints : memory) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return dp(0,k,false ,prices,memory);
    }


    /**
     *
     * @return
     */
    private int dp(int index,int k,boolean holder,int[] prices,int[][][] memory){
        if(k == 0 || index >= prices.length) return 0;
        if(memory[holder ? 0:1][k-1][index] >=0 ) return memory[holder ? 0:1][k-1][index];
        int max = 0;
        if(holder){
            // 卖不卖
            max = Math.max(dp(index+1,k-1,false,prices,memory)+prices[index],
                    dp(index+1,k,true,prices,memory));
        }else {
            // 买不买
            max = Math.max(dp(index+1,k,true,prices,memory)-prices[index]
                    ,dp(index+1,k,false,prices,memory));
        }

        memory[holder?0:1][k-1][index] = max;
        return max;
    }

    private int quick(int [] prices){
        int profix = 0;
        for (int i = 1; i <prices.length ; i++) {
            int delta = prices[i] - prices[i-1];
            profix += delta>0?delta:0;
        }
        return profix;
    }


    private int trans(int [] prices,int k){
        // 状态转移方程
        int[][][] dp = new int[k+1][prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[0][i][1] = -prices[i];
        }
        dp[1][0][1] = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                dp[i][j][0] = Math.max(dp[i][j-1][0],dp[i-1][j-1][1] + prices[j]);
                dp[i][j][1] = Math.max(dp[i][j-1][0] - prices[j],dp[i][j-1][1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k ; i++) {
            max = Math.max(dp[i][prices.length -1][0],max);
        }
        return max;

    }

}
