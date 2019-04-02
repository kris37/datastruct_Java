package punch.day10.leetcode;

/**
 * Created with IntelliJ IDEA.
 * @version punch
 * Date: 2019-04-01 16:37
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *  无符号整数中 1 的个数 (都是正数，最高位标志位)
 * 两种方法
 * <br>
 */
public class Leetcode191_NumberOf1Bits {

    /**
     * 一直去掉末尾出现的第一个1
     * 直到为 0
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }


    /**
     * 1 % 2 是否==1
     * 2 n >>> 1 右移1位
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            if((n&1) == 1){
                //奇数
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }



}
