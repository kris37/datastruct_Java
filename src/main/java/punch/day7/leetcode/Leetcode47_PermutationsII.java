package punch.day7.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-21 14:19
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     字典序生成
 *     1。递归实现 (对于多个重复的id 无法实现)
 *     2。字典序算法
 *     I) end 同start find first peak index [i]
 *     II) from end to i find first index j which num[j] > num[i]
 *     III) swap (i,j) then sort from [i,end]
 *     loop I)
 *
 * <br>
 */
public class Leetcode47_PermutationsII {



    /**
     *  字典序生成
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Permutations II.
     * Memory Usage: 40.2 MB, less than 48.32% of Java online submissions for Permutations II.
     * @param nums
     * @return
     */

    private int cur = -1;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums.length < 1) return result;
        Arrays.sort(nums);
        fill(nums,result);
        while (findPeak(nums) >= 0){
            int i = nums.length-1;
            int j = findFirstLargeThen(nums,cur);
            swap(nums,cur,j);
            j = cur +1;
            while (j < i ){
                swap(nums,i,j);
                j++;
                i--;
            }
            fill(nums,result);
        }
        return result;
    }


    /**
     * from end to start 找出第一个reduce 节点
     * 如果不存在 返回 -1
     * @param nums
     * @return
     */
    private int findPeak(int[] nums){
        for (int i = nums.length -1; i > 0; i--) {
            if(nums[i] > nums[i-1]){
                cur = i-1;
                return cur;
            }
        }
        cur = -1;
        return cur;
    }

    private int findFirstLargeThen(int[] nums,int index){
        if(index < 0 ) return -1;
        for (int i =  nums.length -1; i > 0; i--) {
            if(nums[i] > nums[index]) return i;
        }
        return -1;
    }

    private void fill(int[] nums,List<List<Integer>> result){
        LinkedList<Integer> cur = new LinkedList<>();
        for (int num : nums) {
            cur.add(num);
        }
        result.add(cur);
    }


    private void swap(int[] nums,int x,int y){
        int tmp = nums[x];
        nums[x]  = nums[y];
        nums[y] = tmp;
    }

}
