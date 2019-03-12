package punch.day3.task3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-05 13:55
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     1. 有序数组二分查找
 *     2. 模糊二分查找查找算法
 *     3. find peak
 *
 * <br>
 */
public class BinarySearch {


    /**
     *
     * @param nums
     * @param tar
     * @return 返回查找数值的索引
     * -1  不存在
     */
    public static int binaryFinder(int [] nums, int tar){
        int i  = 0,j = nums.length -1;
        if(tar > nums[j] || tar < nums[i]) return -1;
        while (i < j){
            int mid = (i+j) >> 1;
            if(nums[mid] == tar) return mid;
            if(nums[mid] > tar){
                j = mid -1;
            }else {
                i = mid + 1;
            }
        }
        return nums[i] == tar? i: -1;
    }

    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binaryFinder(nums,1));
        System.out.println(-10 >> 1);
    }
}
