package punch.day14.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     循环有序 array search
 *
 *
 * <br>
 */
public class Leetcode33_SearchRotatedSortedArray {
    /**
     *  important
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0,j = nums.length -1;
        while (i <= j){
            int mid = i+ ((j-i)>>1);
            if(nums[mid] == target) return mid;
            if(nums[i] <= nums[mid]){
                if( nums[i] > target || nums[mid] < target){
                    i = mid +1;
                }else {
                    j = mid - 1;
                }
            }else {
                // 存在断点
                if( nums[i] <= target || nums[mid] > target){
                    j = mid -1;
                }else {
                    i = mid + 1;
                }
            }
        }

        return -1;
    }

    // 开平方

    // 二分法
    public int mySqrt(int x) {
        double left = 0;
        double right = x;
        for (;;) {
            double mid = (left + right) / 2;
            double muti = mid * mid;
            if (Math.abs(muti - x) < 0.01) {
                return (int) Math.floor(mid);
            } else if (muti > x) {
                right = mid;
            }else {
                left = mid;
            }
        }
    }

    /**
     * 牛顿法
     * X(n+1) = X(n)/2 + k/2X(n)
     * @param x
     * @return
     */
    public int ISqrt(int x){
        double cur = x;
        double pre = 0;
        while (Math.abs(cur - pre) > 1){
            pre = cur;
            cur = cur/2 + (x/2)/cur;
        }
        return (int) Math.floor(cur);

    }

}
