package punch.day7.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-18 18:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     0-1 背包问题以及 无限背包问题 都是可以用一套状态转移方程去解决
 *
 * <br>
 */
public class Leetcode416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        if((sum & 1) == 1) return false;
        sum = sum >> 1;
        HashMap<Integer, Boolean> memory = new HashMap<>();

        return dp(sum,nums,0,memory);
    }

    private boolean dp(int sum, int[] nums, int index, Map<Integer,Boolean> memory){
        if(sum == 0) return true;
        if(sum < 0 || index >= nums.length ) return false;
        if(memory.containsKey(sum)){
            return memory.get(sum);
        }


       boolean ok =dp(sum-nums[index],nums,index+1,memory) || dp(sum,nums,index+1,memory);
        memory.put(sum ,ok);
        return ok;
    }

}
