package punch.day3.task3;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-05 13:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *  1. quick sort
 *  2.insert sort
 *  3.bubble sort
 *  4. select sort
 *  5. heap sort
 *  6. 归并排序
 *  7. 第 K 大元素 heap sort
 * <br>
 */
public class GroupSort {

    /**
     * important
     * @param nums
     */
    public static void quickSort(int [] nums){
        quickSort(nums,0,nums.length - 1);
    }
    private  static void  quickSort(int [] nums,int left,int right){
        if(left >= right) return;
        int i = left,j =right;
        int cmp = nums[j];
        while (i < j){
            while (i < j && cmp > nums[i]){
                i ++;
            }
            // 这里 要么 i == j or nums[i] >= nums[j]
            nums[j] = nums[i];
            if (i > j) j--;
            // 换方向
            while (i < j && cmp <= nums[j]){
                j --;
            }
            nums[i] = nums[j];
            if(i > j) i++;
        }
        nums[i] = cmp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    /**
     *  cur
     *  for i = cur swap (i,i-1) until [i-1] < [i]
     * @param nums
     */
    public static void insertSort(int [] nums){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j > 0  ; j--) {
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }
            }
        }
    }

    public static void bubbleSort(int [] nums){
        for (int i = nums.length -1; i > 0  ; i--) {
            for (int j = 0; j <i ; j++) {
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    /**
     *  每次找出 剩余数组中最小值的索引j 进行 swap(i,j) i++
     * @param nums
     */
    public static void selectSort(int [] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int index = i;
            for (int j = i; j < nums.length ; j++) {
                index = nums[j] < nums[index]? j:index;
            }
            swap(nums,i,index);
        }
    }

    /**
     *  堆排序
     *  以数组方式维护类似树结构的排列方式
     *  满足性质 array[i] <=  childL(i),childR(i)
     *  默认 小顶堆
     *
     *
     */
    public static void heapSort(int [] nums){

        int mid = nums.length  >> 1;
        //from mid reduce to 0
        //build heap
        for (int i = mid ; i >= 0 ; i--) {
            buildHeap(nums,i);
        }

        for (int i = nums.length -1; i >0 ; i--) {
            swap(nums,i,0);
            heapSort(nums,0,i);
        }

    }


    private static void heapSort(int[] nums,int index,int len){
        int childL = (index << 1) +1;
        // 不存在 左孩子 直接返回
        if(childL >= len) return;
        int minChildIndex = childL;
        // 存在右孩子
        if(childL +1 < len){
            minChildIndex = nums[childL] > nums[childL + 1]?childL +1:childL;
        }
        if(nums[minChildIndex]>=nums[index]) return;
        swap(nums,index,minChildIndex);
        heapSort(nums,minChildIndex,len);
    }
    /**
     *  构建堆
     * @param nums
     * @param i
     */
    private static  void buildHeap(int [] nums,int i){
        int mid = nums.length >> 1;
        if(i >= mid) return;
        int childR = (i<<1)+2;
        // find min(childL,childR)
        int childMinIndex = findChildMinIndex(nums,childR-1,childR);
        if(nums[childMinIndex]>=nums[i]) return;
        swap(nums,i,childMinIndex);
        buildHeap(nums,childMinIndex);
    }

    private static int findChildMinIndex(int []nums,int l,int r){
        if(r >= nums.length) return l;
        return nums[l]>nums[r] ? r:l;
    }

    /**
     *  important
     *  分治思想
     */
    public static void mergeSort(int [] nums){
        mergeSort(nums,0,nums.length - 1);
    }

    private static void mergeSort(int [] nums,int left,int right){
        if(left == right) return;
        if(right - left == 1){
            if(nums[left] > nums[right]){
                swap(nums,left,right);
            }
            return;
        }
        // divide
        int mid = (left + right) >> 1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        //combin [left,right]
        combinArraySortedPart(nums,left,mid,right);
    }

    private static void combinArraySortedPart(int [] nums,int left,int mid,int right){
        int [] tmp = new int [right - left +1];
        int k = 0,i = left,j = mid+1;
        for (;i <= mid && j <= right ;k++) {
            if(nums[i] > nums[j]){
                tmp[k] = nums[j];
                j++;
            }else {
                tmp[k] = nums[i];
                i++;
            }
        }
        // remain copy
        System.arraycopy(nums,i > mid?j:i ,tmp,k,tmp.length - k );
        System.arraycopy(tmp,0,nums,left,tmp.length);
    }

    private  static  void swap(int [] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     *  TOP K
     *  查找第K大元素
     *  这里默认为K 相对 整个数据组来讲很小
     *  所以可以维护一个 K 大小的优先队列来实现
     *  这里构建大顶堆，当 ele < heap[top] 元素 进行替换 堆顶元素 ，重新 sort构建直至结束
     *  时间复杂度 O(N*logK)
     *  1.
     * 利用快速排序的思想，从数组S中随机找出一个元素X，把数组分为两部分Sa和Sb。Sa中的元素大于等于X，Sb中元素小于X。这时有两种情况：
     *
     *       1. Sa中元素的个数小于k，则Sb中的第k-|Sa|个元素即为第k大数；
     *
     *       2. Sa中元素的个数大于等于k，则返回Sa中的第k大数。时间复杂度近似为O(n)
     *  2. BFPRT 5位算法
     *
     * 这种构建方式与直接在 数组上原地构建heap 方式并不一样，只需要进行 shift up/down 的维护即可
     */


    public static class MaxHeap{
        private int size;
        private int [] array;
        public MaxHeap(int cap){
            this.array = new int[cap];
        }


        public void add(int num){
            if(size < array.length){
                array[size] = num;
                shiftUp(array,size);
                size ++;
            }else {
                if(num < array[0]){
                    // replace
                    array[0] = num;
                    shiftDown(array,0,size);
                }
            }
        }

        public int getTop(){
            return array[0];
        }

        private void shiftUp(int [] nums,int index){
            int parent = (index -1 ) >> 1;
            if(parent < 0) return;
            if (array[parent] < array[index]){
                swap(array,parent,index);
                shiftUp(array,parent);
            }
        }

        private void shiftDown(int [] nums,int index,int len){
            int childL = (index << 1) + 1;
            if(childL >= len) return;
            int maxChildIndex = childL;
            if(childL +1 < len){
                maxChildIndex = array[childL] >= array[childL+1] ? childL:childL +1;
            }
            if(array[index] < array[maxChildIndex]){
                swap(array,index,maxChildIndex);
                shiftDown(array,maxChildIndex,len);
            }
        }






    }

    public static void main(String [] args){
        int [] nums  = {3,1,5,7,2,3,4,8,0,3,7,1,4,24,9,11};
        //bubbleSort(nums);
        //insertSort(nums);
        //selectSort(nums);
        //quickSort(nums);
        //mergeSort(nums);
        //heapSort(nums);

        MaxHeap maxHeap = new MaxHeap(10);

        for (int n : nums){
            maxHeap.add(n);
        }
        System.out.println(maxHeap.getTop());
    }
}
