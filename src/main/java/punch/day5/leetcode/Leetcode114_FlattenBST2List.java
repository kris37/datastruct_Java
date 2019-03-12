package punch.day5.leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-11 20:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode114_FlattenBST2List {

     public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
     }

    /**
     * Runtime: 6 ms, faster than 99.92% of Java online submissions for Flatten Binary Tree to Linked List.
     * Memory Usage: 38.3 MB, less than 5.09% of Java online submissions for Flatten Binary Tree to Linked List.
     * @param root
     */
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) return;
        TreeNode cur = root;
        stack.push(root);
        boolean first = true;
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(first){
                first = false;
            }else {
                root.right = pop;
            }
            if(pop.right !=null) stack.push(pop.right);
            if(pop.left!=null) stack.push(pop.left);
            pop.left = pop.right = null;
            root = pop;
        }
    }
}
