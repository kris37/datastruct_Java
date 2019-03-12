package punch.day1.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-06 10:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     第一个未出现的最小正数
 *     你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *     思路 将 v = num[i] 将 v 放置在 swap(num[v-1],num[i]) 一直走下去
 *     最后再for 找到第一个 num[i] != i+1 的 return i+1
 *     极端情况是 1:n 如果不将 n 放置在 n-1 的位置上会丢失数据
 *
 * <br>
 */
public class Leetcode41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] < 1|| nums[i]>nums.length) continue;
            swap(nums,i,nums[i]-1);
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] -1 ] ){
                swap(nums,i,nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return nums.length +1;
    }

    private void swap(int [] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
