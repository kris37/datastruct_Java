package punch.day5.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-11 22:18
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode112_PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 38.8 MB, less than 23.14% of Java online submissions for Path Sum.
     *  问题有问题shit
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left ==null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left,sum -root.val)
                || hasPathSum(root.right,sum -root.val);
    }
}
