package punch.day15.task;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-13 19:39
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class HeapSort {

    public static void heapSort(int [] nums){

    }

    /**
     *  构建堆
     */
    public static void buildHeap(int [] nums){
        for (int i = (nums.length >> 1) -1 ; i >=0 ; i--) {
            adjHeap(nums,i);
        }
    }

    private static void swap(int[] nums,int i ,int j){
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void adjHeap(int []nums,int cur){
        int maxIndex;
        while (cur < nums.length){
            maxIndex = (cur << 1) + 1;
            // select max index in (leftChild,rightChild,cur)
            // is cur == cur return ; else swap(cur,max)
            if(maxIndex >= nums.length) return;
            maxIndex = maxIndex + 1 < nums.length && nums[maxIndex +1] > nums[maxIndex]? maxIndex + 1:maxIndex;
            maxIndex = nums[cur] >= nums[maxIndex]?cur:maxIndex;
            if(cur == maxIndex) return;
            swap(nums,cur,maxIndex);
            cur = maxIndex;
        }
    }

    public static void main(String[] args){
        int[] nums = {7,5,19,8,4,1,20,13,16};
        buildHeap(nums);
        for (int num : nums) {
            System.out.print(num + " -> ");
        }
    }
}
