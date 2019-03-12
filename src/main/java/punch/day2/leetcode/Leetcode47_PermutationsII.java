package punch.day2.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-04 19:15
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     全排列算法
 *     1. Recursive
 *     2. 字典序生成算法
 *     实现字典序算法
 *     refer :
 *     字典序法
 * 字典序，就是将元素按照字典的顺序（a-z, 1-9）进行排列。以字典的顺序作为比较的依据，可以比较出两个串的大小。比如 "1" < "13"<"14"<"153"，
 * 就是按每个数字位逐个比较的结果。对于一个串“123456789”， 可以知道最小的串是“123456789”，而最大的串“987654321”。
 * 这样针对这个串以字典序法生成全排列生成全排列，就是依次生成“123456789”->“123456798”->......->"987654312"->"987654321"这样的串。
 * 字典序法要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。[2]
 *
 * 算法步骤
 * 设P是集合{1，2，……n-1，n}的一个全排列：P=P1P2……Pj-1PjPj+1……Pn（1≤P1，P2，……，Pn≤n-1）
 *
 * 1.从排列的右端开始，找出第一个比右边数字小的数字的序号j，即j=max{i|Pi<Pi+1，i>j}
 * 2.在Pj的右边的数字中，找出所有比Pj大的数字中最小的数字Pk，即k=min{i|Pi>Pj，i>j}
 * 3.交换Pi，Pk
 * 4.再将排列右端的递减部分Pj+1Pj+2……Pn倒转，因为j右端的数字是降序，所以只需要其左边和右边的交换，直到中间，
 * 因此可以得到一个新的排列P'=P1P2……Pj-1PkPn……Pj+2Pj+1。
 *
 * 算法正确性证明
 * 证明它可以生成所有的排列只需要证明生成的下一个排序恰好比当前排列大的一个序列即可。
 * 对于任意j，作为从右端开始第一个小于左边数字的数，可以得到序列Pj+1，...Pn是降序排列，
 * 选择其中大于Pj的最小的数字Pk，与其交换，然后再对后面排序得到序列P1，...Pj-1Pk...Pn，恰好比P1...Pj-1Pj...Pn大一点的下一个排列，因此算法可以生成全排列。
 * <br>
 */
public class Leetcode47_PermutationsII {

    /**
     * Runtime: 3 ms, faster than 98.15% of Java online submissions for Permutations II.
     * Memory Usage: 41.7 MB, less than 16.57% of Java online submissions for Permutations II.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        boolean first = true;
        do{
            if(first) {
                first = false;
            }else {
                next(nums);
            }
            List<Integer> tmp = new ArrayList<>(nums.length);
            for (int num : nums) {
                tmp.add(num);
            }
            lists.add(tmp);
        } while(hasNext(nums));


        return lists;
    }

    /**
     *
     * @param nums
     * @return boolean 是否存在下一个字典序排列
     */
    private boolean hasNext(int[] nums){
        for (int i = nums.length -1 ; i >0 ; i--) {
            if(nums[i] > nums[i-1]) return true;
        }
        return false;
    }

    /**
     *  字典序算法
     * @param nums
     * @return
     */
    private void next(int[] nums){
        //1 . from right -> left find first index i: which nums[i]<nums[i+1]
        //2 .from right -> i find first index j: which nums[j] > num[i] max(j) = i+1
        //3 swap(i,j)
        //4 then next
        for (int i = nums.length -2 ; i >= 0 ; i--) {
            if(nums[i] < nums[i+1]){
                for (int j = nums.length - 1; j > i ; j--) {
                  if(nums[j] > nums[i]){
                      swap(nums,i,j);
                      // reverse num[i+1,n]
                      for (int p = i+1,k = nums.length -1; p < k;p++,k--){
                          swap(nums,p,k);
                      }
                      break;
                  }
                }
                break;
            }
        }
        return ;
    }
    private void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void  main (String [] args) {
        Leetcode47_PermutationsII leetcode47_permutationsII = new Leetcode47_PermutationsII();
        int [] nums = {1,2,3};
        System.out.print(leetcode47_permutationsII.permuteUnique(nums).toString());



    }


}
