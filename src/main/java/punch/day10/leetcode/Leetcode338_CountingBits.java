package punch.day10.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-04-01 17:01
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *  Given a non negative integer number num. >= 0
 *  For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 *  这里采用类似于找规律的方法
 *  对于 n if(n 是 2的 次幂) dp[n] = 1;
 *   否则 找出 <= n 的 一个 dp[n] = dp[n- 2^x] + 1;
 * <br>
 */
public class Leetcode338_CountingBits {

    /**
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Counting Bits.
     * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Counting Bits.
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        int pre = 0;
        int next = 1;
        for (int i = 1; i <= num ; i++) {
            if(i == next){
                dp[i] = 1;
                pre = next;
                next  = (next << 1);
            }else {
                dp[i] = dp[i - pre] +1;
            }
        }
        return dp;

    }
}
