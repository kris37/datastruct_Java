package punch.day2.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-07 17:52
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     查找滑动窗口最大值
 * <br>
 */
public class Leetcode239_SlidingWindowMaximum {

    /**
     * Runtime: 8 ms, faster than 89.97% of Java online submissions for Sliding Window Maximum.
     * Memory Usage: 39.8 MB, less than 86.25% of Java online submissions for Sliding Window Maximum.
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k <= 1) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];


        for (int i = 0; i <nums.length ; i++) {
            int boundary = i - k;
            Integer first = queue.peekFirst();
            if(first != null && first <= boundary){
                queue.remove();
            }
            // 从end开始踢出 nums[poplast] <= nums[i] 的索引 add(i)
            while (!queue.isEmpty()
                    && nums[queue.peekLast()] <= nums[i]){
                queue.removeLast();
            }
            queue.add(i);
            if(i >=  k -  1){
                res[i-k + 1] = nums[queue.peek()];
            }

        }

        return res;

    }

}
