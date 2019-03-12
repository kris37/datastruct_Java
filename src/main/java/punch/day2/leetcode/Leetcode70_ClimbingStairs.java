package punch.day2.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-08 08:50
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     爬楼梯 每次可以爬 1 or 2 步
 *     n 阶可以有多少种爬法
 *     走 n 阶 最后一步 可以停留在 n-1 or n-2 台阶上 所以f(n) = f(n-1) + f(n-2)
 * <br>
 */
public class Leetcode70_ClimbingStairs {
    private static final int ONE = 1;
    private static final int TWO = 2;

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 36.5 MB, less than 8.97% of Java online submissions for Climbing Stairs.
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n <= TWO) return n;
        return f(n,1,2);
    }

    private int f(int n ,int pp,int p){
        if(n == 0) return  p;
        return f(n-1,p,pp+p);
    }
}
