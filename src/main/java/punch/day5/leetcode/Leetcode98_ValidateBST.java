package punch.day5.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-11 21:46
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode98_ValidateBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 40.4 MB, less than 5.01% of Java online submissions for Validate Binary Search Tree.
     *
     * 容易出现逻辑问题
     * BST cur.val  > max(cur.left) && cur.val < min(cur.right)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean flag = (root.left == null ||root.val > findMax(root.left) )
                && (root.right ==null || root.val < findMin(root.right));

        return flag && isValidBST(root.left) && isValidBST(root.right);
    }

    private int findMax(TreeNode node){
        while (node.right != null){
            node = node.right;
        }
        return node.val;
    }

    private int findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node.val;
    }
}
