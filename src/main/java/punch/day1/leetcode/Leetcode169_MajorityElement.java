package punch.day1.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-06 09:43
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     此问题是一个摩尔投票法
 *     找出某一元素出现频次 超过 > n/2 (必须存在的情况下)
 *     1. 思路就是 任意元素 两两组合 消消乐 剩余的肯定是 超过 1/2 的element
 * <br>
 */
public class Leetcode169_MajorityElement {
    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Majority Element.
     * Memory Usage: 40.9 MB, less than 39.68% of Java online submissions for Majority Element.
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int pre = 0;
        for (int num : nums) {
            if(count == 0){
                pre =num;
                count++;
            }else {
                count = num == pre?count +1:count -1;
            }
        }
        return pre;
    }
}
