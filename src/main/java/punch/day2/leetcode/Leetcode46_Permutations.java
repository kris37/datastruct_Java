package punch.day2.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 * <br>
 */
public class Leetcode46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        permutationsByRecursive(0,nums,lists);
        return lists;
    }

    private void permutationsByRecursive(int index,int[] nums,List<List<Integer>> res){
        if(index == nums.length){
            List<Integer> cur = new ArrayList<>(nums.length);
            for (int num : nums) {
                cur.add(num);
            }
            res.add(cur);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            swap(nums,index,i);
            permutationsByRecursive(index +1,nums,res);
            swap(nums,index,i);
        }
    }

    private void swap(int[] nums ,int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
