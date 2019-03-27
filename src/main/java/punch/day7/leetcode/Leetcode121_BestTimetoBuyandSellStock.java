package punch.day7.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-26 10:22
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     最佳买卖股票时机
 *     只允许买卖一次
 *     朴素dp方法
 * <br>
 *
 */
public class Leetcode121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if(prices.length <=1) return 0;
        int min = Integer.MAX_VALUE,max = 0;
        for (int price : prices) {
            min = min > price?price:min;
            max = Math.max(max,price - min);
        }
        return max;
    }
}
