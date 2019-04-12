package punch.day14.task;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-11 14:46
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class QuickMergeSort {

    public static void quickSort(int [] nums){
        quickSort(nums,0,nums.length-1);
    }


    public static void quickSort(int [] nums,int i ,int j){
        if(i >= j) return;
        int l = i,r = j;
        int pivot = nums[j];
        while (l < r){
            while (l < r && nums[l] < pivot){
                l++;
            }
            swap(nums,l,r);
            //maybe l = r or nums[r] >= pivot
            while (l < r && nums[r] >= pivot){
                r --;
            }
            swap(nums,l,r);
        }
        // l == r
        quickSort(nums,i,r-1);
        quickSort(nums,r+1,j);
    }

    public static void mergeSort(int[] nums){

    }

    public static void mergeSort(int [] nums,int i,int j){
        if(i >= j) return;
        if(i == j-1){
            // 两个就直接排序
        }
        int mid = i + (j-i) >> 1;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        //merge(nums,arraycopy(a),arraycopy(b));
    }
    private static void swap(int[] nums,int i,int j){
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // quicksort 分区的思想查找 数组中第K大元素
    // pivot 分区进行分治
    public static int findNumKMax(int []nums,int k){
        return k > nums.length ? -1:findKMax(nums,0,nums.length -1 ,k);
    }
    private static int findKMax(int [] nums,int i,int j,int k){
        int l = i,r = j;
        int pivot = nums[j];
        while (l < r){
            while (l < r && nums[l] < pivot){
                l++;
            }
            swap(nums,l,r);
            while (l < r && nums[r]>= pivot){
                r --;
            }
            swap(nums,l,r);
        }
        if(k == nums.length - l) return nums[l];
        if(k > nums.length -  l){
            return findKMax(nums,i,l -1,k);
        }else {
            return findKMax(nums,l+1,j,k);
        }
    }

    /**
     *
     * @param nums
     * @param v
     * @return nums index
     */
    public static  int BinarySearch(int [] nums,int v){
        int i = 0,j = nums.length -1;
        while (i <= j){
            int mid = i + ((j-i)>>1);
            if(nums[mid] == v) return mid;
            if(nums[mid] > v){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirst(int [] nums,int v){
        int i = 0,j = nums.length -1;
        while (i <= j){
            int mid = i + ((j-1)>>1);
            if(nums[mid] > v){
                j  = mid -1;
            }else if(nums[mid] < v){
                i = mid +1;
            }else {
                if(mid == 0|| nums[mid - 1] != v) return mid;
                j = mid - 1;
            }
        }
        return   -1;
    }

    public static int binarySearchLast(int []nums,int v){
        int i = 0,j = nums.length -1;
        while (i <= j){
            int mid  = i+ ((j-1)>>1);
            if(nums[mid] > v){
                j = mid - 1;
            }else if(nums[mid] < v){
                i = mid +1;
            }else {
                if(mid == nums.length -1 || nums[mid + 1] !=  v) return mid;
                i = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirstLargeOrEqual(int []nums,int v){
        int i = 0,j = nums.length -1;
        while (i <= j){
            int mid = i + ((j-1)>>1);
            if(nums[mid] >= v){
                if(mid ==0 || nums[mid -1] < v) return mid;
                j = mid - 1;
            }else {
                i = mid +1;
            }
        }
        //
        return  -1;

    }

    public static void main(String[] args){
        int [] nums = {8,10,2,3,6,1,5};
        quickSort(nums);
        System.out.println(nums[BinarySearch(nums,4)]);
       //System.out.println(findNumKMax(nums,8));
    }
}
