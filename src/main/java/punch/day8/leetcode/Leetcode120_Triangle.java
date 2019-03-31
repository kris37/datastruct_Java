package punch.day8.leetcode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-29 20:30
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     三角矩阵 最短路径
 *     要求最多使用o(N)的额外空间
 * <br>
 */
public class Leetcode120_Triangle {
    /**
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        List<Integer> nList = triangle.get(triangle.size() - 1);
        int n = nList.size();
        int[] dp = new int[n];
        //自底向上
        for (int i = 0; i < n; i++) {
            dp[i] = nList.get(i);
        }
        for (int i = n-2; i >= 0  ; i--) {
            List<Integer> list = triangle.get(i);
            for (int i1 = 0; i1 < list.size(); i1++) {
                dp[i1] = Math.min(dp[i1],dp[i1+1]) + list.get(i1);
            }
        }
        return dp[0];
    }

}
