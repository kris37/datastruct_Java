package punch.day10.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-04-01 16:53
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     Given an integer, write a function to determine if it is a power of two.
 *     给定一个数字，判断是否是2的 n 次方
 *     问题转变为 除了符号位 ，是否只有一个1
 *     转变为 去掉 最后一个 1 是否为 0
 *
 *
 * <br>
 */
public class Leetcode231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }
}
